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
    @Column(name = "course_section_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "markdown")
    private String markdown;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    public static CourseSection from(Course course, CourseSectionDto courseSectionDto) {
        CourseSection courseSection = new CourseSection();
        courseSection.setTitle(courseSectionDto.getTitle());
        courseSection.setMarkdown(courseSectionDto.getMarkdown());
        courseSection.setCourse(course);
        return courseSection;
    }

    public CourseSection updateCourseSection(CourseSectionDto courseSectionData) {
        setTitle(courseSectionData.getTitle());
        setMarkdown(courseSectionData.getMarkdown());
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

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
