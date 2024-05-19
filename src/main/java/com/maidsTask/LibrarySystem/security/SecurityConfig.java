package com.maidsTask.LibrarySystem.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
   private IsAuth isAuth;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf().disable().cors().disable();
        httpSecurity.addFilterBefore(isAuth, AuthorizationFilter.class);

        //change permissions to access the end point
        httpSecurity.authorizeHttpRequests().
                requestMatchers("/api/patrons","/api/patrons/**","/api/books","/api/books/**").permitAll().
                //All endpoints are public except borrowing and returning endpoints needs authentication using jwt
                anyRequest().authenticated();
        return httpSecurity.build();
    }
}
