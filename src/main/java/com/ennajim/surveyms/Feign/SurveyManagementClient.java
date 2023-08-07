package com.ennajim.surveyms.Feign;

import com.ennajim.surveyms.entities.Answer;
import com.ennajim.surveyms.entities.Survey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface SurveyManagementClient {
    @GetMapping("/api/surveys/{surveyId}")
    Survey getSurveyById(@PathVariable("surveyId") Long surveyId);

    @GetMapping("/api/surveys/{surveyId}/answers")
    List<Answer> getAnswersBySurveyId(@PathVariable("surveyId") Long surveyId);
}
