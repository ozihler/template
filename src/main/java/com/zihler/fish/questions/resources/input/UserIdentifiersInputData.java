package com.zihler.fish.questions.resources.input;

public class UserIdentifiersInputData {
    private String name;
    private String emailAddress;


    public UserIdentifiersInputData() {
    }

    UserIdentifiersInputData(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "UserIdentifiers{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
