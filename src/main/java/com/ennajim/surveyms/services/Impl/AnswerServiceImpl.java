package com.ennajim.surveyms.services.Impl;

import com.ennajim.surveyms.services.AnswerService;
import com.ennajim.surveyms.entities.Answer;
import com.ennajim.surveyms.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
    @Override
    public long count(){

        return this.answerRepository.count();
    }
    public Optional<Answer> getbyid(Long id){
        return this.answerRepository.findById(id);
    }


    @Override
    public void  deleteAnswer(Long answer_id){
        answerRepository.deleteById(answer_id);
    }
}
