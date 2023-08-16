///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.hmh.repository.impl;
//
//import com.hmh.pojo.PhieuDangKy;
//import com.hmh.pojo.TaiKhoan;
//import com.hmh.repository.DangKyKhamRepository;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Asus
// */
//@Repository
//@Transactional
//public class DangKyKhamRepositoryImpl implements DangKyKhamRepository {
//
//    @Autowired
//    private LocalSessionFactoryBean sessionFactoryBean;
//
//    @Override
//    public void luuPhieuDangKy(PhieuDangKy pdk) {
//        Session session = sessionFactoryBean.getObject().getCurrentSession();
//        try {
//            session.beginTransaction();
//            session.save(pdk);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//}
