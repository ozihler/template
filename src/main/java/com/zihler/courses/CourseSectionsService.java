package com.zihler.courses;

import com.zihler.courses.dataaccess.CourseSection;
import com.zihler.courses.dataaccess.CourseSectionsRepository;
import com.zihler.courses.dataaccess.CoursesRepository;
import com.zihler.courses.transfer.CourseSectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("courseSectionsService")
@Transactional
public class CourseSectionsService {

    private CoursesRepository coursesRepository;
    private CourseSectionsRepository courseSectionsRepository;

    @Autowired
    public CourseSectionsService(CoursesRepository coursesRepository, CourseSectionsRepository courseSectionsRepository) {
        this.coursesRepository = coursesRepository;
        this.courseSectionsRepository = courseSectionsRepository;
    }

    public CourseSectionDto createCourseSection(CourseSectionDto courseSectionDto) {
        return this.coursesRepository.findById(courseSectionDto.getCourseId())
                .map(course -> CourseSection.from(course, courseSectionDto))
                .map(courseSectionsRepository::save)
                .map(CourseSectionDto::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", courseSectionDto.getCourseId())));
    }

    public CourseSectionDto deleteCourseSection(long id) {
        CourseSection courseSection = courseSectionsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course section with id %d", id)));

        courseSectionsRepository.delete(courseSection);

        return CourseSectionDto.createFrom(courseSection);
    }

    public List<CourseSectionDto> getAllCourseSectionsForCourse(long courseId) {
        return courseSectionsRepository.findByCourseIdOrderByIdAsc(courseId)
                .stream()
                .map(CourseSectionDto::createFrom)
                .collect(Collectors.toList());
    }

    public CourseSectionDto getCourseSection(long id) {
        return courseSectionsRepository.findById(id)
                .map(CourseSectionDto::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course section with id %d", id)));
    }

    public CourseSectionDto updateCourseSection(long id, CourseSectionDto courseSectionDto) {
        return courseSectionsRepository.findById(id)
                .map(courseSection -> courseSection.updateCourseSection(courseSectionDto))
                .map(courseSectionsRepository::save)
                .map(CourseSectionDto::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course section with id %d", id)));
    }
}
