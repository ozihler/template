package com.zihler.translatorassignment.domain;

import java.util.Collection;

public class Translator implements TranslationToolUser {

    private final TranslationToolUser user;

    public Translator(TranslationToolUser user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void store(AssignmentContractReceipt receipt) {
        user.store(receipt);
    }

    @Override
    public Collection<AssignmentContractReceipt> getReceipts() {
        return user.getReceipts();
    }
}
