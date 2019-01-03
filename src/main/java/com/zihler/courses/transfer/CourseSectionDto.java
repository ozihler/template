package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.CourseSection;

public class CourseSectionDto {
    private long id;
    private String title;
    private String markdown;
    private long courseId;

    public CourseSectionDto() {

    }

    private CourseSectionDto(long id, String title, String markdown, long courseId) {
        this.id = id;
        this.title = title;
        this.markdown = markdown;
        this.courseId = courseId;
    }

    public static CourseSectionDto createFrom(CourseSection courseSection) {
        return new CourseSectionDto(courseSection.getId(),
                courseSection.getTitle(),
                courseSection.getMarkdown(),
                courseSection.getCourse().getId());
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMarkdown() {
        return markdown;
    }

    public Long getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "CourseSectionData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", markdown='" + markdown + '\'' +
                '}';
    }
}
