package com.example.employeesvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigs extends WebSecurityConfigurerAdapter {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.httpBasic().and().authorizeRequests()
    .antMatchers("/actuator/health","/actuator/info","/**").hasRole("ADMIN").and().formLogin()
        .permitAll().and().logout().permitAll().and().csrf().disable();

    }




}
