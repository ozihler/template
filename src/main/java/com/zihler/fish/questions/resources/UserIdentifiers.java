package com.zihler.fish.questions.resources;

public class UserIdentifiers {
    private String name;
    private String emailAddress;


    public UserIdentifiers() {
    }

    public UserIdentifiers(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
