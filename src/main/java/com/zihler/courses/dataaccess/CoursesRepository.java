package com.zihler.courses.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByOrderByIdAsc();
}
