package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.domain.BasicTranslationToolUser;
import com.zihler.translatorassignment.domain.Orderer;
import com.zihler.translatorassignment.domain.TranslationToolUser;
import com.zihler.translatorassignment.domain.Translator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private UserRepository userRepository;
    private SecurityService securityService;

    public UserService() {
        this.userRepository = username -> new BasicTranslationToolUser(username, new ArrayList<>());
        this.securityService = new SecurityService();
    }

    TranslationToolUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    Translator findTranslatorFrom(String translatorUsername) {
        return new Translator(findByUsername(translatorUsername));
    }

    Orderer findOrdererFrom(String ordererUsername) {
        if (canOrderTranslationJobs(ordererUsername)) {
            return new Orderer(findByUsername(ordererUsername));
        } else {
            throw new IllegalImpersonationException(String.format("User %s is not allowed to order translation jobs", ordererUsername));
        }
    }

    private boolean canOrderTranslationJobs(String ordererUsername) {
        return securityService.canOrderTranslationJobs(ordererUsername);
    }
}
