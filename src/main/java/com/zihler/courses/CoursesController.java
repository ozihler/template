package com.zihler.courses;

import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;
import com.zihler.courses.transfer.CourseDto;
import com.zihler.courses.transfer.MaxRatingDto;
import com.zihler.courses.transfer.PreviewDto;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/courses", produces = "application/json;charset=UTF-8")
public class CoursesController {
    private CoursesService coursesService;
    private CourseSectionsService courseSectionsService;

    @Autowired
    public CoursesController(CoursesService coursesService, CourseSectionsService courseSectionsService) {
        this.coursesService = coursesService;
        this.courseSectionsService = courseSectionsService;
    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @DeleteMapping(value = "/{id}")
    public CourseDto deleteCourse(@PathVariable("id") long id) {
        return coursesService.deleteCourse(id);
    }

    @GetMapping(value = "/{id}")
    public CourseDto getCourse(@PathVariable("id") long id) {
        return coursesService.getCourse(id);
    }

    @PostMapping
    public CourseDto createCourseFrom(@RequestBody CourseDto courseDto) {
        return this.coursesService.createCourseFrom(courseDto);
    }

    @PutMapping(value = "/{id}")
    public CourseDto updateCourseWith(@RequestBody CourseDto courseDto, @PathVariable("id") long id) {
        return this.coursesService.updateCourseWith(id, courseDto);
    }

    @GetMapping(value = "/previews")
    public List<PreviewDto> getPreviews(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isBlank(query)) {
            return coursesService.getPreviews();
        }
        return coursesService.getPreviewsFilteredBy(query);
    }

    @GetMapping(value = "/currentMaxRating")
    public MaxRatingDto getCurrentMaxRating() {
        return coursesService.getCurrentMaxRating();
    }

    @GetMapping(value = "/{id}/pdf")
    public ResponseEntity<byte[]> getCourseAsPdf(@PathVariable("id") long id) throws ConversionException, Markdown2PdfLogicException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(courseSectionsService.getCourseAsPdf(id));
    }
}
