package com.ennajim.surveyms.services;

import com.ennajim.surveyms.entities.Survey;

import java.util.List;
public interface SurveyService {

    List<Survey> getAll();

    Survey findByField(String field);

    List<Survey> saveAll(List<Survey> surveys);

    void deleteByIdSurvey(Long id);
    Survey addSurvey(Survey survey) ;

    long count();
}