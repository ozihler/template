package com.zihler.translationtrials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/translation-trials")
public class TranslationTrialsController {
    private AssignTranslatorUseCase assignTranslatorUseCase;

    @Autowired
    public TranslationTrialsController(AssignTranslatorUseCase assignTranslatorUseCase) {
        this.assignTranslatorUseCase = assignTranslatorUseCase;
    }

    public void assignTranslator(AssignTranslatorCommand command) {
        assignTranslatorUseCase.assignTranslator(command);

    }
}
