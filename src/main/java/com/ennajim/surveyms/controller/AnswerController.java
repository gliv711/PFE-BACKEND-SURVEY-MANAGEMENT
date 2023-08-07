package com.ennajim.surveyms.controller;

import com.ennajim.surveyms.entities.Answer;
import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.repository.AnswerRepository;
import com.ennajim.surveyms.repository.QuestionRepository;
import com.ennajim.surveyms.services.AnswerService;
import com.ennajim.surveyms.Dto.AnswerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnswerController {
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerRepository answerRepository ;

    @Autowired
    private QuestionRepository questionRepository ;

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
/*
        Optional<Answer> answer = answerRepository.findById(answer_id);
*/

        return ResponseEntity.ok(this.answerService.addAnswer(answer));
    }

    @GetMapping("/answers/count")
    public long count(){
        return this.answerService.count();
    }


    @DeleteMapping("/answers/{answer_id}")
    public void deleteAnswer(@PathVariable("answer_id") Long answer_id) {
        Optional<Answer> answer = answerRepository.findById(answer_id);
        if (answer.isPresent()) {
            // remove the answer from the list of answers in the associated questions
            List<Question> questions = answer.get().getQuestions();
            for (Question question : questions) {
                question.getAnswers().remove(answer.get());
                questionRepository.save(question);
            }

            // delete the answer from the question_answer table
            answer.get().setQuestions(null);
            answerRepository.save(answer.get());

            // delete the answer from the database
            answerRepository.delete(answer.get());
        } else {
            throw new ResourceNotFoundException("Answer not found");
        }
    }

    @GetMapping("/answers/{answer_id}")
    public Optional<Answer> getbyId(@PathVariable("answer_id") Long answer_id) {
        return answerService.getbyid(answer_id);
    }


}
