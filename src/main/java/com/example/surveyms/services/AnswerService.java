package com.example.surveyms.services;

import com.example.surveyms.entity.Answer;

import java.util.List;

public interface AnswerService {

    Answer addAnswer(Answer answer);
    List<Answer> getAllAnswers();

}
