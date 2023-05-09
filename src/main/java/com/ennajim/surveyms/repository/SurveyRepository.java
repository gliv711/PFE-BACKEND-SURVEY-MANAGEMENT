package com.ennajim.surveyms.repository;


import com.ennajim.surveyms.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long> {

    Survey findByField(String field);


}
