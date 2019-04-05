package com.zihler.translatorassignment.domain;

public class MultipleAssignmentException extends RuntimeException {
    public MultipleAssignmentException() {
        super("Could not assign job");
    }
}
