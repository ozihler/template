package com.zihler.translatorassignment.domain;

import java.time.LocalDate;
import java.util.UUID;

public class AssignmentContract {
    private UUID id;
    private TranslationJob translationJob;
    private Orderer orderer;
    private Translator translator;
    private LocalDate finalizationDate;

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
        return issueReceipt();
    }

    private void bindContractToTranslationJob() {
        this.translationJob.bindTo(this);
    }

    private AssignmentContractReceipt issueReceipt() {
        AssignmentContractReceipt receipt = AssignmentContractReceipt.issueFor(this);
        this.orderer.storeReceipt(receipt);
        this.translator.storeReceipt(receipt);
        return receipt;
    }

    private void fixFinalizationDate() {
        this.finalizationDate = LocalDate.now();
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

    public LocalDate getFinalizationDate() {
        if (!isFinalized()) {
            throw new MissingFinalizationException();
        }
        return finalizationDate;
    }
}
