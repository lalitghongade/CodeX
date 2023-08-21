package com.lala.starter.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class MyConfig {

    //we created customeUserdetailsService thats why commenting it
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails userDetails = User.builder().
    //             username("lalit")
    //             .password(passwordEncoder().encode("lalit")).roles("ADMIN").
    //             build();
    //     return new InMemoryUserDetailsManager(userDetails);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }



}