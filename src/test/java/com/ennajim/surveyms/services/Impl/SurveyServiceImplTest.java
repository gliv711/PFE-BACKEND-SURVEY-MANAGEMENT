package com.ennajim.surveyms.services.Impl;

import com.ennajim.surveyms.entities.Survey;
import com.ennajim.surveyms.repository.SurveyRepository;
import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SurveyServiceImplTest {
    private SurveyServiceImpl surveyService;

    @Mock
    private SurveyRepository surveyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        surveyService = new SurveyServiceImpl();
        try {
            FieldUtils.getField(SurveyServiceImpl.class, "surveyRepository", true).set(surveyService, surveyRepository);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addSurvey_ShouldReturnSavedSurvey() {
        Survey survey = new Survey();
        when(surveyRepository.save(survey)).thenReturn(survey);

        Survey savedSurvey = surveyService.addSurvey(survey);

        assertEquals(survey, savedSurvey);
        verify(surveyRepository, times(1)).save(survey);
    }

    @Test
    void getAll_ShouldReturnAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        when(surveyRepository.findAll()).thenReturn(surveys);

        List<Survey> result = surveyService.getAll();

        assertEquals(surveys, result);
        verify(surveyRepository, times(1)).findAll();
    }

    @Test
    void findByfield_ShouldReturnSurveysWithMatchingField() {
        String field = "exampleField";
        List<Survey> surveys = new ArrayList<>();
        when(surveyRepository.findByfield(field)).thenReturn(surveys);

        List<Survey> result = surveyService.findByfield(field);

        assertEquals(surveys, result);
        verify(surveyRepository, times(1)).findByfield(field);
    }

    @Test
    void saveAll_ShouldReturnSavedSurveys() {
        List<Survey> surveys = new ArrayList<>();
        when(surveyRepository.saveAll(surveys)).thenReturn(surveys);

        List<Survey> savedSurveys = surveyService.saveAll(surveys);

        assertEquals(surveys, savedSurveys);
        verify(surveyRepository, times(1)).saveAll(surveys);
    }

    @Test
    void deleteByIdSurvey_ShouldDeleteSurveyWithGivenId() {
        Long id = 1L;

        surveyService.deleteByIdSurvey(id);

        verify(surveyRepository, times(1)).deleteById(id);
    }

    @Test
    void count_ShouldReturnNumberOfSurveys() {
        long count = 10L;
        when(surveyRepository.count()).thenReturn(count);

        long result = surveyService.count();

        assertEquals(count, result);
        verify(surveyRepository, times(1)).count();
    }
}
