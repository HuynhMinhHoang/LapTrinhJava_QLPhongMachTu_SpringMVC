/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository.impl;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hmh.repository.LapDsKhamRepository;
import com.hmh.repository.UserRoleRepository;
import java.util.Map;
import org.hibernate.HibernateException;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class LapDsKhamRepositoryImpl implements LapDsKhamRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<PhieuDangKy> getPhieuDangKy(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From PhieuDangKy");
        
        return q.getResultList();
    }
    
    @Override
    public List<TaiKhoan> getBacSi() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From TaiKhoan Where idRole=2");
        
        return q.getResultList();
    }
    
    @Override
    public Boolean trangThai(int id, TaiKhoan tk) {
        Session session = this.factory.getObject().getCurrentSession();
        PhieuDangKy pdk = session.get(PhieuDangKy.class, id);
        
        try {
            if (pdk.getTrangThaidky() == 1) {
                pdk.setTrangThaidky((short) 0);
                pdk.setIdYt(null);
                pdk.setIdBs(null);
            } else {
                pdk.setTrangThaidky((short) 1);
                pdk.setIdYt(tk);
                pdk.setIdBs(getBacSi().get(0));
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean themPhieuDangKy(PhieuDangKy pdk) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(pdk);
            return true;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
//
//    @Override
//    public TaiKhoan getBacSiByID() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
