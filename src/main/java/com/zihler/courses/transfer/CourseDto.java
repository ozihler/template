package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.Course;

public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;

    public CourseDto() {
    }

    private CourseDto(long id, String title, String description, String thumbnailUrl, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
    }

    public static CourseDto createFrom(Course course) {
        return new CourseDto(course.getId(), course.getTitle(), course.getDescription(), course.getThumbnailUrl(), course.getRating());
    }

    public Long getId() {
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

    @Override
    public String toString() {
        return "CourseData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", rating=" + rating +
                '}';
    }
}
