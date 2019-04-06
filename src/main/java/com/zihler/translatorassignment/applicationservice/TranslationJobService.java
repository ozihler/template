package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.domain.TranslationJob;
import org.springframework.stereotype.Service;

@Service
public class TranslationJobService {

    private TranslationJobRepository translationJobRepository;

    public TranslationJobService() {
        this.translationJobRepository = id -> new TranslationJob(id);
    }

    public TranslationJob findById(Long translationJobId) {
        TranslationJob translationJobData = translationJobRepository.findById(translationJobId);
        return new TranslationJob(translationJobData.getId());
    }

    public TranslationJob findTranslationJobFrom(AssignTranslatorRequest command) {
        return findById(command.getTranslationJobId());
    }
}
