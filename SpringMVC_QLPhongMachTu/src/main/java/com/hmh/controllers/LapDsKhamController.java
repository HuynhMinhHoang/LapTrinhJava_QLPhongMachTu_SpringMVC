/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import com.hmh.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import com.hmh.service.LapDsKhamService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class LapDsKhamController {

    @Autowired
    private LapDsKhamService phieuDangKyService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/yta/lapdskham")
    public String lapdskham(Model model, Authentication authentication, @RequestParam Map<String, String> params) {
        model.addAttribute("user", new TaiKhoan());
        model.addAttribute("themDSpkd", new PhieuDangKy());
        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(params));
        model.addAttribute("dsbacsi", this.phieuDangKyService.getBacSi());

        return "lapdskham";
    }

    @GetMapping("/yta/lapdskham/{id}")
    public String lapdskham(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params, Authentication authentication) {

        model.addAttribute("user", new TaiKhoan());

        if (authentication != null) {
            UserDetails userDetails = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan tk = this.taiKhoanService.getTaiKhoanByUsername(userDetails.getUsername());

            model.addAttribute("user", tk);

            if (this.phieuDangKyService.trangThai(id, tk) == true) {
                return "redirect:/yta/lapdskham";
            }
        }

        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(params));

        return "lapdskham";
    }

    @PostMapping("/yta/lapdskham")
    public String lapdskham(Model model, @ModelAttribute(value = "themDSpkd") PhieuDangKy pdk, @RequestParam Map<String, String> params) {

        
        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(params));

        return "lapdskham";
    }

}
