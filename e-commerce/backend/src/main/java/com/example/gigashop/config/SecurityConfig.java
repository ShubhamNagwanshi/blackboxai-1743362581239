package com.example.gigashop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll() // Allow H2 console
                .requestMatchers(AntPathRequestMatcher.antMatcher("/api/products/**")).permitAll() // Temporary open access
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable()) // Needed for H2 console
            .httpBasic(basic -> {});

        return http.build();
    }
}