package com.ennajim.surveyms.Dto;

import lombok.Data;

@Data
public class QuestionDto {
    private Long question_id;
    private String question;
    private String field ;
}
