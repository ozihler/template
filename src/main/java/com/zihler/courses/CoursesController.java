package com.zihler.courses;

import com.zihler.courses.output.Course;
import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Preview;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
