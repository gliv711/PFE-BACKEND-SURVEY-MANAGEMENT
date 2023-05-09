package com.ennajim.surveyms.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;
    @Column(name = "question")
    private String question;
    private String field ;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List<Answer> answers ;
    @JsonIgnore
   @ManyToMany(mappedBy = "questions",cascade = CascadeType.ALL)
    private List<Survey> surveys ;

}



