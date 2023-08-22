/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.Thuoc;
import com.hmh.repository.QuanLyThuocRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class QuanLyThuocRepositoryImpl implements QuanLyThuocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Thuoc> getThuoc(String name) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Thuoc> query = builder.createQuery(Thuoc.class);
        Root root = query.from(Thuoc.class);
        query = query.select(root);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean themThuoc(Thuoc thuoc) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();

        try {
            if (thuoc.getIdThuoc() == null) {
                session.save(thuoc);
            } else {
                session.update(thuoc);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Thuoc getThuocById(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        return session.get(Thuoc.class, id);
    }

    @Override
    public boolean xoaThuoc(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        Thuoc t = this.getThuocById(id);
        try {
            session.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}