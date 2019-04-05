package com.zihler.translatorassignment.domain;

public class TranslationJob {
    private Long id;
    private AssignmentContract contract;

    public TranslationJob(Long id) {
        this.id = id;
    }

    public void bindTo(AssignmentContract contract) {
        if (isAssignedAlready()) {
            throw new MultipleAssignmentException();
        }
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public boolean isAssignedAlready() {
        return contract != null;
    }
}
