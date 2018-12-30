package com.zihler.courses.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSectionsRepository extends JpaRepository<CourseSection, Long> {
    List<CourseSection> findByCourseId(Long courseId);
}
