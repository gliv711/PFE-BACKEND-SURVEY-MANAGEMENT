package com.example.surveyms.services.Impl;

import com.example.surveyms.model.Survey;
import com.example.surveyms.repository.SurveyRepository;
import com.example.surveyms.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();    }

    @Override
    public List<Survey> getInformatique() {
        return surveyRepository.findByFieldContains("Informatique");    }

    @Override
    public List<Survey> getFinances() {
        return surveyRepository.findByFieldContains("Finances");
    }

    public List<Survey> getGeneral(){
        return surveyRepository.findByFieldContains("Général");
    }
}
