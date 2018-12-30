package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.Course;
import com.zihler.courses.dataaccess.CourseSection;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CourseData {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;
    private List<CourseSectionData> courseSections;

    public CourseData() {
    }

    private CourseData(long id, String title, String description, String thumbnailUrl, int rating, List<CourseSectionData> courseSections) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
        this.courseSections = courseSections;
    }

    public static CourseData createFrom(Course course, List<CourseSection> courseSections) {
        List<CourseSectionData> courseSectionData = courseSections.stream()
                .map(courseSection -> CourseSectionData.createFrom(courseSection))
                .collect(toList());
        return new CourseData(course.getId(), course.getTitle(), course.getDescription(), course.getThumbnailUrl(), course.getRating(), courseSectionData);
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

    public List<CourseSectionData> getCourseSections() {
        return courseSections;
    }

    public void setCourseSections(List<CourseSectionData> courseSections) {
        this.courseSections = courseSections;
    }

    @Override
    public String toString() {
        return "CourseData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", rating=" + rating +
                ", courseSectionData=" + courseSections +
                '}';
    }
}
