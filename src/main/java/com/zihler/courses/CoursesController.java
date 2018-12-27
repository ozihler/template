package com.zihler.courses;

import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Thumb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/thumbs", method = RequestMethod.GET)
    public List<Thumb> getThumbs() {
        return coursesService.getThumbs();
    }

    @RequestMapping(value = "/currentMaxRating", method = RequestMethod.GET)
    public MaxRating getCurrentMaxRating() {
        return coursesService.getCurrentMaxRating();
    }




}
