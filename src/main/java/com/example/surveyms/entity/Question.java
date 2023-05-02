package com.example.surveyms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Answer> answers = new ArrayList<>();

/*    @ManyToMany(mappedBy = "questions")
    private List<Survey> surveys ;*/

}



