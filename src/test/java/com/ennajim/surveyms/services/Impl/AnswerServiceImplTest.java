package com.ennajim.surveyms.services.Impl;

import com.ennajim.surveyms.entities.Answer;
import com.ennajim.surveyms.repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AnswerServiceImplTest {
    private AnswerServiceImpl answerService;

    @Mock
    private AnswerRepository answerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        answerService = new AnswerServiceImpl();
    }

    @Test
    void addAnswer_ShouldReturnSavedAnswer() {
        Answer answer = new Answer();
        when(answerRepository.save(answer)).thenReturn(answer);

        Answer savedAnswer = answerService.addAnswer(answer);

        assertEquals(answer, savedAnswer);
        verify(answerRepository, times(1)).save(answer);
    }

    @Test
    void getAllAnswers_ShouldReturnAllAnswers() {
        List<Answer> answers = new ArrayList<>();
        when(answerRepository.findAll()).thenReturn(answers);

        List<Answer> result = answerService.getAllAnswers();

        assertEquals(answers, result);
        verify(answerRepository, times(1)).findAll();
    }

    @Test
    void count_ShouldReturnNumberOfAnswers() {
        long count = 10L;
        when(answerRepository.count()).thenReturn(count);

        long result = answerService.count();

        assertEquals(count, result);
        verify(answerRepository, times(1)).count();
    }

    @Test
    void deleteAnswer_ValidId_ShouldDeleteAnswer() {
        Long answerId = 1L;

        answerService.deleteAnswer(answerId);

        verify(answerRepository, times(1)).deleteById(answerId);
    }
}
