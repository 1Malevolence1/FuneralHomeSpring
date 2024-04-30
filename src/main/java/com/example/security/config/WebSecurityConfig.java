/*
package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    // авторизация
    //authorizeHttpRequests - используется для настроки http авторизации
    // requestMatchers - указываем параметры запросы, к которым будут применяться те или иные правила доступа
    // denyAll() - никто не моежт получить доступ
    //anonymous() - досут может иметь только не аунтифицированный пользователь
    //authenticated() - пользоватлеь для указанной страницы должен быть анутифицирован
    // remeberMe() - предоставляет доступ пльзователям с долго живущей ссией
    // fullyAuthenticated() - предосталвяем доступ, когда пользователь прошёл полную авторизацию
    // hasAuthority("право") - предоставляет доступ с определённым правом
    //hasAnyAuthority() -   пользователь имеет хотябы одно из право
    // hasRole() - если у пользователя есть роль
    // hasAnyRole - хотябы одна роль
    // access() -> предоставляет функциональный подход к определению правил доступая
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/main-page/**").permitAll().anyRequest().authenticated())
                .formLogin(fromLogin -> fromLogin.loginPage("/login").permitAll().defaultSuccessUrl("/main/main-page", true)).
                logout(LogoutConfigurer::permitAll).build();

    }


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {


        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN").build();
        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
*/
