/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.Thuoc;
import com.hmh.repository.CapThuocRepository;
import com.hmh.service.CapThuocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class CapThuocServiceImpl implements CapThuocService {

    @Autowired
    private CapThuocRepository capThuocRepository;

    @Override
    public List<Thuoc> getListThuoc(Map<String, String> params) {
        return this.capThuocRepository.getListThuoc(params);
    }

    @Override
    public List<Thuoc> timKiemThuoc(Map<String, String> params) {
        return this.capThuocRepository.timKiemThuoc(params);
    }

    @Override
    public boolean themPhieuThuoc(ChiTietThuoc ctThuoc) {
        return this.capThuocRepository.themPhieuThuoc(ctThuoc);
    }

}
