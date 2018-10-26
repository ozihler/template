package com.zihler.fish.questions.applicationservices;

import com.zihler.fish.questions.dataaccess.QuestionRepository;
import com.zihler.fish.questions.resources.Question;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Question> getAll() {
        return this.questionRepository.findAll()
                .stream()
                .map(questionEntity -> Question.createFrom(questionEntity))
                .collect(toList());
    }
}
