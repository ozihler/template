package com.zihler.translationtrials;

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

    public Orderer findByUsername(String orderer) {
        User user = userRepository.findByUsername(orderer);
        ArrayList<Receit> receits = new ArrayList<>();
        return new Orderer(user, receits);
    }
}
