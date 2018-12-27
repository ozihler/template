package com.zihler.questions.resources;

import com.zihler.questions.applicationservices.QuestionService;
import com.zihler.questions.resources.input.QuestionInputData;
import com.zihler.questions.resources.output.QuestionOutputResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/questions", produces = "application/hal+json")
public class QuestionsController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionsController.class);
    private QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resources<QuestionOutputResource>> all() {
        List<QuestionOutputResource> allQuestions = questionService.getAll();
        Resources<QuestionOutputResource> questionResources = new Resources<>(allQuestions);

        return ResponseEntity.ok(questionResources);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<QuestionOutputResource> post(@RequestBody QuestionInputData questionInputData) {
        logger.info("Received question: {}", questionInputData);

        QuestionOutputResource questionOutputResource = questionService.save(questionInputData);

        return ResponseEntity.ok(questionOutputResource);
    }

    //
//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<CourseResource> put(@PathParam("id") long id, @RequestBody Course course) {
//        return null;
//    }
//
//    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<CourseResource> delete(@PathParam("id") long id) {
//        return null;
//    }
}