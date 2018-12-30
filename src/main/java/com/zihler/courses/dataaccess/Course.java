package com.zihler.courses.dataaccess;

import com.zihler.courses.transfer.CourseData;

import javax.persistence.*;

@Entity
@Table(name = "course")
@TableGenerator(name = "course_table_generator")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course_table_generator")
    private Long id;

    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;

    public static Course from(CourseData courseData) {
        Course course = new Course();
        course.setTitle(courseData.getTitle());
        course.setDescription(courseData.getDescription());
        course.setThumbnailUrl(course.getThumbnailUrl());
        course.setRating(course.getRating());
        return course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Course updateCourse(CourseData courseData) {
        setTitle(courseData.getTitle());
        setDescription(courseData.getDescription());
        setThumbnailUrl(courseData.getThumbnailUrl());
        setRating(courseData.getRating());
        return this;
    }
}
