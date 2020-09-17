package com.project.giftoo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImplimentation userDetailsServiceImplimentation;

    public SecurityConfiguration(UserDetailsServiceImplimentation userDetailsServiceImplimentation) {
        this.userDetailsServiceImplimentation = userDetailsServiceImplimentation;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers(EndpointRequest.to("/")).permitAll()
                //.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                //.antMatchers("/actuator/").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                //.antMatchers("/submit").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .and()
            .formLogin()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImplimentation);

    }
}
