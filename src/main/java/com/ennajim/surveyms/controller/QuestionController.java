package com.ennajim.surveyms.controller;


import com.ennajim.surveyms.Dto.QuestionDto;
import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private  ModelMapper modelMapper;
    @GetMapping("/questions/all")
    public List<QuestionDto> getAllQuestions2(){
        return questionService.getAllQuestions().stream().map(question -> modelMapper.map(question,QuestionDto.class))
                .collect(Collectors.toList());
    }





/*    @GetMapping("/questions/all")
    private ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }*/

    @GetMapping("/{id}")
    private ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(this.questionService.getQuestionById(id));
    }

    @PostMapping("/questions")
    private ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }



    @DeleteMapping("/questions/{id}")
    private ResponseEntity<Void> deleteQuestion(Long id) {
        this.questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/questions/count")
    public long count(){
        return this.questionService.count();
    }


}
