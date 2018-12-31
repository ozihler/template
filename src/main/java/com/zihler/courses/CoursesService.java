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

    List<PreviewDto> getPreviews() {// TODO: 30.12.2018 Move to own service
        List<PreviewDto> previews = PreviewDto.createPreviews(this.coursesRepository.findAll());
        logger.info(String.format("Get previews %s.", previews));
        return previews;
    }

    MaxRatingDto getCurrentMaxRating() {// TODO: 30.12.2018 Move to own service
        logger.info(String.format("Get max rating %s.", CURRENT_MAX_RATING));
        return CURRENT_MAX_RATING;
    }

    List<PreviewDto> getPreviewsFilteredBy(String query) {// TODO: 30.12.2018 Move to own service
        List<PreviewDto> filteredPreviews = filterPreviewsUsing(query);
        logger.info(String.format("Get filtered previews for query %s: %s.", query, filteredPreviews));
        return filteredPreviews;
    }

    private List<PreviewDto> filterPreviewsUsing(String query) {// TODO: 30.12.2018 Move to own service
        return PreviewDto.createPreviews(this.coursesRepository.findAll())
                .stream()
                .filter(previewDto -> filterTexts(query, previewDto))
                .collect(toList());
    }

    private boolean filterTexts(String query, PreviewDto previewDto) {// TODO: 30.12.2018 Move to own service
        return filter(previewDto.getTitle(), query) || filter(previewDto.getDescription(), query);
    }

    private boolean filter(String description, String query) {// TODO: 30.12.2018 Move to own service
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
                .orElseThrow(() -> throwCourseNotFoundException(id));
    }

    CourseDto createCourse(CourseDto courseDto) {
        Course course = Course.from(courseDto);
        Course savedCourse = this.coursesRepository.save(course);
        CourseDto savedCourseDto = CourseDto.createFrom(savedCourse);
        logger.info(String.format("Saved course: %s", savedCourseDto));
        return savedCourseDto;
    }

    CourseDto update(long id, CourseDto courseDto) {
        CourseDto updatedCourseDto = this.coursesRepository.findById(id)
                .map(course -> course.updateCourse(courseDto))
                .map(coursesRepository::save)
                .map(CourseDto::createFrom)
                .orElseThrow(() -> throwCourseNotFoundException(id));

        logger.info(String.format("Updated course: %s", updatedCourseDto));
        return updatedCourseDto;
    }

    public List<CourseDto> getAllCourses() {
        return coursesRepository.findAllByOrderByIdAsc()
                .stream()
                .map(CourseDto::createFrom)
                .collect(toList());
    }

    public CourseDto deleteCourse(long id) {
        Course courseToDelete = coursesRepository.findById(id)
                .orElseThrow(() -> throwCourseNotFoundException(id));

        coursesRepository.delete(courseToDelete);

        return CourseDto.createFrom(courseToDelete);
    }

    private ResourceNotFoundException throwCourseNotFoundException(long id) {
        return new ResourceNotFoundException(String.format("Could not find course with id %d", id));
    }
}
