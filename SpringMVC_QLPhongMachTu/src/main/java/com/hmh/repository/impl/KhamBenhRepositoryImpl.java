/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.repository.KhamBenhRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class KhamBenhRepositoryImpl implements KhamBenhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public PhieuDangKy getPDK(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(PhieuDangKy.class, id);
    }

    @Override
    public List<DichVu> getDichVu() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("From DichVu");
        return query.getResultList();
    }

}
