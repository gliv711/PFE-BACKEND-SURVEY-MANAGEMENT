package com.ennajim.surveyms.controller;


import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.entities.Survey;
import com.ennajim.surveyms.repository.SurveyRepository;
import com.ennajim.surveyms.services.SurveyService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyRepository surveyRepository ;
    @Autowired
    private ModelMapper modelMapper ;
    @Operation(summary = "Add Survey", description = "Add a Survey", tags = "ADD")
    @PostMapping("/survey")
    private ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
        return ResponseEntity.ok(this.surveyService.addSurvey(survey));
    }

    @GetMapping("/survey/all")
    private List<Survey> getAll() {
        return surveyService.getAll();
    }

    @GetMapping("/survey/general")
    private List<Survey> getGeneral() {
        return surveyService.findByfield("general");
    }

    @GetMapping("/survey/informatique")
    private List<Survey> getInformatique() {
        return surveyService.findByfield("informatique");
    }

    @GetMapping("/survey/finances")
    private List<Survey> getFinances() {
        return surveyService.findByfield("finances");
    }

    @Operation(summary = "Get Survey Count", description = "Get the count of surveys", tags = "GET")
    @GetMapping("/survey/count")
    public long count() {
        return surveyService.count();
    }

    @Operation(summary = "Delete Survey by ID", description = "Delete a survey by its ID", tags = "DELETE")
    @DeleteMapping("/survey/{Id}")
    private void deleteByIduser(@PathVariable(name = "Id") Long Id) {
        surveyService.deleteByIdSurvey(Id);
    }

    @Operation(summary = "Get Questions by Survey Id", description = "gets all the questions of the survey requested by id", tags = "GET")
    @GetMapping("/survey/{Id}/questions")
    public List<Question> getQuestionsBySurveyId(@PathVariable(name="Id") Long Id) {
        Survey survey = surveyRepository.findById(Id).orElse(null);
        if (survey != null) {
            return survey.getQuestions();
        } else {
            throw new IllegalArgumentException("Invalid survey ID: " + Id);
        }
    }

    @Operation(summary = "Get Survey by Id", description = "gets a survey by id", tags = "GET")
    @GetMapping("/survey/{id}")
    public Optional<Survey> getSurveyById(@PathVariable("id")Long id){
        return surveyRepository.findById(id);
    }

}

