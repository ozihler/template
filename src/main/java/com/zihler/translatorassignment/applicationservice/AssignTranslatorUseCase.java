package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import com.zihler.translatorassignment.domain.Orderer;
import com.zihler.translatorassignment.domain.TranslationJob;
import com.zihler.translatorassignment.domain.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AssignTranslatorUseCase {
    private static Logger logger = LoggerFactory.getLogger(AssignTranslatorUseCase.class);

    private UserService userService;
    private TranslationJobService translationJobService;

    @Autowired
    public AssignTranslatorUseCase(UserService userService, TranslationJobService translationJobService) {
        this.userService = userService;
        this.translationJobService = translationJobService;
    }

    public AssignmentContractReceipt assignTranslator(AssignTranslatorRequest request) {
        var orderer = findOrdererFrom(request);
        var translator = findTranslatorFrom(request);
        var translationJob = findTranslationJobFrom(request);

        var receipt = orderer
                .assign(translationJob)
                .to(translator);

        logger.info(receipt.toString());

        return receipt;
    }

    private TranslationJob findTranslationJobFrom(AssignTranslatorRequest command) {
        return translationJobService.findById(command.getTranslationJobId());
    }

    private Translator findTranslatorFrom(AssignTranslatorRequest command) {
        return new Translator(userService.findByUsername(command.getTranslator()));
    }

    private Orderer findOrdererFrom(AssignTranslatorRequest command) {
        return new Orderer(userService.findByUsername(command.getOrderer()));
    }

}
