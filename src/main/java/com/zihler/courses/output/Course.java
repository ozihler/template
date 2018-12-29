package com.zihler.courses.output;

import java.util.List;

public class Course {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;
    private List<CourseSection> courseSections;

    public Course() {
    }

    public Course(long id, String title, String description, String thumbnailUrl, int rating, List<CourseSection> courseSections) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.courseSections = courseSections;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public int getRating() {
        return rating;
    }

    public List<CourseSection> getCourseSections() {
        return courseSections;
    }
}
