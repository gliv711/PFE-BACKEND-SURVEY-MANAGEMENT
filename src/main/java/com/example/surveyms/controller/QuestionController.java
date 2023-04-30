package com.example.surveyms.controller;


import com.example.surveyms.model.Question;
import com.example.surveyms.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/all")
    private ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(this.questionService.getQuestionById(id));
    }

    @PostMapping
    private ResponseEntity<Question> addQuestion(Question question) {
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
