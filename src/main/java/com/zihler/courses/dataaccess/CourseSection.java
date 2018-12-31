package com.zihler.courses.dataaccess;

import com.zihler.courses.transfer.CourseSectionDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "course_section")
@TableGenerator(name = "course_section_table_generator")
public class CourseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course_section_table_generator")
    private Long id;

    private String sectionTitle;
    private String sectionMarkdown;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    public static CourseSection from(Course course, CourseSectionDto courseSectionDto) {
        CourseSection courseSection = new CourseSection();
        courseSection.setSectionTitle(courseSectionDto.getSectionTitle());
        courseSection.setSectionMarkdown(courseSectionDto.getSectionMarkdown());
        courseSection.setCourse(course);
        return courseSection;
    }

    public CourseSection updateCourseSection(CourseSectionDto courseSectionData) {
        setSectionTitle(courseSectionData.getSectionTitle());
        setSectionMarkdown(courseSectionData.getSectionMarkdown());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionMarkdown() {
        return sectionMarkdown;
    }

    public void setSectionMarkdown(String sectionMarkdown) {
        this.sectionMarkdown = sectionMarkdown;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
