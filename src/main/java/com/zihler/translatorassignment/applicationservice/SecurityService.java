package com.zihler.translatorassignment.applicationservice;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public boolean canOrderTranslationJobs(String ordererUsername) {
        return true;
    }
}
