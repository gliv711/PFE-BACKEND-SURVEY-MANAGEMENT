package com.example.surveyms.controller;


import com.example.surveyms.model.Survey;
import com.example.surveyms.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class SurveyController {

    @Autowired
    SurveyService surveyService;


    @PostMapping("/survey/")
    public ResponseEntity<Void> SaveSurvey(@RequestBody Survey survey) {
        surveyService.SaveSurvey(survey);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/survey/" + survey.getId()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @GetMapping("/survey/all")
    public ResponseEntity<List<Survey>> getAll(){
        List<Survey> surveys = surveyService.getAll();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/survey/general")
    public ResponseEntity<List<Survey>> getGeneral(){
        List<Survey> surveys = surveyService.getGeneral();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/survey/informatique")
    public ResponseEntity<List<Survey>> getInformatique(){
        List<Survey> surveys = surveyService.getInformatique();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/survey/finances")
    public ResponseEntity<List<Survey>> getFinances(){
        List<Survey> surveys = surveyService.getFinances();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/survey/count")
    public long count(){
        return surveyService.count();
    }

    @DeleteMapping("/survey/{Id}")
    public void deleteByIduser(@PathVariable(name="Id") Long Id) {
        surveyService.deleteByIdSurvey(Id);
    }



}

