package com.zihler.translatorassignment.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class AssignmentContract {
    private UUID id;
    private TranslationJob translationJob;
    private Orderer orderer;
    private Translator translator;
    private LocalDateTime finalizationDate;

    private AssignmentContract(Orderer orderer, TranslationJob translationJob) {
        this.id = UUID.randomUUID();
        this.orderer = orderer;
        this.translationJob = translationJob;
    }

    static AssignmentContract open(Orderer orderer, TranslationJob translationJob) {
        return new AssignmentContract(orderer, translationJob);
    }

    public AssignmentContractReceipt to(Translator translator) {
        assign(translator);
        return finalizeContract();
    }

    public boolean isFinalized() {
        return finalizationDate != null;
    }

    private AssignmentContractReceipt finalizeContract() {
        fixFinalizationDate();
        bindContractToTranslationJob();
        return issueReceiptToAllParties();
    }

    private void bindContractToTranslationJob() {
        this.translationJob.bindTo(this);
    }

    private AssignmentContractReceipt issueReceiptToAllParties() {
        final AssignmentContractReceipt receipt = AssignmentContractReceipt.issueFor(this);
        this.orderer.store(receipt);
        this.translator.store(receipt);
        return receipt;
    }

    private void fixFinalizationDate() {
        this.finalizationDate = LocalDateTime.now();
    }

    private void assign(Translator translator) {
        if (isAssignedAlready()) {
            throw new MultipleAssignmentException();
        }
        this.translator = translator;
    }

    private boolean isAssignedAlready() {
        return this.translator != null;
    }

    public TranslationJob getTranslationJob() {
        return translationJob;
    }


    public Orderer getOrderer() {
        return orderer;
    }

    public UUID getId() {
        return this.id;
    }

    public Translator getTranslator() {
        if (!isAssignedAlready()) {
            throw new MissingAssignmentException();
        }
        return translator;
    }

    public LocalDateTime getFinalizationDate() {
        if (!isFinalized()) {
            throw new MissingFinalizationException();
        }
        return finalizationDate;
    }
}
