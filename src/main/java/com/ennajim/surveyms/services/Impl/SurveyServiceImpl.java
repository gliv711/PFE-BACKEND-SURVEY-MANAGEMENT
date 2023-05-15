package com.ennajim.surveyms.services.Impl;

import com.ennajim.surveyms.entities.Survey;
import com.ennajim.surveyms.repository.SurveyRepository;
import com.ennajim.surveyms.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;


    @Override
    public Survey addSurvey(Survey survey){

        return this.surveyRepository.save(survey);
    }
    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();    }

    @Override
    public List<Survey> findByfield(String field) {
        return surveyRepository.findByfield(field);
    }

    @Override

    public List<Survey> saveAll(List<Survey> surveys) {
        return surveyRepository.saveAll(surveys);
    }
    public void deleteByIdSurvey(Long id){
    surveyRepository.deleteById(id);
    }

    public long count(){
        return surveyRepository.count();
    }
}
