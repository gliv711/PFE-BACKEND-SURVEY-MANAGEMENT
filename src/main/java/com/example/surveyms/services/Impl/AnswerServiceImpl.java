package com.example.surveyms.services.Impl;

import com.example.surveyms.entity.Answer;
import com.example.surveyms.repository.AnswerRepository;
import com.example.surveyms.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository ;
    @Override
    public Answer addAnswer(Answer answer) {
       return  answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
