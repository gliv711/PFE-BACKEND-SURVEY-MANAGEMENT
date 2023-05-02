package com.example.surveyms.repository;


import com.example.surveyms.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
/*
    List<Survey> findByFieldContains(String field);
*/

}
