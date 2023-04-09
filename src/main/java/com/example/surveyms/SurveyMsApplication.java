package com.example.surveyms;

import com.example.surveyms.model.Survey;
import com.example.surveyms.repository.SurveyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurveyMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyMsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (SurveyRepository surveyRepository){
        Survey s1 = new Survey(null,"Quel est votre point faible ?","Général");
        Survey s2 = new Survey(null,"Comment évaluez-vous votre capacité à travailler en équipe ?","Général");
        Survey s3 = new Survey(null,"Comment préférez-vous recevoir des critiques constructives ?","Général");
        Survey s4 = new Survey(null,"Quelles sont vos attentes pour votre prochain poste ?","Général");
        Survey s5 = new Survey(null,"Qu'est-ce qui vous motive à travailler ?","Général");
        Survey s6 = new Survey(null,"Quels sont vos objectifs à long terme pour votre carrière ?","Général");
        Survey s7 = new Survey(null,"Comment décririez-vous votre style de travail ?","Général");
        Survey s8 = new Survey(null,"Quelle est votre plus grande réussite professionnelle jusqu'à présent ?","Général");
        Survey s9 = new Survey(null,"Quelles compétences ou connaissances aimeriez-vous développer davantage ?","Général");
        Survey s10 = new Survey(null,"Comment gérez-vous les situations de conflit ?","Général");
        Survey s11 = new Survey(null,"Comment vous préparez-vous pour un projet ou une présentation importante ?","Général");
        Survey s12 = new Survey(null,"Comment gérez-vous le stress au travail ?","Général");
        Survey s13 = new Survey(null,"Quelle est votre méthode pour prioriser les tâches ?","Général");
        Survey s14 = new Survey(null,"Comment évaluez-vous votre communication interpersonnelle ?","Général");
        Survey s15 = new Survey(null,"Quel est votre meilleur conseil pour améliorer la productivité ?","Général");
        Survey s16 = new Survey(null, "Quelle est votre plus grande réussite financière jusqu'à présent ?", "Finances");
        Survey s17= new Survey(null, "Quel est votre point faible en finance ?", "Finances");
        Survey s18 = new Survey(null, "Comment évaluez-vous votre capacité à travailler en équipe en finance ?", "Finances");
        Survey s19 = new Survey(null, "Comment préférez-vous recevoir des critiques constructives en finance ?", "Finances");
        Survey s20 = new Survey(null, "Quelles sont vos attentes pour votre prochain poste en finance ?", "Finances");
        Survey s21 = new Survey(null, "Qu'est-ce qui vous motive à travailler en finance ?", "Finances");
        Survey s22 = new Survey(null, "Quels sont vos objectifs à long terme pour votre carrière en finance ?", "Finances");
        Survey s23 = new Survey(null, "Comment décririez-vous votre style de travail en finance ?", "Finances");
        Survey s24 = new Survey(null, "Quelle est votre plus grande réussite professionnelle en finance jusqu'à présent ?", "Finances");
        Survey s25 = new Survey(null, "Quelles compétences ou connaissances aimeriez-vous développer davantage en finance ?", "Finances");

        return args -> {
            surveyRepository.save(s1);
            surveyRepository.save(s2);
            surveyRepository.save(s3);
            surveyRepository.save(s4);
            surveyRepository.save(s5);
            surveyRepository.save(s6);
            surveyRepository.save(s7);
            surveyRepository.save(s8);
            surveyRepository.save(s9);
            surveyRepository.save(s10);
            surveyRepository.save(s11);
            surveyRepository.save(s12);
            surveyRepository.save(s13);
            surveyRepository.save(s14);
            surveyRepository.save(s15);
            surveyRepository.save(s16);
            surveyRepository.save(s17);
            surveyRepository.save(s18);
            surveyRepository.save(s19);
            surveyRepository.save(s20);
            surveyRepository.save(s21);
            surveyRepository.save(s22);
            surveyRepository.save(s23);
            surveyRepository.save(s24);
            surveyRepository.save(s25);

        };
    }
}
