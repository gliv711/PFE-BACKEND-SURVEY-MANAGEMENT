package com.example.surveyms.controller;


import com.example.surveyms.Dto.QuestionDto;
import com.example.surveyms.entity.Question;
import com.example.surveyms.services.QuestionService;
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

    private final QuestionService questionService;

    @Autowired
    private ModelMapper modelMapper;
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

    @PutMapping
    private ResponseEntity<Question> updateQuestion(Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteQuestion(Long id) {
        this.questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
