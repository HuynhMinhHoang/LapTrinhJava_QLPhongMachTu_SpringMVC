/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import com.hmh.service.KhamBenhService;
import com.hmh.service.LapDsKhamService;
import com.hmh.service.TaiKhoanService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private LapDsKhamService lapDsKhamService;

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

        if (authentication != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        UserDetails user = taiKhoanService.loadUserByUsername(authentication.getName());
        TaiKhoan bacSi = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);

        PhieuDangKy phieuDangKy = this.khamBenhService.getPDK(id); // Lấy thông tin phiếu đăng ký
        int idBn = phieuDangKy.getIdBn().getIdTk(); // Lấy idBn từ phiếu đăng ký

        model.addAttribute("idpdk", phieuDangKy);
        model.addAttribute("listDv", this.khamBenhService.getDichVu());
        model.addAttribute("dsdv", new DichVu());
        model.addAttribute("lichSuKham", this.khamBenhService.getLichSuKham(params, idBn));

        return "khambenh";
    }

    @GetMapping("/generate-pdf")
    public void generatePDF(HttpServletResponse response,
            @RequestParam("id") int id) throws IOException, DocumentException {

        PhieuDangKy phieuDangKy = this.khamBenhService.getPDK(id); // Lấy thông tin phiếu đăng ký

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=example.pdf");

        OutputStream out = response.getOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("Phieu dang ky " + phieuDangKy.getIdBn().getHoTen() + "\nNgay dang ky: " + phieuDangKy.getChonNgaykham()));
        document.close();

        out.flush();
        out.close();
    }

}
