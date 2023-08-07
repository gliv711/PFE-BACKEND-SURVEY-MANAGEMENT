package com.ennajim.surveyms.services.Impl;

import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class QuestionServiceImplTest {
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questionService = new QuestionServiceImpl();
    }
    @Test
    void addQuestion_ShouldReturnSavedQuestion() {
        Question question = new Question();
        when(questionRepository.save(question)).thenReturn(question);

        Question savedQuestion = questionService.addQuestion(question);

        assertEquals(question, savedQuestion);
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void getAllQuestions_ShouldReturnAllQuestions() {
        List<Question> questions = new ArrayList<>();
        when(questionRepository.findAll()).thenReturn(questions);

        List<Question> result = questionService.getAllQuestions();

        assertEquals(questions, result);
        verify(questionRepository, times(1)).findAll();
    }

    @Test
    void getQuestionById_ExistingId_ShouldReturnQuestion() {
        Long id = 1L;
        Question question = new Question();
        when(questionRepository.findById(id)).thenReturn(Optional.of(question));

        Question result = questionService.getQuestionById(id);

        assertEquals(question, result);
        verify(questionRepository, times(1)).findById(id);
    }

    @Test
    void getQuestionById_NonExistingId_ShouldReturnNull() {
        Long id = 1L;
        when(questionRepository.findById(id)).thenReturn(Optional.empty());

        Question result = questionService.getQuestionById(id);

        assertEquals(null, result);
        verify(questionRepository, times(1)).findById(id);
    }

    @Test
    void updateQuestion_ShouldReturnUpdatedQuestion() {
        Question question = new Question();
        when(questionRepository.save(question)).thenReturn(question);

        Question updatedQuestion = questionService.updateQuestion(question);

        assertEquals(question, updatedQuestion);
        verify(questionRepository, times(1)).save(question);
    }

    @Test
    void deleteQuestion_ValidId_ShouldDeleteQuestion() {
        Long questionId = 1L;

        questionService.deleteQuestion(questionId);

        verify(questionRepository, times(1)).deleteById(questionId);
    }

    @Test
    void deleteQuestion_NullId_ShouldNotDeleteQuestion() {
        Long questionId = null;

        questionService.deleteQuestion(questionId);

        verify(questionRepository, never()).deleteById(anyLong());
    }

    @Test
    void count_ShouldReturnNumberOfQuestions() {
        long count = 10L;
        when(questionRepository.count()).thenReturn(count);

        long result = questionService.count();

        assertEquals(count, result);
        verify(questionRepository, times(1)).count();
    }
}
