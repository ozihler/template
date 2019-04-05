package com.zihler.translationtrials;

import java.util.ArrayList;
import java.util.List;

public class Orderer implements TranslationToolUser {
    private final TranslationToolUser user;
    private TranslationJob translationJob;
    private List<Receit> receits;

    public Orderer(TranslationToolUser user, ArrayList<Receit> receits) {
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

    public Orderer assign(TranslationJob translationJob) {
        this.translationJob = translationJob;
        return this;
    }

    public AssignmentReceit to(Translator translator) {
        TranslationJobAssignmentContract contract = TranslationJobAssignmentContract.between(this, translator);
        AssignmentReceit assignmentReceit = this.translationJob.set(contract);
        this.storeReceit(assignmentReceit);
        translator.storeReceit(assignmentReceit);
        return assignmentReceit;
    }
}
