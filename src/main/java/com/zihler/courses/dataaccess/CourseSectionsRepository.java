package com.zihler.courses.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO: 30.12.2018 Course Sections should be updated independent of Course! Also in Frontend
public interface CourseSectionsRepository extends JpaRepository<CourseSection, Long> {
    List<CourseSection> findByCourseIdOrderByIdAsc(Long courseId);
}
