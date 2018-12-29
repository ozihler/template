package com.zihler.courses;

import com.zihler.courses.output.Course;
import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Preview;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("coursesService")
public class CoursesService {

    private List<Preview> previews;
    private Map<Long, Course> courses = new HashMap<>();
    private long courseCounter = 1;

    public CoursesService() {
        previews = createPreviews();
    }

    List<Preview> getPreviews() {
        return previews;
    }

    MaxRating getCurrentMaxRating() {
        return new MaxRating(5);
    }

    List<Preview> getPreviewsFilteredBy(String query) {
        return previews.stream()
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
        List<Preview> previews = new ArrayList<>();

        for (int courseId = 0; courseId < 50; courseId++) {
            String startText = getStartText(courseId);
            previews.add(
                    new Preview(
                            courseId,
                            String.format("%s Title %d", startText, courseId),
                            String.format("%s Description %d", startText, courseId),
                            String.format("courses/course/%d", courseId),
                            new Random().nextInt(5) + 1
                    )
            );
        }

        return previews;
    }

    private String getStartText(int courseId) {
        if (courseId % 3 == 0) {
            return "Clean Code";
        }
        if (courseId % 3 == 1) {
            return "Legacy Code";
        }
        if (courseId % 3 == 2) {
            return "Domain Driven Design";
        }
        return "Unknown";
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
