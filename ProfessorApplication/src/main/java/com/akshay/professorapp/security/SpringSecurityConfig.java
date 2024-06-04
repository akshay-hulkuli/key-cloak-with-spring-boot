package com.akshay.professorapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain buildSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll()
                .anyRequest()
                .authenticated()
        );
        httpSecurity.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("username")
                .passwordParameter("password")
        );
        httpSecurity.logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/login"));
        httpSecurity.exceptionHandling(eH -> eH.accessDeniedPage("/access-denied"));
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.headers(headers -> headers
                .frameOptions(frameOptionsConfig -> frameOptionsConfig.disable())
        );
        return httpSecurity.build();
    }

    @Bean
    UserDetailsServiceImpl customUserDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder configurePasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsServiceImpl());
        provider.setPasswordEncoder(configurePasswordEncoder());
        return provider;
    }
}
