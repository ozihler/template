package com.zihler.questions.dataaccess;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    private String emailAddress;
    private String topics;
    private String title;
    private String questionText;

    public QuestionEntity() {
    }

    public QuestionEntity(String name, String emailAddress, String topics, String title, String questionText) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.topics = topics;
        this.title = title;
        this.questionText = questionText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
