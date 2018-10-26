package com.zihler.fish.questions;

import com.zihler.fish.questions.resources.Question;
import com.zihler.fish.questions.resources.QuestionData;
import com.zihler.fish.questions.resources.UserIdentifiers;
import org.springframework.hateoas.ResourceSupport;

public class QuestionResource extends ResourceSupport {
    private UserIdentifiers userIdentifiers;
    private QuestionData questionData;

    public QuestionResource() {
    }

    public QuestionResource(Question question) {
        this.userIdentifiers = question.getUserIdentifiers();
        this.questionData = question.getQuestionData();
    }

    public QuestionData getQuestionData() {
        return questionData;
    }

    public UserIdentifiers getUserIdentifiers() {
        return userIdentifiers;
    }
}
