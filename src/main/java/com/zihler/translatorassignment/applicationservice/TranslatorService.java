package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.dataaccess.User;
import com.zihler.translatorassignment.dataaccess.UserRepository;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import com.zihler.translatorassignment.domain.BasicTranslationToolUser;
import com.zihler.translatorassignment.domain.TranslationToolUser;
import com.zihler.translatorassignment.domain.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslatorService {
    private UserRepository userRepository;

    @Autowired
    public TranslatorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Translator findByUsername(String translator) {
        User user = userRepository.findByUsername(translator);
        List<AssignmentContractReceipt> receipts = new ArrayList<>();

        TranslationToolUser translationToolUser = new BasicTranslationToolUser(user.getUsername(), receipts);
        return new Translator(translationToolUser);
    }
}
