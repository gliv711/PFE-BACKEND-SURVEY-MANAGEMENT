package com.example.surveyms.repository;


import com.example.surveyms.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
    List<Survey> findByFieldContains(String field);

}
