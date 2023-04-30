package com.example.surveyms.services.Impl;


import com.example.surveyms.model.Question;
import com.example.surveyms.repository.QuestionRepository;
import com.example.surveyms.services.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        log.info("Request to add the question [{}]", question);
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        log.info("Request to get all questions from the database");
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        log.info("Request to add the question with id [{}]", id);
        Optional<Question> question = this.questionRepository.findById(id);
        return question.orElse(null);
    }

    @Override
    public Question updateQuestion(Question question) {
        log.info("Request to update the question [{}]", question);
        return this.questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        log.info("Request to delete the question [{}]", id);
        this.questionRepository.deleteById(id);
    }

}
