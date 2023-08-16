///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.hmh.service.impl;
//
//import com.hmh.pojo.PhieuDangKy;
//import com.hmh.pojo.TaiKhoan;
//import com.hmh.repository.DangKyKhamRepository;
//import com.hmh.service.DangKyKhamService;
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Asus
// */
//@Service
//public class DangKyKhamServiceImpl implements DangKyKhamService {
//
//    @Autowired
//    private DangKyKhamRepository dangKyKhamRepository;
//
//    @Override
//    public void luuPhieuDangKy(PhieuDangKy pdk) {
//        dangKyKhamRepository.luuPhieuDangKy(pdk);
//    }
//
//    @Override
//    public void dangKyKham(TaiKhoan taiKhoan) {
//        PhieuDangKy phieuDangKy = new PhieuDangKy();
//        phieuDangKy.setIdBn(taiKhoan);
//
//        dangKyKhamRepository.luuPhieuDangKy(phieuDangKy);
//    }
//
//}
