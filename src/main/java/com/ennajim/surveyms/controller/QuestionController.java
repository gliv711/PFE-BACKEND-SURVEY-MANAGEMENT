package com.ennajim.surveyms.controller;


import com.ennajim.surveyms.Dto.QuestionDto;
import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.entities.Survey;
import com.ennajim.surveyms.repository.QuestionRepository;
import com.ennajim.surveyms.repository.SurveyRepository;
import com.ennajim.surveyms.services.QuestionService;
import com.ennajim.surveyms.services.SurveyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private  QuestionService questionService;
    @Autowired
    private QuestionRepository questionRepository ;

    @Autowired
    private SurveyRepository surveyRepository ;
    @Autowired
    private  ModelMapper modelMapper;
//    @GetMapping("/questions/all")
//    public List<QuestionDto> getAllQuestions2(){
//        return questionService.getAllQuestions().stream().map(question -> modelMapper.map(question,QuestionDto.class))
//                .collect(Collectors.toList());
//    }





   @GetMapping("/questions/all")
    private ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(this.questionService.getQuestionById(id));
    }

    @PostMapping("/questions")
    private ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }



    @DeleteMapping("/questions/{question_id}")
    private ResponseEntity<Void> deleteQuestion(@PathVariable("question_id")Long question_id) {
        Question question = questionRepository.findById(question_id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        for (Survey survey : question.getSurveys()) {
            survey.getQuestions().remove(question);
            surveyRepository.save(survey);
        }

        questionRepository.delete(question);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/questions/count")
    public long count(){
        return this.questionService.count();
    }


}
