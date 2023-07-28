/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Asus
 */
@Controller
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.hmh.repository",
    "com.hmh.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //chung thuc
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //phan quyen
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/dangnhap").usernameParameter("username").passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/").failureUrl("/dangnhap?error");

        http.logout().logoutSuccessUrl("/dangnhap");

        http.exceptionHandling().accessDeniedPage("/dangnhap?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/dangkykham/**").access("hasRole('BENHNHAN')");

        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/lapdskham/**").access("hasRole('YTA')");

        http.csrf().disable();
    }

}
