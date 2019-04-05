package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.dataaccess.TranslationJobData;
import com.zihler.translatorassignment.dataaccess.TranslationJobRepository;
import com.zihler.translatorassignment.domain.TranslationJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationJobService {

    private TranslationJobRepository translationJobRepository;

    @Autowired
    public TranslationJobService(TranslationJobRepository translationJobRepository) {
        this.translationJobRepository = translationJobRepository;
    }

    public TranslationJob findById(Long translationJobId) {
        TranslationJobData translationJobData = translationJobRepository.findById(translationJobId).orElseThrow(RuntimeException::new);
        return new TranslationJob(translationJobData.getId());
    }
}