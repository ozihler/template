package com.zihler.translatorassignment.domain;

import java.util.Collection;

public class BasicTranslationToolUser implements TranslationToolUser {
    private String username;
    private Collection<AssignmentContractReceipt> receipts;

    public BasicTranslationToolUser(String username, Collection<AssignmentContractReceipt> receipts) {
        this.username = username;
        this.receipts = receipts;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void store(AssignmentContractReceipt receipt) {
        this.receipts.add(receipt);
    }

    @Override
    public Collection<AssignmentContractReceipt> getReceipts() {
        return receipts;
    }
}
