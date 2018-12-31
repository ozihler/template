package com.zihler.courses;

import com.zihler.courses.transfer.CourseSectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/courseSections",
        produces = "application/json;charset=UTF-8")
public class CourseSectionsController {

    private CourseSectionsService courseSectionsService;

    @Autowired
    public CourseSectionsController(CourseSectionsService courseSectionsService) {
        this.courseSectionsService = courseSectionsService;
    }

    @PostMapping
    public CourseSectionDto createCourseSection(@RequestBody CourseSectionDto courseSectionDto) {
        return courseSectionsService.createCourseSection(courseSectionDto);
    }

    @DeleteMapping(path = "/{id}")
    public CourseSectionDto delete(@PathVariable("id") long id) {
        return courseSectionsService.deleteCourseSection(id);
    }

    @GetMapping(path = "/course/{courseId}")
    public List<CourseSectionDto> getAllCourseSectionsForCourse(@PathVariable("courseId") long courseId) {
        return courseSectionsService.getAllCourseSectionsForCourse(courseId);
    }

    @GetMapping(path = "/{id}")
    public CourseSectionDto getCourseSection(@PathVariable("id") long id) {
        return courseSectionsService.getCourseSection(id);
    }

    @PutMapping(path = "/{id}")
    public CourseSectionDto updateCourseSection(@PathVariable("id") long id, @RequestBody CourseSectionDto courseSectionDto) {
        return courseSectionsService.updateCourseSection(id, courseSectionDto);
    }
}

