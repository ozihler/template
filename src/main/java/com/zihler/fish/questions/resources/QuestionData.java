package com.zihler.fish.questions.resources;

public class QuestionData {
    private String topics;
    private String title;
    private String questionText;

    public QuestionData() {
    }

    public QuestionData(String topics, String title, String questionText) {
        this.topics = topics;
        this.title = title;
        this.questionText = questionText;
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
}
