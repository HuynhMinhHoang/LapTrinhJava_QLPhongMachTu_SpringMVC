/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
//import com.hmh.service.DangKyKhamService;
import com.hmh.service.LapDsKhamService;
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

/**
 *
 * @author Asus
 */
@Controller
public class DangKyKhamController {

    @Autowired
    private TaiKhoanService taiKhoanService;

//    @Autowired
//    private DangKyKhamService dangKyKhamService;
    @Autowired
    private LapDsKhamService lapDsKhamService;

    @GetMapping("/benhnhan/dangkykham")
    public String dangkykham(Model model, Authentication authentication) {
//        model.addAttribute("user", new TaiKhoan());
        model.addAttribute("themphieudky", new PhieuDangKy());
        UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
        TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
        model.addAttribute("user", u);

        model.addAttribute("user", this.taiKhoanService.getTaiKhoan(authentication.getName()).get(0));

        return "dangkykham";
    }

    @GetMapping("/benhnhan/dangkykham/{id}")
    public String updateTaiKhoanBenhNhan(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.taiKhoanService.getTaiKhoanById(id));
        return "dangkykham";
    }

    @PostMapping("/benhnhan/dangkykham")
    public String updateBenhNhanPhieuDky(@ModelAttribute(value = "themphieudky") PhieuDangKy pdk,
            Authentication authentication) {

        String errMsg = "";
        if (this.lapDsKhamService.themPhieuDangKy(pdk) == true) {
            return "redirect:/benhnhan/lichsukham";
        } else {
            errMsg = " Đăng ký khám không thành công!";
        }
        return "dangkykham";
    }

}
