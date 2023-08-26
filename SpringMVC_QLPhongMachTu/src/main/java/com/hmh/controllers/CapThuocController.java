/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.TaiKhoan;
import com.hmh.service.CapThuocService;
import com.hmh.service.KhamBenhService;
import com.hmh.service.LapDsKhamService;
import com.hmh.service.LapPhieuKhamService;
import com.hmh.service.TaiKhoanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class CapThuocController {

    @Autowired
    private LapDsKhamService phieuDangKyService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private LapPhieuKhamService lapPhieuKhamService;

    @Autowired
    private CapThuocService capThuocService;

    @Autowired
    private KhamBenhService khamBenhService;

    @GetMapping("/bacsi/capthuoc")
    public String capthuoc(Model model, Authentication authentication, @RequestParam("idPDK") int idPDK, @RequestParam Map<String, String> params) {

        model.addAttribute("addChiTietThuoc", new ChiTietThuoc());

        model.addAttribute("listThuoc", this.capThuocService.getListThuoc(params));
        model.addAttribute("listThuoc", this.capThuocService.timKiemThuoc(params));

        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);

        }

        PhieuDangKy phieuDangKy = this.khamBenhService.getPDK(idPDK);

        model.addAttribute("idPDK", idPDK);
        model.addAttribute("idpdk", phieuDangKy);

        return "capthuoc";
    }

    @GetMapping("/bacsi/capthuoc/{id}")
    public String khamBenhByID(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params, Authentication authentication) {

        model.addAttribute("addChiTietThuoc", new ChiTietThuoc());

        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        return "capthuoc";
    }

    @PostMapping("/bacsi/capthuoc")
    public String taoChiTietThuoc(Model model, @ModelAttribute(value = "addChiTietThuoc") ChiTietThuoc cct, @RequestParam Map<String, String> params,
            @RequestParam("idPDK") int idPDK) {

        if (this.capThuocService.themPhieuThuoc(cct) == true) {
            return "redirect:/bacsi/capthuoc?idPDK=" + idPDK;
        }

        return "capthuoc";
    }

}
