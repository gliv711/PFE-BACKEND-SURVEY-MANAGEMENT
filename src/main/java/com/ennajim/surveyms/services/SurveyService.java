package com.ennajim.surveyms.services;

import com.ennajim.surveyms.entities.Survey;

import java.util.List;
public interface SurveyService {

    List<Survey> getAll();


    List<Survey> saveAll(List<Survey> surveys);

    void deleteByIdSurvey(Long id);
    void SaveSurvey(Survey survey) ;

    long count();
}