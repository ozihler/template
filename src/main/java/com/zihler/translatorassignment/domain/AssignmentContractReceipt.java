package com.zihler.translatorassignment.domain;

import com.zihler.translatorassignment.annotations.ValueObject;

@ValueObject
public class AssignmentContractReceipt {
    private final AssignmentContract contract;

    public AssignmentContractReceipt(AssignmentContract contract) {
        this.contract = contract;
    }

    public static AssignmentContractReceipt issueFor(AssignmentContract contract) {
        return new AssignmentContractReceipt(contract);
    }

    @Override
    public String toString() {
        return String.format("Assignment Contract with id %s, received at %s, for job %d, ordered by '%s', will be translated by translator='%s'",
                contract.getId(), contract.getFinalizationDate(), contract.getTranslationJob().getId(), contract.getOrderer().getUsername(), contract.getTranslator().getUsername());
    }
}
