package com.example.surveyms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Survey {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

     /*   @ManyToMany
        @JoinTable(
                name = "survey_question",
                joinColumns = @JoinColumn(name = "survey_id"),
                inverseJoinColumns = @JoinColumn(name = "question_id"))
        private List<Question> questions;

*/
}

