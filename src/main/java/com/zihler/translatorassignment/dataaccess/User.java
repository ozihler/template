package com.zihler.translatorassignment.dataaccess;

public class User {
    private String username;
    private Long id;

    public User(Long id, String username) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return this.id;
    }
}
