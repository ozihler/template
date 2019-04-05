package com.zihler.translatorassignment.domain;

import java.util.Collection;

public class Orderer implements TranslationToolUser {
    private TranslationToolUser user;

    public Orderer(TranslationToolUser user) {
        this.user = user;
    }

    public AssignmentContract assign(TranslationJob translationJob) {
        return AssignmentContract.open(this, translationJob);
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void storeReceipt(AssignmentContractReceipt receipt) {
        user.storeReceipt(receipt);
    }

    @Override
    public Collection<AssignmentContractReceipt> getReceipts() {
        return user.getReceipts();
    }

    public TranslationToolUser getParent() {
        return user;
    }
}
