package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
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
        var orderer = userService.findOrdererFrom(request.getOrderer());
        var translator = userService.findTranslatorFrom(request.getTranslator());
        var translationJob = translationJobService.findTranslationJobFrom(request);

        var receipt = orderer
                .assign(translationJob)
                .to(translator);

        logger.info(receipt.toString());

        return receipt;
    }

}
