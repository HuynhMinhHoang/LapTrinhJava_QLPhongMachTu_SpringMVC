/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.TaiKhoan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hmh.repository.LapDsKhamRepository;
import com.hmh.service.LapDsKhamService;
import java.util.Map;

/**
 *
 * @author Asus
 */
@Service
public class LapDsKhamServiceImpl implements LapDsKhamService {

    @Autowired
    private LapDsKhamRepository phieuDangKyRepository;

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
        return this.phieuDangKyRepository.trangThai(id,tk);
    }

}
