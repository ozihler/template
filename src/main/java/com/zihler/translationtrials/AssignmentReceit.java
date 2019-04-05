package com.zihler.translationtrials;

import java.time.LocalTime;

public class AssignmentReceit implements Receit {
    private final Long translationJobId;
    private final String orderer;
    private final String translator;
    private final LocalTime receitCreationDate;

    public AssignmentReceit(TranslationJob translationJob, Orderer orderer, Translator translator, LocalTime receitCreationDate) {
        this.translationJobId = translationJob.getId();
        this.orderer = orderer.getUsername();
        this.translator = translator.getUsername();
        this.receitCreationDate = receitCreationDate;
    }

    public static AssignmentReceit create(TranslationJob translationJob, TranslationJobAssignmentContract contract) {
        return new AssignmentReceit(translationJob, contract.getOrderer(), contract.getTranslator(), LocalTime.now());
    }

    @Override
    public String toString() {
        return String.format("New translator assignment: %s", this);
    }
}
