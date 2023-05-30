package com.ennajim.surveyms.security;

import com.ennajim.surveyms.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/api/login/**","/api/user/refreshtoken","/api/user","/api/user/email/{email}","/api/company","/api/admin").permitAll();


        http.authorizeRequests().antMatchers(GET,"/api/user/all/**","/api/user/**","/api/user/count").hasAnyAuthority("admin");

        http.authorizeRequests().antMatchers(DELETE,"/api/user/{Id}").hasAnyAuthority("superAdmin");
        http.authorizeRequests().antMatchers(GET,"/api/questions/all","/api/answers/all").hasAnyAuthority("admin");


        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
    }

