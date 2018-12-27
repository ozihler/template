package com.zihler.questions.resources.output;

import com.zihler.questions.dataaccess.QuestionEntity;

public class QuestionDataOutputResource {
    private String topics;
    private String title;
    private String questionText;

    public QuestionDataOutputResource() {
    }

    private QuestionDataOutputResource(String topics, String title, String questionText) {
        this.topics = topics;
        this.title = title;
        this.questionText = questionText;
    }

    private static QuestionDataOutputResource create(String topics, String title, String questionText) {
        return new QuestionDataOutputResource(topics, title, questionText);
    }

    static QuestionDataOutputResource create(QuestionEntity questionEntity) {
        return create(questionEntity.getTopics(), questionEntity.getTitle(), questionEntity.getQuestionText());
    }

    public String getTopics() {
        return topics;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestionText() {
        return questionText;
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "topics='" + topics + '\'' +
                ", title='" + title + '\'' +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
