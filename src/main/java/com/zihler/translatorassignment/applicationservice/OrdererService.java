package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.dataaccess.User;
import com.zihler.translatorassignment.dataaccess.UserRepository;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import com.zihler.translatorassignment.domain.BasicTranslationToolUser;
import com.zihler.translatorassignment.domain.Orderer;
import com.zihler.translatorassignment.domain.TranslationToolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrdererService {
    private UserRepository userRepository;

    @Autowired
    public OrdererService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Orderer findByUsername(String username) {
        User userData = userRepository.findByUsername(username);
        ArrayList<AssignmentContractReceipt> receipts = new ArrayList<>();
        TranslationToolUser translationToolUser = new BasicTranslationToolUser(userData.getUsername(), receipts);
        return new Orderer(translationToolUser);
    }
}
