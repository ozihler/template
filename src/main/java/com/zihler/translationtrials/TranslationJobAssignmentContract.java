package com.zihler.translationtrials;

import java.time.LocalDate;

public class TranslationJobAssignmentContract {
    private final Orderer orderer;
    private final Translator translator;
    private LocalDate contractDate;

    private TranslationJobAssignmentContract(Orderer orderer, Translator translator, LocalDate contractDate) {
        this.orderer = orderer;
        this.translator = translator;
        this.contractDate = contractDate;
    }

    public static TranslationJobAssignmentContract between(Orderer orderer, Translator translator) {
        return new TranslationJobAssignmentContract(orderer, translator, LocalDate.now());
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public Translator getTranslator() {
        return translator;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }
}
