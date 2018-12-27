package com.zihler.questions.applicationservices;

import com.zihler.questions.dataaccess.QuestionEntity;
import com.zihler.questions.dataaccess.QuestionRepository;
import com.zihler.questions.resources.input.QuestionInputData;
import com.zihler.questions.resources.output.QuestionOutputResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<QuestionOutputResource> getAll() {
        return this.questionRepository.findAll()
                .stream()
                .map(QuestionOutputResource::create)
                .collect(toList());
    }

    public QuestionOutputResource save(QuestionInputData questionInputData) {
        QuestionEntity questionEntity = QuestionInputToEntityConverter.convert(questionInputData);
        QuestionEntity savedQuestionEntity = this.questionRepository.save(questionEntity);
        return QuestionOutputResource.create(savedQuestionEntity);
    }
}
