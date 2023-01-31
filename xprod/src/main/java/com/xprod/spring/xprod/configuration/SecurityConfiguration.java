package com.xprod.spring.xprod.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       super.configure(auth);
    }
    
    
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
    }

}