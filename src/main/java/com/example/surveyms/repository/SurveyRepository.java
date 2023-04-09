package com.example.surveyms.repository;

import com.example.surveyms.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
    List<Survey> findByFieldContains(String field);

}
