package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.CourseSection;

public class CourseSectionData {
    private long id;
    private String sectionTitle;
    private String sectionMarkdown;

    public CourseSectionData() {

    }

    private CourseSectionData(long id, String sectionTitle, String sectionMarkdown) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.sectionMarkdown = sectionMarkdown;
    }

    public static CourseSectionData createFrom(CourseSection courseSection) {
        return new CourseSectionData(courseSection.getId(), courseSection.getSectionTitle(), courseSection.getSectionTitle());
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

    @Override
    public String toString() {
        return "CourseSectionData{" +
                "id=" + id +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", sectionMarkdown='" + sectionMarkdown + '\'' +
                '}';
    }
}
