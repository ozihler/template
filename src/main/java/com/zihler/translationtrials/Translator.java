package com.zihler.translationtrials;

import java.util.List;

public class Translator implements TranslationToolUser {
    private TranslationToolUser user;
    private List<Receit> receits;

    public Translator(TranslationToolUser user, List<Receit> receits) {
        this.user = user;
        this.receits = receits;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void storeReceit(Receit receit) {
        this.receits.add(receit);
    }
}
