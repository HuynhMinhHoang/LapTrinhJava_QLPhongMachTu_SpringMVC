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
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private LapDsKhamService lapDsKhamService;

    @Autowired
    private CustomDateEditor customDateEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("dsbacsi", this.phieuDangKyService.getBacSi());
    }

    @GetMapping("/yta/lapdskham")
    public String lapdskham(Model model, Authentication authentication, @RequestParam Map<String, String> params) {
//        model.addAttribute("user", new TaiKhoan());
        model.addAttribute("themDSpkd", new PhieuDangKy());
        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(null));

        model.addAttribute("dskham", this.phieuDangKyService.timKiemPDK(params));

        return "lapdskham";
    }

    @GetMapping("/yta/lapdskham/{id}")
    public String lapdskham(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params, Authentication authentication,
            @RequestParam("idPhieudk") int idPhieuDangKy,
            @RequestParam("idBs") int idBacSi) {

//        model.addAttribute("user", new TaiKhoan());
        if (authentication != null) {
            UserDetails userDetails = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan tk = this.taiKhoanService.getTaiKhoanByUsername(userDetails.getUsername());

            model.addAttribute("user", tk);

            if (this.phieuDangKyService.trangThai(id, tk) == true) {
                return "redirect:/yta/lapdskham";
            }
        }
//        model.addAttribute("themDSpkd", lapDsKhamService.chonBacSiChoPhieuDangKy(idPhieuDangKy, idBacSi));
        model.addAttribute("themDSpkd", this.phieuDangKyService.getPhieuDangKyById(id));

        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(null));

        return "lapdskham";
    }

    @PostMapping("/yta/lapdskham")
    public String lapdskham(Model model, @ModelAttribute(value = "themDSpkd") PhieuDangKy pdk) {

        String err = "";

//        if (this.phieuDangKyService.themPhieuDangKy(pdk) == true) {
//            return "redirect:/yta/lapdskham";
//        } else {
//            err = "Khong thanh cong";
//        }
        model.addAttribute("err", err);
        model.addAttribute("dskham", this.phieuDangKyService.getPhieuDangKy(null));

        return "lapdskham";
    }

}
