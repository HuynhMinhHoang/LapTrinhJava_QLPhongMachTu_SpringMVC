/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.TaiKhoan;
import com.hmh.pojo.Thuoc;
import com.hmh.repository.CapThuocRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class CapThuocRepositoryImpl implements CapThuocRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Thuoc> getListThuoc(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("From Thuoc");

        return query.getResultList();
    }

    @Override
    public List<Thuoc> timKiemThuoc(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Thuoc> query = builder.createQuery(Thuoc.class);
        Root root = query.from(Thuoc.class);
        query = query.select(root);

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = builder.like(root.get("tenThuoc"), String.format("%%%s%%", kw));
                query.where(p1);
            }
        }
        javax.persistence.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean themPhieuThuoc(ChiTietThuoc ctThuoc, int idPhieuKham) {
        Session session = this.factory.getObject().getCurrentSession();
        ChiTietThuoc ctt = session.get(ChiTietThuoc.class, idPhieuKham);

        try {
            if (ctThuoc.getIdChitietThuoc() == null) {
                session.save(ctThuoc);
//                ctt.setIdPhieukham(idPhieuKham);
            } else {
                session.update(ctThuoc);
            }

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

}
