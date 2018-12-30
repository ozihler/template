package com.zihler.courses;

import com.zihler.courses.dataaccess.Course;
import com.zihler.courses.dataaccess.CourseSection;
import com.zihler.courses.dataaccess.CourseSectionsRepository;
import com.zihler.courses.dataaccess.CoursesRepository;
import com.zihler.courses.transfer.CourseData;
import com.zihler.courses.transfer.CourseSectionData;
import com.zihler.courses.transfer.MaxRatingData;
import com.zihler.courses.transfer.PreviewData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service("coursesService")
public class CoursesService {

    private static final MaxRatingData CURRENT_MAX_RATING = new MaxRatingData(5);// TODO: 30.12.2018 Move to own service
    private final Logger logger = LoggerFactory.getLogger(CoursesService.class);
    private final CoursesRepository coursesRepository;
    private final CourseSectionsRepository courseSectionsRepository;

    @Autowired
    public CoursesService(CoursesRepository coursesRepository, CourseSectionsRepository courseSectionsRepository) {
        this.coursesRepository = coursesRepository;
        this.courseSectionsRepository = courseSectionsRepository;
    }

    List<PreviewData> getPreviews() {
        List<PreviewData> previews = PreviewData.createPreviews(this.coursesRepository.findAll());
        logger.info(String.format("Get previews %s.", previews));
        return previews;
    }

    MaxRatingData getCurrentMaxRating() {
        logger.info(String.format("Get max rating %s.", CURRENT_MAX_RATING));
        return CURRENT_MAX_RATING;
    }

    List<PreviewData> getPreviewsFilteredBy(String query) {
        List<PreviewData> filteredPreviews = filterPreviewsUsing(query);
        logger.info(String.format("Get filtered previews for query %s: %s.", query, filteredPreviews));
        return filteredPreviews;
    }

    private List<PreviewData> filterPreviewsUsing(String query) {
        return PreviewData.createPreviews(this.coursesRepository.findAll())
                .stream()
                .filter(previewData -> filterTexts(query, previewData))
                .collect(toList());
    }

    private boolean filterTexts(String query, PreviewData previewData) {
        return filter(previewData.getTitle(), query) || filter(previewData.getDescription(), query);
    }

    private boolean filter(String description, String query) {
        return description.toLowerCase().contains(query.toLowerCase());
    }

    CourseData getCourse(long courseId) {
        CourseData courseData = collectCourseDataFor(courseId);
        logger.info(String.format("get course with id %d: %s", courseId, courseData));
        return courseData;
    }

    private CourseData collectCourseDataFor(long id) {
        List<CourseSection> courseSectionsOfCourse = courseSectionsRepository.findByCourseId(id);

        return coursesRepository.findById(id)
                .map(course -> CourseData.createFrom(course, courseSectionsOfCourse))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

    CourseData createFrom(CourseData courseData) {
        Course savedCourse = saveCourse(courseData);
        List<CourseSection> saveCourseSections = saveCourseSections(savedCourse, courseData.getCourseSections());
        CourseData savedCourseData = CourseData.createFrom(savedCourse, saveCourseSections);
        logger.info(String.format("Saved course: %s", savedCourseData));
        return savedCourseData;
    }

    private Course saveCourse(CourseData courseData) {
        Course course = Course.from(courseData);
        return this.coursesRepository.save(course);
    }

    private List<CourseSection> saveCourseSections(Course savedCourse, List<CourseSectionData> courseSectionsData) {
        return courseSectionsData
                .stream()
                .map(courseSectionData -> CourseSection.from(savedCourse, courseSectionData))
                .map(courseSectionsRepository::save)
                .collect(toList());
    }

    CourseData update(long id, CourseData courseData) {
        Course updatedCourse = updateCourse(id, courseData);
        List<CourseSectionData> courseSectionsData = courseData.getCourseSections();
        List<CourseSection> updatedCourseSections = updateCourseSections(id, updatedCourse, courseSectionsData);
        CourseData updatedCourseData = CourseData.createFrom(updatedCourse, updatedCourseSections);
        logger.info(String.format("Updated course: %s", updatedCourseData));
        return updatedCourseData;
    }

    // TODO: 30.12.2018 Move to own service! (everything related to course section)
    private List<CourseSection> updateCourseSections(long id, Course updatedCourse, List<CourseSectionData> courseSectionsData) {
        if (CollectionUtils.isEmpty(courseSectionsData)) {
            return new ArrayList<>();
        }
        List<CourseSection> courseSections = this.courseSectionsRepository.findByCourseId(id);
        if (thereExistNewCourseSections(courseSectionsData, courseSections)) {
            List<CourseSectionData> newCourseSectionData = findNewCourseSectionData(courseSectionsData, courseSections);
            saveCourseSections(updatedCourse, newCourseSectionData);
        }

        if (courseSectionsWereDeleted(courseSectionsData, courseSections)) {
            List<CourseSection> courseSectionsToDelete = findDeletedCourseSectionData(courseSectionsData, courseSections);
            deleteCourseSections(courseSectionsToDelete);
        }
        //  TODO: 30.12.2018 Something fishy here... not working as it should. And: have a global ExceptionHandler!
        courseSections = this.courseSectionsRepository.findByCourseId(id);
        List<CourseSection> updatedCourseSections = updateCourseSections(courseSectionsData, courseSections);
        updatedCourseSections.sort(Comparator.comparing(CourseSection::getId));
        return updatedCourseSections;
    }

    private void deleteCourseSections(List<CourseSection> courseSectionsToDelete) {
        this.courseSectionsRepository.deleteAll(courseSectionsToDelete);
    }

    private List<CourseSection> findDeletedCourseSectionData(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return courseSections.stream()
                .filter(courseSection -> !containedIn(courseSection, courseSectionsData))
                .collect(toList());
    }

    private boolean containedIn(CourseSection courseSection, List<CourseSectionData> courseSectionsData) {
        return courseSectionsData.stream()
                .anyMatch(courseSectionData -> courseSectionData.getId() == courseSection.getId());
    }

    private boolean courseSectionsWereDeleted(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return courseSectionsData.size() < courseSections.size();
    }

    private List<CourseSectionData> findNewCourseSectionData(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return courseSectionsData.stream()
                .filter(courseSectionData -> !containedIn(courseSections, courseSectionData))
                .collect(toList());
    }

    private boolean containedIn(List<CourseSection> courseSections, CourseSectionData courseSectionData) {
        return courseSections.stream()
                .anyMatch(courseSection -> courseSection.getId().equals(courseSectionData.getId()));
    }

    private boolean thereExistNewCourseSections(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return CollectionUtils.isEmpty(courseSections) || courseSections.size() < courseSectionsData.size();
    }

    private List<CourseSection> updateCourseSections(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return courseSections
                .stream()
                .map(courseSection -> courseSection.updateCourseSection(courseSectionsData))
                .map(this.courseSectionsRepository::save)
                .collect(toList());
    }

    private Course updateCourse(long id, CourseData courseData) {
        return this.coursesRepository.findById(id)
                .map(course -> course.updateCourse(courseData))
                .map(coursesRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

}
