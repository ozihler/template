package com.zihler.questions.resources.output;

import com.zihler.questions.dataaccess.QuestionEntity;

public class UserIdentifiersOutputResource {
    private String name;
    private String emailAddress;


    public UserIdentifiersOutputResource() {
    }

    private UserIdentifiersOutputResource(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    static UserIdentifiersOutputResource create(QuestionEntity questionEntity) {
        return new UserIdentifiersOutputResource( questionEntity.getName(), questionEntity.getEmailAddress());
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
