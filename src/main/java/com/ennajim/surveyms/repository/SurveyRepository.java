package com.ennajim.surveyms.repository;


import com.ennajim.surveyms.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {
/*
    List<Survey> findByFieldContains(String field);
*/

}
