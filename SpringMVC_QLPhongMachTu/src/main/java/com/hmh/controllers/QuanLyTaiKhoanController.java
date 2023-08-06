/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.service.BenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asus
 */
@Controller
public class QuanLyTaiKhoanController {
    @Autowired
    private BenhNhanService benhNhanService;
    
    @RequestMapping("/admin/quanlytaikhoan")
    public String lapdskham(Model model){
        model.addAttribute("benhnhan", this.benhNhanService.getBenhNhan(null));
        return "quanlytaikhoan";
    }
}
