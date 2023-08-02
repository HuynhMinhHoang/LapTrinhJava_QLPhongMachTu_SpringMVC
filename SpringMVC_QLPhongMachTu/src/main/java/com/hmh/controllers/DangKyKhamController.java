/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.BenhNhan;
import com.hmh.service.BenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DangKyKhamController {

    @Autowired
    private BenhNhanService benhNhanService;

    @GetMapping("/benhnhan/dangkykham")
    public String dangkykham(Model model) {
        model.addAttribute("benhnhan", new BenhNhan());
        return "dangkykham";
    }

    @PostMapping("/benhnhan/dangkykham")
    public String add(@ModelAttribute(value = "benhnhan") BenhNhan bn) {
        if (this.benhNhanService.addOrUpdateBenhNhan(bn) == true) {
            return "redirect:/";
        }
        return "dangkykham";
    }
}
