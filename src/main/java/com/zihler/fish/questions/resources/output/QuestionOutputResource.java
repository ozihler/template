package com.zihler.fish.questions.resources.output;

import com.zihler.fish.questions.dataaccess.QuestionEntity;
import org.springframework.hateoas.ResourceSupport;

public class QuestionOutputResource extends ResourceSupport {
    private UserIdentifiersOutputResource userIdentifiers;
    private QuestionDataOutputResource questionData;

    private QuestionOutputResource() {
    }

    public static QuestionOutputResource create(QuestionEntity questionEntity) {
        QuestionOutputResource questionOutputResource = new QuestionOutputResource();
        questionOutputResource.userIdentifiers = UserIdentifiersOutputResource.create(questionEntity);
        questionOutputResource.questionData = QuestionDataOutputResource.create(questionEntity);
        return questionOutputResource;
    }

    public QuestionDataOutputResource getQuestionData() {
        return questionData;
    }

    public UserIdentifiersOutputResource getUserIdentifiers() {
        return userIdentifiers;
    }
}
