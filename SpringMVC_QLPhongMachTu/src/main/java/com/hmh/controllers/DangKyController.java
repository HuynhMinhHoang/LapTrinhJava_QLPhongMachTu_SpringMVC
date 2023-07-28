/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.TaiKhoan;
import com.hmh.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class DangKyController {

    @Autowired
    private TaiKhoanService userDetailsService;

//    @RequestMapping("/dangky")
//    public String dangky() {
//        return "dangky";
//    }
    @GetMapping("/dangky")
    public String dangky(Model model) {
        model.addAttribute("user", new TaiKhoan());
        return "dangky";
    }

    @PostMapping("/dangky")
    public String dangky(Model model, @ModelAttribute(value = "user") TaiKhoan user) {
        String errMsg = "";
        if (user.getMatKhau().equals(user.getConfirmmatKhau())) {
            if (this.userDetailsService.addTaiKhoan(user) == true) {
                return "redirect:/dangnhap";
            } else {
                errMsg = "Mat khau khong khop!!";
            }
        
        } else {
            errMsg = "Mat khau khong khop!!";
        }

        model.addAttribute("errMsg", errMsg);

        return "dangky";
    }
}
