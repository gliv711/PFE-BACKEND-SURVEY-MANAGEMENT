package com.ennajim.surveyms.services;

import com.ennajim.surveyms.entities.Answer;

import java.util.List;

public interface AnswerService {

    Answer addAnswer(Answer answer);
    List<Answer> getAllAnswers();
     long count();
}
