package com.zihler.translatorassignment.applicationservice;

import com.zihler.translatorassignment.annotations.DDDRepository;
import com.zihler.translatorassignment.domain.TranslationToolUser;
import org.springframework.stereotype.Component;

@DDDRepository
@Component
public interface UserRepository {
    TranslationToolUser findByUsername(String username);
}
