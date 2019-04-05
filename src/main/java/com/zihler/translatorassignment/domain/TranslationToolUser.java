package com.zihler.translatorassignment.domain;

import java.util.Collection;

public interface TranslationToolUser {
    String getUsername();

    void storeReceipt(AssignmentContractReceipt receipt);

    Collection<AssignmentContractReceipt> getReceipts();
}
