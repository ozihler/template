package com.zihler.translationtrials;

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
        List<Receit> receits = new ArrayList<>();
        return new Translator(user, receits);
    }
}
