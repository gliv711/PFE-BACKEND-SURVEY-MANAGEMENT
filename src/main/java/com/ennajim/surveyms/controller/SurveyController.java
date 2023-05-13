package com.ennajim.surveyms.controller;


import com.ennajim.surveyms.Dto.QuestionDto;
import com.ennajim.surveyms.Dto.SurveyDto;
import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.entities.Survey;
import com.ennajim.surveyms.repository.SurveyRepository;
import com.ennajim.surveyms.services.SurveyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/survey")
    private ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
        return ResponseEntity.ok(this.surveyService.addSurvey(survey));
    }


    @GetMapping("/survey/general")
    private Survey getGeneral(){
        return surveyService.findByField("general");
    }


//    @GetMapping("/survey/all")
//    private List<SurveyDto> getAll(){
//        return surveyService.getAll().stream().map(survey -> modelMapper.map(survey, SurveyDto.class))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/survey/all")
    private List<Survey> getAll(){
        return surveyService.getAll();
    }

    /*@GetMapping("/survey/general")
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
*/
    @GetMapping("/survey/count")
    public long count(){
        return surveyService.count();
    }




    @DeleteMapping("/survey/{Id}")
    private void deleteByIduser(@PathVariable(name="Id") Long Id) {
        surveyService.deleteByIdSurvey(Id);
    }

    @GetMapping("/survey/{Id}/questions")
    public List<Question> getQuestionsBySurveyId(@PathVariable(name="Id") Long Id) {
        Survey survey = surveyRepository.findById(Id).orElse(null);
        if (survey != null) {
            return survey.getQuestions();
        } else {
            throw new IllegalArgumentException("Invalid survey ID: " + Id);
        }
    }

}

