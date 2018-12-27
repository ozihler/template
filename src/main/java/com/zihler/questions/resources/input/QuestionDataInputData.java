package com.zihler.questions.resources.input;

public class QuestionDataInputData {
    private String topics;
    private String title;
    private String questionText;

    public QuestionDataInputData() {
    }

    QuestionDataInputData(String topics, String title, String questionText) {
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

    @Override
    public String toString() {
        return "QuestionData{" +
                "topics='" + topics + '\'' +
                ", title='" + title + '\'' +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
