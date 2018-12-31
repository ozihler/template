package com.zihler.courses;

import com.zihler.courses.dataaccess.Course;
import com.zihler.courses.dataaccess.CoursesRepository;
import com.zihler.courses.transfer.CourseDto;
import com.zihler.courses.transfer.MaxRatingDto;
import com.zihler.courses.transfer.PreviewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service("coursesService")
@Transactional
public class CoursesService {

    private static final MaxRatingDto CURRENT_MAX_RATING = new MaxRatingDto(5);// TODO: 30.12.2018 Move to own service
    private final Logger logger = LoggerFactory.getLogger(CoursesService.class);
    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    List<PreviewDto> getPreviews() {
        List<PreviewDto> previews = PreviewDto.createPreviews(this.coursesRepository.findAll());
        logger.info(String.format("Get previews %s.", previews));
        return previews;
    }

    MaxRatingDto getCurrentMaxRating() {
        logger.info(String.format("Get max rating %s.", CURRENT_MAX_RATING));
        return CURRENT_MAX_RATING;
    }

    List<PreviewDto> getPreviewsFilteredBy(String query) {
        List<PreviewDto> filteredPreviews = filterPreviewsUsing(query);
        logger.info(String.format("Get filtered previews for query %s: %s.", query, filteredPreviews));
        return filteredPreviews;
    }

    private List<PreviewDto> filterPreviewsUsing(String query) {
        return PreviewDto.createPreviews(this.coursesRepository.findAll())
                .stream()
                .filter(previewDto -> filterTexts(query, previewDto))
                .collect(toList());
    }

    private boolean filterTexts(String query, PreviewDto previewDto) {
        return filter(previewDto.getTitle(), query) || filter(previewDto.getDescription(), query);
    }

    private boolean filter(String description, String query) {
        return description.toLowerCase().contains(query.toLowerCase());
    }

    CourseDto getCourse(long courseId) {
        CourseDto courseDto = collectCourseDataFor(courseId);
        logger.info(String.format("get course with id %d: %s", courseId, courseDto));
        return courseDto;
    }

    private CourseDto collectCourseDataFor(long id) {
        return coursesRepository.findById(id)
                .map(CourseDto::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

    CourseDto createFrom(CourseDto courseDto) {
        Course savedCourse = saveCourse(courseDto);
        CourseDto savedCourseDto = CourseDto.createFrom(savedCourse);
        logger.info(String.format("Saved course: %s", savedCourseDto));
        return savedCourseDto;
    }

    CourseDto update(long id, CourseDto courseDto) {
        Course updatedCourse = updateCourse(id, courseDto);
        CourseDto updatedCourseDto = CourseDto.createFrom(updatedCourse);
        logger.info(String.format("Updated course: %s", updatedCourseDto));
        return updatedCourseDto;
    }

    private Course saveCourse(CourseDto courseDto) {
        Course course = Course.from(courseDto);
        return this.coursesRepository.save(course);
    }

    private Course updateCourse(long id, CourseDto courseDto) {
        return this.coursesRepository.findById(id)
                .map(course -> course.updateCourse(courseDto))
                .map(coursesRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

}
