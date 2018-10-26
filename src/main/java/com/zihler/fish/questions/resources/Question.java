package com.zihler.fish.questions.resources;

import com.zihler.fish.questions.dataaccess.QuestionEntity;

public class Question {
    private UserIdentifiers userIdentifiers;
    private QuestionData questionData;

    public Question() {
    }

    public Question(UserIdentifiers userIdentifiers, QuestionData questionData) {
        this.userIdentifiers = userIdentifiers;
        this.questionData = questionData;
    }

    public static Question createFrom(QuestionEntity questionEntity) {
        return new Question(
                new UserIdentifiers(questionEntity.getName(), questionEntity.getEmailAddress()),
                new QuestionData(questionEntity.getTopics(), questionEntity.getTitle(), questionEntity.getQuestionText())
        );
    }

    public UserIdentifiers getUserIdentifiers() {
        return userIdentifiers;
    }

    public QuestionData getQuestionData() {
        return questionData;
    }
}
