package com.zihler.translationtrials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssignTranslatorUseCase {
    private static Logger logger = LoggerFactory.getLogger(AssignTranslatorUseCase.class);

    private OrdererService ordererService;
    private TranslatorService translatorService;
    private TranslationJobService translationJobService;

    @Autowired
    public AssignTranslatorUseCase(OrdererService ordererService, TranslatorService translatorService, TranslationJobService translationJobService) {
        this.ordererService = ordererService;
        this.translatorService = translatorService;
        this.translationJobService = translationJobService;
    }

    public AssignmentReceit assignTranslator(AssignTranslatorCommand command) {
        Orderer orderer = ordererService.findByUsername(command.getOrderer());
        Translator translator = translatorService.findByUsername(command.getTranslator());
        TranslationJob translationJob = translationJobService.findById(command.getTranslationJobId());

        AssignmentReceit receit = orderer.assign(translationJob).to(translator);

        logger.info(receit.toString());

        return receit;
    }

}
