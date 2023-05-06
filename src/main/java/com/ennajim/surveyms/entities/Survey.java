package com.ennajim.surveyms.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Survey {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String title ;
        private String description ;
   @ManyToMany
        @JoinTable(
                name = "survey_question",
                joinColumns = @JoinColumn(name = "survey_id"),
                inverseJoinColumns = @JoinColumn(name = "question_id"))
        private List<Question> questions;

}

