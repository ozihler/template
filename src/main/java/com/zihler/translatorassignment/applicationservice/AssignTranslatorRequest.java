package com.zihler.translatorassignment.applicationservice;

public class AssignTranslatorRequest {
    private String orderer;
    private String translator;
    private Long translationJobId;

    public AssignTranslatorRequest(String orderer, String translator, Long translationJobId) {
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
