package com.zihler.translatorassignment.applicationservice;

import com.zihler.annotations.DDDRepository;
import com.zihler.translatorassignment.domain.TranslationJob;

@DDDRepository
public interface TranslationJobRepository {
    TranslationJob findById(Long id);
}
