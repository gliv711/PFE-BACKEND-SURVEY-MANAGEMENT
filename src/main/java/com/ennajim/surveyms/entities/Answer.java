package com.ennajim.surveyms.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;
    @Column(name="answer")
    private String answer;
    @Column(name="status")
    private Boolean status;
    @ManyToMany(mappedBy = "answers",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;



}
