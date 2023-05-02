package com.example.surveyms.controller;

import com.example.surveyms.Dto.AnswerDto;
import com.example.surveyms.Dto.QuestionDto;
import com.example.surveyms.entity.Answer;
import com.example.surveyms.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnswerController {
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private AnswerService answerService;

    @GetMapping("/answers/all")
    public List<AnswerDto> getAllAnswers(){
        return answerService.getAllAnswers().stream().map(answer -> modelMapper.map(answer,AnswerDto.class))
                .collect(Collectors.toList());
    }
  /*  @GetMapping("/answers/all")
    private ResponseEntity<List<Answer>> getAllAnswers() {
        return ResponseEntity.ok(this.answerService.getAllAnswers());
    }*/

    @PostMapping("/answers")
    private ResponseEntity<Answer> addAnswers(@RequestBody Answer answer) {
        return ResponseEntity.ok(this.answerService.addAnswer(answer));
    }


}
