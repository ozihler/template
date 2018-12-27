package com.zihler.questions.applicationservices;

import com.zihler.questions.dataaccess.QuestionEntity;
import com.zihler.questions.resources.input.QuestionDataInputData;
import com.zihler.questions.resources.input.QuestionInputData;
import com.zihler.questions.resources.input.UserIdentifiersInputData;

class QuestionInputToEntityConverter {
    static QuestionEntity convert(QuestionInputData questionInputData) {
        QuestionEntity questionEntity = new QuestionEntity();
        addUserIdentifiers(questionEntity, questionInputData.getUserIdentifiers());
        addQuestionData(questionEntity, questionInputData.getQuestionData());
        return questionEntity;
    }

    private static void addUserIdentifiers(QuestionEntity questionEntity, UserIdentifiersInputData userIdentifiersInputData) {
        questionEntity.setName(userIdentifiersInputData.getName());
        questionEntity.setEmailAddress(userIdentifiersInputData.getEmailAddress());
    }

    private static void addQuestionData(QuestionEntity questionEntity, QuestionDataInputData userIdentifiersInputData) {
        questionEntity.setTopics(userIdentifiersInputData.getTopics());
        questionEntity.setTitle(userIdentifiersInputData.getTitle());
        questionEntity.setQuestionText(userIdentifiersInputData.getQuestionText());
    }
}
