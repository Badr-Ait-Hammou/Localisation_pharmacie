package com.example.localisation_pharmacie.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.localisation_pharmacie.entity.Role.*;
import static com.example.localisation_pharmacie.entity.Permission.*;
import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {


    private final JwtAuthenticationFilter jwtAuth;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/api/auth/**"
                )
                .permitAll()
                .requestMatchers("/api/controller/**").hasAnyRole(ADMIN.name(), EMPLOYEE.name(),USER.name())
                .requestMatchers(GET, "/api/controller/**").hasAnyAuthority(ADMIN_READ.name(), EMPLOYEE_READ.name())
                .requestMatchers(POST, "/api/controller/**").hasAnyAuthority(ADMIN_CREATE.name(), EMPLOYEE_CREATE.name())
                .requestMatchers(PUT, "/api/controller/**").hasAnyAuthority(ADMIN_UPDATE.name(), EMPLOYEE_UPDATE.name())
                .requestMatchers(DELETE, "/api/controller/**").hasAnyAuthority(ADMIN_DELETE.name(), EMPLOYEE_DELETE.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuth, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;
        return http.build();
    }
}
