/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public interface LapDsKhamService {

    List<PhieuDangKy> getPhieuDangKy(Map<String, String> params);

    PhieuDangKy getPhieuDangKyById(int id);

    public List<TaiKhoan> getBacSi();

    Boolean trangThai(int id, TaiKhoan tk);

    boolean themPhieuDangKy(PhieuDangKy pdk);

    List<PhieuDangKy> timKiemPDK(Map<String, String> params);

    boolean chonBacSiChoPhieuDangKy(int idPhieuDangKy, int idBacSi);

}
