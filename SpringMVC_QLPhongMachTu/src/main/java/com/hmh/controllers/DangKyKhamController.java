/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.TaiKhoan;
import com.hmh.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class DangKyKhamController {

    @Autowired
    private TaiKhoanService taiKhoanService;

//    @GetMapping("/benhnhan/dangkykham")
//    public String dangkykham(Model model) {
//        model.addAttribute("taikhoan", new TaiKhoan());
//        return "dangkykham";
//    }
//
//    @PostMapping("/benhnhan/dangkykham")
//    public String add(@ModelAttribute(value = "taikhoan") TaiKhoan tk) {
//        if (this.taiKhoanService.addTaiKhoan(tk) == true) {
//            return "redirect:/";
//        }
//        return "dangkykham";
//    }
    @GetMapping("/benhnhan/dangkykham")
    public String dangkykham(Model model, Authentication authentication) {
        model.addAttribute("user", new TaiKhoan());
        UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
        TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);

        model.addAttribute("user", u);
        return "dangkykham";
    }

    @GetMapping("/benhnhan/dangkykham/{id}")
    public String updateTaiKhoanBenhNhan(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.taiKhoanService.getTaiKhoanById(id));
        return "dangkykham";
    }

    @PostMapping("/benhnhan/dangkykham")
    public String updateBenhNhan(@ModelAttribute(value = "user") TaiKhoan tk) {

        if (this.taiKhoanService.addTaiKhoan(tk) == true) {
            return "redirect:/";
        }

        return "dangkykham";
    }

    //        String errMsg = "";
//        if (this.taiKhoanService.addTaiKhoan(tk) == true) {
//            errMsg = " Đăng ký khám thành công, vui lòng kiểm tra email phản hồi!";
////            return "redirect:/";
//        }
//        else{
//            errMsg = " Đăng ký khám không thành công!";
//        }
//    @GetMapping("/benhnhan/dangkykham/{id}")
//    public String updateTaiKhoanAdmin(Model model,@PathVariable(value = "id") int id) {
//        model.addAttribute("info", this.taiKhoanService.getTaiKhoanById(id));
//        return "dangkykham";
//    }
}
