package com.example.surveyms.services;


import com.example.surveyms.entity.Question;
import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

}
