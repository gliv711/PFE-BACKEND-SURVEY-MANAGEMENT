package com.ennajim.surveyms.services;

import com.ennajim.surveyms.entities.Survey;

import java.util.List;
public interface SurveyService {

    List<Survey> getAll();

    List<Survey> findByfield(String field);

    List<Survey> saveAll(List<Survey> surveys);

    void deleteByIdSurvey(Long id);
    Survey addSurvey(Survey survey) ;

    long count();

}