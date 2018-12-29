package com.zihler.courses;

import com.zihler.courses.output.Course;
import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Preview;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/courses", produces = "application/json;charset=UTF-8")
public class CoursesController {
    private CoursesService coursesService;

    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCourses() {
        return "Hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Course getCourse(@PathVariable("id") long id) {
        return coursesService.getCourse(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find course with id %d", id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Course postCourse(@RequestBody Course course) {
        return this.coursesService.store(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Course putCourse(@RequestBody Course course, @PathVariable("id") long id) {
        return this.coursesService.store(id, course);
    }

    @RequestMapping(value = "/previews", method = RequestMethod.GET)
    public List<Preview> getPreviews(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isBlank(query)) {
            return coursesService.getPreviews();
        }
        return coursesService.getPreviewsFilteredBy(query);
    }

    @RequestMapping(value = "/currentMaxRating", method = RequestMethod.GET)
    public MaxRating getCurrentMaxRating() {
        return coursesService.getCurrentMaxRating();
    }


}
