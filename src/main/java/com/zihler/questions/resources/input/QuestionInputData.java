package com.zihler.questions.resources.input;

public class QuestionInputData {

    private UserIdentifiersInputData userIdentifiers;
    private QuestionDataInputData questionData;

    public QuestionInputData() {
    }

    private QuestionInputData(UserIdentifiersInputData userIdentifiers, QuestionDataInputData questionData) {
        this.userIdentifiers = userIdentifiers;
        this.questionData = questionData;
    }

    public UserIdentifiersInputData getUserIdentifiers() {
        return userIdentifiers;
    }

    public QuestionDataInputData getQuestionData() {
        return questionData;
    }

    @Override
    public String toString() {
        return "QuestionInputData{" +
                "userIdentifiers=" + userIdentifiers +
                ", questionData=" + questionData +
                '}';
    }
}
