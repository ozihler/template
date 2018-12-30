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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service("coursesService")
public class CoursesService {
    private final Logger logger = LoggerFactory.getLogger(CoursesService.class);
    private final CoursesRepository coursesRepository;
    private final CourseSectionsRepository courseSectionsRepository;

    private Map<Long, CourseData> courses = new HashMap<>();

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
        MaxRatingData maxRatingData = new MaxRatingData(5);
        logger.info(String.format("Get max rating %s.", maxRatingData));
        return maxRatingData;
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
                .map(courseSection -> courseSectionsRepository.save(courseSection))
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

    private List<CourseSection> updateCourseSections(long id, Course updatedCourse, List<CourseSectionData> courseSectionsData) {
        if (CollectionUtils.isEmpty(courseSectionsData)) {
            return Collections.EMPTY_LIST;
        }
        List<CourseSection> courseSections = this.courseSectionsRepository.findByCourseId(id);
        if (thereExistNewCourseSections(courseSectionsData, courseSections)) {
            return saveCourseSections(updatedCourse, courseSectionsData);
        }

        return updateCourseSections(courseSectionsData, courseSections);
    }

    private boolean thereExistNewCourseSections(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return CollectionUtils.isEmpty(courseSections) || courseSections.size() < courseSectionsData.size();
    }

    private List<CourseSection> updateCourseSections(List<CourseSectionData> courseSectionsData, List<CourseSection> courseSections) {
        return courseSections
                .stream()
                .map(courseSection -> courseSection.updateCourseSection(courseSectionsData))
                .map(courseSection -> this.courseSectionsRepository.save(courseSection))
                .collect(toList());
    }

    private Course updateCourse(long id, CourseData courseData) {
        return this.coursesRepository.findById(id)
                .map(course -> course.updateCourse(courseData))
                .map(course -> coursesRepository.save(course))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

}
