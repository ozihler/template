package com.zihler.courses;

import com.zihler.courses.transfer.CourseData;
import com.zihler.courses.transfer.MaxRatingData;
import com.zihler.courses.transfer.PreviewData;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CourseData getCourse(@PathVariable("id") long id) {
        return coursesService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CourseData postCourse(@RequestBody CourseData courseData) {
        assureCourseSectionDataIsInitialized(courseData);
        return this.coursesService.createFrom(courseData);
    }

    private void assureCourseSectionDataIsInitialized(CourseData courseData) {
        if (Objects.isNull(courseData.getCourseSections())) {
            courseData.setCourseSections(new ArrayList<>());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public CourseData putCourse(@RequestBody CourseData courseData, @PathVariable("id") long id) {
        assureCourseSectionDataIsInitialized(courseData);
        return this.coursesService.update(id, courseData);
    }

    @RequestMapping(value = "/previews", method = RequestMethod.GET)
    public List<PreviewData> getPreviews(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isBlank(query)) {
            return coursesService.getPreviews();
        }
        return coursesService.getPreviewsFilteredBy(query);
    }

    @RequestMapping(value = "/currentMaxRating", method = RequestMethod.GET)
    public MaxRatingData getCurrentMaxRating() {
        return coursesService.getCurrentMaxRating();
    }


}
