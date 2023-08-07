package com.ennajim.surveyms.services.Impl;


import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.repository.QuestionRepository;
import com.ennajim.surveyms.services.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

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
    public void deleteQuestion(Long question_id) {
        log.info("Request to delete the question [{}]", question_id);

        if (question_id != null) {
            this.questionRepository.deleteById(question_id);
        }
        else {
            log.info("id is null");

        }


    }
    public long count(){
        log.info("Request number of questions [{}]");
        return this.questionRepository.count();
    }



}
