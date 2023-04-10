package com.example.surveyms.services;

import com.example.surveyms.model.Survey;
import org.springframework.stereotype.Service;

import java.util.List;
public interface SurveyService {

    List<Survey> getAll() ;
    List<Survey> getInformatique();
    List<Survey> getFinances() ;
    List<Survey> getGeneral();

}