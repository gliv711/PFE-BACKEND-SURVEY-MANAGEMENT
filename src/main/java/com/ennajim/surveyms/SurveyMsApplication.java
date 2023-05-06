package com.ennajim.surveyms;

import com.ennajim.surveyms.repository.QuestionRepository;
import com.ennajim.surveyms.repository.SurveyRepository;
import com.ennajim.surveyms.entities.Answer;
import com.ennajim.surveyms.entities.Question;
import com.ennajim.surveyms.repository.AnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SurveyMsApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(SurveyMsApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

   @Bean
    CommandLineRunner commandLineRunner (SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository){
       Question question1 = new Question(null, "What is your name?","gen",null,null);
       Question question2 = new Question(null, "What is your age?","gen",null,null);
       List<Question> list_q = new ArrayList<>();
        list_q.add(question1);
        list_q.add(question2);

        Answer a = new Answer(null,"Yes",true,list_q);
        Answer b = new Answer(null,"No",true,list_q);

       return args -> {
            questionRepository.save(question1);
            questionRepository.save(question2);

            answerRepository.save(a);
           answerRepository.save(b);


       };
    }

}
