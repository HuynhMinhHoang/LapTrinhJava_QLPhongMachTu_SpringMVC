/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.HoaDon;
import com.hmh.service.KhamBenhService;
import com.hmh.service.QuanLyThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Asus
 */
@Controller
public class DichVuController {

    @Autowired
    private KhamBenhService khamBenhService;

    @Autowired
    private QuanLyThuocService quanLyThuocService;

    @GetMapping("/admin/dichvu")
    public String dichvu(Model model) {
        model.addAttribute("listDV", this.khamBenhService.getDichVu());
        model.addAttribute("taoDV", new DichVu());

        return "dichvu";
    }

    @PostMapping("/admin/dichvu")
    public String themDichVu(Model model, @ModelAttribute(value = "taoDV") DichVu dv) {
        if (quanLyThuocService.themDichVu(dv) == true) {
            return "redirect:/admin/dichvu";
        }
        return "dichvu";
    }
}
