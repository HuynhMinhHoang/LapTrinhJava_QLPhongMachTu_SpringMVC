/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hmh.repository.LapDsKhamRepository;
import com.hmh.repository.TaiKhoanRepository;
import com.hmh.service.LapDsKhamService;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Asus
 */
@Service
public class LapDsKhamServiceImpl implements LapDsKhamService {
    
    @Autowired
    private LapDsKhamRepository phieuDangKyRepository;
    
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    
    @Override
    public List<PhieuDangKy> getPhieuDangKy(Map<String, String> params) {
        return this.phieuDangKyRepository.getPhieuDangKy(params);
    }
    
    @Override
    public List<TaiKhoan> getBacSi() {
        return this.phieuDangKyRepository.getBacSi();
    }
    
    @Override
    public Boolean trangThai(int id, TaiKhoan tk) {
        return this.phieuDangKyRepository.trangThai(id, tk);
    }
    
    @Override
    public boolean themPhieuDangKy(PhieuDangKy pdk) {
        TaiKhoan tk = taiKhoanRepository.getTaiKhoan(pdk.getTenBenhNhanDky()).get(0);
        
        java.util.Date currentDate = new java.util.Date();
        
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        
        pdk.setIdBn(tk);
        
        pdk.setNgayDky(sqlDate);
        
        pdk.setTrangThaidky((short) 0);
        
        return this.phieuDangKyRepository.themPhieuDangKy(pdk);
    }
    
}
