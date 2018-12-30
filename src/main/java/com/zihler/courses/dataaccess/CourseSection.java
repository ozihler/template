package com.zihler.courses.dataaccess;

import com.zihler.courses.transfer.CourseSectionData;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import javax.persistence.*;
import java.util.List;

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

    public static CourseSection from(Course savedCourse, CourseSectionData courseSectionData) {
        CourseSection courseSection = new CourseSection();
        courseSection.setSectionTitle(courseSectionData.getSectionTitle());
        courseSection.setSectionMarkdown(courseSectionData.getSectionMarkdown());
        courseSection.setCourse(savedCourse);
        return courseSection;
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

    public CourseSection updateCourseSection(List<CourseSectionData> courseSectionData) {
        CourseSectionData courseSectionDataToUpdate = findCourseSectionDataToUpdate(courseSectionData);
        setSectionTitle(courseSectionDataToUpdate.getSectionTitle());
        setSectionMarkdown(courseSectionDataToUpdate.getSectionMarkdown());
        return this;
    }

    private CourseSectionData findCourseSectionDataToUpdate(List<CourseSectionData> courseSectionsDataToUpdate) {
        return courseSectionsDataToUpdate.stream()
                .filter(courseSectionDataToUpdate -> courseSectionDataToUpdate.getId() == getId())
                .findFirst()
                .orElseThrow(() -> courseSectionNotFoundException());
    }

    private ResourceNotFoundException courseSectionNotFoundException() {
        return new ResourceNotFoundException(String.format("Could not find course section with id %d for course with id %d",
                getId(), getCourse().getId()));
    }
}
