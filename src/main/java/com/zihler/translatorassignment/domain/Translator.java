package com.zihler.translatorassignment.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Translator implements TranslationToolUser {

    private final TranslationToolUser user;

    public Translator(TranslationToolUser user) {
        this.user = user;
    }

    public static void main(String[] args) {
        BasicTranslationToolUser baseUser = new BasicTranslationToolUser("user", new ArrayList<>());
        Translator translator = new Translator(baseUser);
        Orderer orderer = new Orderer(translator);
        Translator translator1 = (Translator) orderer.getParent();


        TranslationJob translationJob = new TranslationJob(1l);

        orderer.assign(translationJob).to(translator1);
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
}
