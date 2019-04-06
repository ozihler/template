package com.zihler.translatorassignment.applicationservice;

import org.apache.commons.lang3.StringUtils;

public class AssignTranslatorRequest {
    private String orderer;
    private String translator;
    private Long translationJobId;

    public AssignTranslatorRequest() {
    }

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

    public boolean isValid() {
        return !StringUtils.isBlank(orderer)
                && !StringUtils.isBlank(translator)
                && translationJobId != null;
    }

    @Override
    public String toString() {
        return "AssignTranslatorRequest{" +
                "orderer='" + orderer + '\'' +
                ", translator='" + translator + '\'' +
                ", translationJobId=" + translationJobId +
                '}';
    }
}
