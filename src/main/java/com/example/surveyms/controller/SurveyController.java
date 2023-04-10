package com.example.surveyms.controller;


import com.example.surveyms.model.Survey;
import com.example.surveyms.repository.SurveyRepository;
import com.example.surveyms.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class SurveyController {

    @Autowired
    SurveyService surveyService;



    @GetMapping("/survey/all")
    public List<Survey> getAll(){

        return surveyService.getAll();
    }


    @GetMapping("/survey/general")
    public List<Survey>getGeneral(){
    return surveyService.getGeneral();
    }

    @GetMapping("/survey/informatique")
    public List<Survey>getinformatique(){
        return surveyService.getInformatique();
    }

    @GetMapping("/survey/finances")
    public List<Survey>getFinances(){
        return surveyService.getFinances();
    }

}
