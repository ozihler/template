package com.zihler.translatorassignment.presentation;

import com.zihler.translatorassignment.applicationservice.AssignTranslatorRequest;
import com.zihler.translatorassignment.applicationservice.AssignTranslatorUseCase;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/translation-trials")
public class TranslationTrialsController {
    private AssignTranslatorUseCase assignTranslatorUseCase;

    @Autowired
    public TranslationTrialsController(AssignTranslatorUseCase assignTranslatorUseCase) {
        this.assignTranslatorUseCase = assignTranslatorUseCase;
    }

    @PostMapping("assignments")
    public AssignmentContractReceipt assignTranslator(AssignTranslatorRequest command) {
        return assignTranslatorUseCase.assignTranslator(command);
    }
}
