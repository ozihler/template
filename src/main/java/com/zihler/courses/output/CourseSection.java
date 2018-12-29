package com.zihler.courses.output;

public class CourseSection {
    private long id;
    private String sectionTitle;
    private String sectionMarkdown;

    public CourseSection() {

    }

    public CourseSection(long id, String sectionTitle, String sectionMarkdown) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.sectionMarkdown = sectionMarkdown;
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
}
