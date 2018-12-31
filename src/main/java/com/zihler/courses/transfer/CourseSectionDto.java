package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.CourseSection;

public class CourseSectionDto {
    private long id;
    private String sectionTitle;
    private String sectionMarkdown;
    private long courseId;

    public CourseSectionDto() {

    }

    private CourseSectionDto(long id, String sectionTitle, String sectionMarkdown, long courseId) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.sectionMarkdown = sectionMarkdown;
        this.courseId = courseId;
    }

    public static CourseSectionDto createFrom(CourseSection courseSection) {
        return new CourseSectionDto(courseSection.getId(),
                courseSection.getSectionTitle(),
                courseSection.getSectionMarkdown(),
                courseSection.getCourse().getId());
    }

    public long getId() {
        return id;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public String getSectionMarkdown() {
        return sectionMarkdown;
    }

    public Long getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "CourseSectionData{" +
                "id=" + id +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", sectionMarkdown='" + sectionMarkdown + '\'' +
                '}';
    }
}
