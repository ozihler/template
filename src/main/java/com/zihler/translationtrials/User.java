package com.zihler.translationtrials;

public class User implements TranslationToolUser {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
