package com.zihler.translationtrials;

public class AssignTranslatorCommand {
    private String orderer;
    private String translator;
    private Long translationJobId;

    public AssignTranslatorCommand(String orderer, String translator, Long translationJobId) {
        this.orderer = orderer;
        this.translator = translator;
        this.translationJobId = translationJobId;
    }

    public String getOrderer() {
        return orderer;
    }

    public String getTranslator() {
        return translator;
    }

    public Long getTranslationJobId() {
        return translationJobId;
    }
}
