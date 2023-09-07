/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.controllers;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import com.hmh.service.TaiKhoanService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Asus
 */
@Controller
public class DoiMatKhauController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/doimatkhau")
    public String doiMatKhau(Model model, @RequestParam Map<String, String> params, Authentication authen) {

        if (authen != null) {
            UserDetails user = taiKhoanService.loadUserByUsername(authen.getName());
            TaiKhoan u = taiKhoanService.getTaiKhoan(user.getUsername()).get(0);
            model.addAttribute("user", u);
        }

        return "doimatkhau";
    }

    @PostMapping("/doimatkhau")
    public String doiMatKhau(Model model, Authentication authen, @RequestParam Map<String, String> params,
            @RequestParam("matKhauHienTai") String matKhauCu,
            @RequestParam("matKhauMoi") String matKhauMoi,
            @RequestParam("xacNhanMatKhauMoi") String xacNhanMatKhauMoi,
            HttpSession session) {

        Integer id = Integer.parseInt(params.get("idNguoiDung"));
        TaiKhoan tk = this.taiKhoanService.getTaiKhoanById(id);

        if (authen != null) {
            if (!matKhauMoi.equals(xacNhanMatKhauMoi)) {
                session.setAttribute("error", "Mật khẩu mới không khớp!");
                return "redirect:/doimatkhau";
            }
            if (passwordEncoder.matches(matKhauCu, tk.getMatKhau())) {
                String hashedPassword = passwordEncoder.encode(matKhauMoi);
                tk.setMatKhau(hashedPassword);
                boolean capNhatThanhCong = taiKhoanService.doiMatKhau(tk);
                if (capNhatThanhCong) {
                    session.setAttribute("success", "Đổi mật khẩu thành công!");
                    return "redirect:/";
                } else {
                    session.setAttribute("error", "Lỗi khi cập nhật mật khẩu!");
                }
            } else {
                session.setAttribute("error", "Mật khẩu cũ không đúng!");
            }
        }
        return "redirect:/doimatkhau";
    }
}
