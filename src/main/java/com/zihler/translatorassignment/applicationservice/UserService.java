package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.dataaccess.User;
import com.zihler.translatorassignment.dataaccess.UserRepository;
import com.zihler.translatorassignment.domain.AssignmentContractReceipt;
import com.zihler.translatorassignment.domain.BasicTranslationToolUser;
import com.zihler.translatorassignment.domain.TranslationToolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private UserRepository userRepository;
    private ReceiptRepository receiptRepository;

    @Autowired
    public UserService(UserRepository userRepository, ReceiptRepository receiptRepository) {
        this.userRepository = userRepository;
        this.receiptRepository = receiptRepository;
    }

    public TranslationToolUser findByUsername(String username) {
        User userData = userRepository.findByUsername(username);
        Collection<AssignmentContractReceipt> receipts = receiptRepository.findByUserId(userData.getId());
        return new BasicTranslationToolUser(userData.getUsername(), receipts);
    }
}
