package com.zihler.translatorassignment.applicationservice;

public class IllegalImpersonationException extends RuntimeException {
    public IllegalImpersonationException(String message) {
        super(message);
    }
}
