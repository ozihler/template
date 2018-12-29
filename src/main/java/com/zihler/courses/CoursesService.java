package com.zihler.courses;

import com.zihler.courses.output.Course;
import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Preview;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("coursesService")
public class CoursesService {
    private long courseCounter = 1;

    private Map<Long, Course> courses = new HashMap<>();

    public CoursesService() {
    }

    List<Preview> getPreviews() {
        return createPreviews();
    }

    MaxRating getCurrentMaxRating() {
        return new MaxRating(5);
    }

    List<Preview> getPreviewsFilteredBy(String query) {
        return createPreviews()
                .stream()
                .filter(preview -> filterTexts(query, preview))
                .collect(Collectors.toList());
    }

    private boolean filterTexts(String query, Preview preview) {
        return filter(preview.getTitle(), query) || filter(preview.getDescription(), query);
    }

    private boolean filter(String description, String query) {
        return description.toLowerCase().contains(query.toLowerCase());
    }

    private List<Preview> createPreviews() {
        return this.courses.values().stream()
                .map(Preview::createPreviewFrom)
                .collect(Collectors.toList());

    }

    Optional<Course> getCourse(long id) {
        return Optional.of(courses.get(id));
    }

    Course store(Course course) {
        long courseId = this.courseCounter++;
        this.courses.put(courseId, createCourse(course, courseId));
        return this.courses.get(courseId);
    }

    private Course createCourse(Course course, long courseId) {
        return new Course(
                courseId,
                course.getTitle(),
                course.getDescription(),
                course.getThumbnailUrl(),
                course.getRating(),
                course.getCourseSections() == null ? new ArrayList<>() : course.getCourseSections()
        );
    }

    Course store(long id, Course course) {
        this.courses.put(id, createCourse(course, id));
        return this.courses.get(id);
    }
}
