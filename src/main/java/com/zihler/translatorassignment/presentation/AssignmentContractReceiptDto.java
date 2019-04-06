package com.zihler.translatorassignment.presentation;

import com.zihler.translatorassignment.domain.AssignmentContract;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;

import java.time.format.DateTimeFormatter;

public class AssignmentContractReceiptDto {
    private String orderer;
    private String translator;
    private Long translationJobId;
    private String finalizationDate;
    private String contractId;

    public AssignmentContractReceiptDto() {
    }

    public static AssignmentContractReceiptDto create(AssignmentContractReceipt receipt) {
        AssignmentContract contract = receipt.getContract();
        AssignmentContractReceiptDto receiptDto = new AssignmentContractReceiptDto();
        receiptDto.orderer = contract.getOrderer().getUsername();
        receiptDto.translator = contract.getTranslator().getUsername();
        receiptDto.translationJobId = contract.getTranslationJob().getId();
        receiptDto.finalizationDate = contract.getFinalizationDate().format(DateTimeFormatter.ofPattern("EE dd.MM.YYYY, HH:mm:ss a"));
        receiptDto.contractId = contract.getId().toString();
        return receiptDto;
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

    public String getFinalizationDate() {
        return finalizationDate;
    }

    public String getContractId() {
        return contractId;
    }
}
