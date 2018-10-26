package com.zihler.fish.questions.resources;

import com.zihler.fish.questions.QuestionResource;
import com.zihler.fish.questions.applicationservices.QuestionService;
import com.zihler.fish.questions.dataaccess.QuestionEntity;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/questions", produces = "application/hal+json")
public class QuestionsController {
    private QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resources<QuestionResource>> all() {
        Resources<QuestionResource> questionResources = new Resources<>(questionService.getAll()
                .stream()
                .map(QuestionResource::new)
                .collect(toList()));

        return ResponseEntity.ok(questionResources);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<QuestionResource> post(@RequestBody Question question) {
        System.out.println(question);

        QuestionResource questionResource = new QuestionResource(question);

        return ResponseEntity.ok(questionResource);
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