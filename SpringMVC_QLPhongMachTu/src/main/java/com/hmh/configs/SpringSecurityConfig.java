/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
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
    private Environment env;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("customSuccessHandler")
    private CustomSuccessHandler customSuccessHandler;

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

        http.formLogin().successHandler(customSuccessHandler).
                failureUrl("/dangnhap?error");

        http.logout().logoutSuccessUrl("/dangnhap");

        http.exceptionHandling().accessDeniedPage("/dangnhap?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/benhnhan/dangkykham/**").access("hasRole('BENHNHAN')");

        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/benhnhan/lichsukham/**").access("hasRole('BENHNHAN')");

        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/yta/lapdskham/**").access("hasRole('YTA')");

        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/admin/quanlythuoc/**").access("hasRole('ADMIN')");

        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/admin/quanlytaikhoan/**").access("hasRole('ADMIN')");

        http.csrf().disable();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
                        "api_key", this.env.getProperty("cloudinary.api_id"),
                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
                        "secure", true));
        return cloudinary;
    }

    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    public CustomDateEditor customDateEditor() {
        return new CustomDateEditor(simpleDateFormat(), true);
    }

}
