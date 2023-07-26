/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class DangNhapController {
    @Autowired
    private LocalSessionFactoryBean factoryBean;
    
    @RequestMapping("/dangnhap")
    @Transactional
    public String dangnhap(Model model){
       
        return "dangnhap";
    }
}
