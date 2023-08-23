/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.TaiKhoan;
import com.hmh.service.KhamBenhService;
import com.hmh.service.LapDsKhamService;
import com.hmh.service.TaiKhoanService;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class KhamBenhController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private LapDsKhamService phieuDangKyService;

    @Autowired
    private KhamBenhService khamBenhService;

    @GetMapping("/bacsi/khambenh")
    public String khambenh(Model model, Authentication authentication, @RequestParam Map<String, String> params) {
        model.addAttribute("user", new TaiKhoan());
        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        return "khambenh";
    }

    @GetMapping("/bacsi/khambenh/{id}")
    public String khamBenhByID(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params, Authentication authentication) {

        model.addAttribute("idpdk", this.khamBenhService.getPDK(id));

        model.addAttribute("listDv", this.khamBenhService.getDichVu());
        model.addAttribute("dsdv", new DichVu());
        return "khambenh";
    }

    @PostMapping("/bacsi/khambenh")
    public String lapPhieuKham(Model model, @RequestParam Map<String, String> params, Authentication authentication) {

        return "khambenh";
    }
}
