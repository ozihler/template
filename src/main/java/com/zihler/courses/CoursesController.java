package com.zihler.courses;

import com.zihler.courses.transfer.CourseDto;
import com.zihler.courses.transfer.MaxRatingDto;
import com.zihler.courses.transfer.PreviewDto;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CourseDto getCourse(@PathVariable("id") long id) {
        return coursesService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CourseDto postCourse(@RequestBody CourseDto courseDto) {
        return this.coursesService.createFrom(courseDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public CourseDto putCourse(@RequestBody CourseDto courseDto, @PathVariable("id") long id) {
        return this.coursesService.update(id, courseDto);
    }

    @RequestMapping(value = "/previews", method = RequestMethod.GET)
    public List<PreviewDto> getPreviews(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isBlank(query)) {
            return coursesService.getPreviews();
        }
        return coursesService.getPreviewsFilteredBy(query);
    }

    @RequestMapping(value = "/currentMaxRating", method = RequestMethod.GET)
    public MaxRatingDto getCurrentMaxRating() {
        return coursesService.getCurrentMaxRating();
    }
}
