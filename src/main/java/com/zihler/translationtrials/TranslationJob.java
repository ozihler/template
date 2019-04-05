package com.zihler.translationtrials;

public class TranslationJob {
    private Long id;
    private TranslationJobAssignmentContract contract;

    public TranslationJob(Long id) {
        this.id = id;
    }

    public AssignmentReceit assign(TranslationJobAssignmentContract contract) {
        if (isAssignedAlready()) {
            throw new IllegalAssignmentException("");
        }
        this.contract = contract;
        return AssignmentReceit.create(this, contract);
    }

    public Long getId() {
        return id;
    }

    public boolean isAssignedAlready() {
        return contract != null;
    }
}
