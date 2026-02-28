package com.security.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /**
        http.csrf(customiser -> customiser.disable());
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());
        // Enabling the login form
        http.formLogin(Customizer.withDefaults());
        // Enabling the login for the postman
        http.httpBasic(Customizer.withDefaults());
        // Made session stateless means our JSESSION id will be change everytime
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
         **/

       return http.csrf(customiser -> customiser.disable())
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
        // Enabling the login form
        .formLogin(Customizer.withDefaults())
        // Enabling the login for the postman
        .httpBasic(Customizer.withDefaults())
        // Made session stateless means our JSESSION id will be change everytime
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }

    /*
     UnAuthenticated object --> Authentication provider --> Authenticated
     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

    }
}
