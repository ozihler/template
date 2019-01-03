package com.zihler.courses.dataaccess;

import com.zihler.courses.transfer.CourseDto;

import javax.persistence.*;

@Entity
@Table(name = "course")
@TableGenerator(name = "course_table_generator")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course_table_generator")
    @Column(name = "course_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    @Column(name="rating_id")
    private Long rating;

    public static Course from(CourseDto courseDto) {
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setThumbnailUrl(courseDto.getThumbnailUrl());
        course.setRating(courseDto.getRating());
        return course;
    }

    public Course updateCourse(CourseDto courseDto) {
        setTitle(courseDto.getTitle());
        setDescription(courseDto.getDescription());
        setThumbnailUrl(courseDto.getThumbnailUrl());
        setRating(courseDto.getRating());
        return this;
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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
