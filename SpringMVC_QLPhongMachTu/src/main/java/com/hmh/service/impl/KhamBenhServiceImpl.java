/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.repository.KhamBenhRepository;
import com.hmh.service.KhamBenhService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class KhamBenhServiceImpl implements KhamBenhService{

    @Autowired
    private KhamBenhRepository khamBenhRepository;
    
    @Override
    public PhieuDangKy getPDK(int id) {
        return this.khamBenhRepository.getPDK(id);
    }

    @Override
    public List<DichVu> getDichVu() {
        return this.khamBenhRepository.getDichVu();
    }
    
}