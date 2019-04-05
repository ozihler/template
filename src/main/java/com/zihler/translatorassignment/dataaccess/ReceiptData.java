package com.zihler.translatorassignment.dataaccess;

import java.time.LocalTime;

public class ReceiptData {
    private Long translationJobId;
    private String orderer;
    private String translator;
    private LocalTime creationDate;

    public ReceiptData(Long translationJobId, String orderer, String translator, LocalTime creationDate) {
        this.translationJobId = translationJobId;
        this.orderer = orderer;
        this.translator = translator;
        this.creationDate = creationDate;
    }
}
