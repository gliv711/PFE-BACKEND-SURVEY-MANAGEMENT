package com.ennajim.surveyms.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AnswerDto {
    private Long answer_id;
    private String answer;
    private Boolean status;
}
