package com.ennajim.surveyms.services;


import com.ennajim.surveyms.entities.Question;
import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);

    Question updateQuestion(Question question);

    void deleteQuestion(Long question_id);

    long count();
}
