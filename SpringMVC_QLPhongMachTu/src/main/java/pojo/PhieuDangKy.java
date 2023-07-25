/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "phieu_dang_ky")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuDangKy.findAll", query = "SELECT p FROM PhieuDangKy p"),
    @NamedQuery(name = "PhieuDangKy.findByIdPhieudk", query = "SELECT p FROM PhieuDangKy p WHERE p.idPhieudk = :idPhieudk"),
    @NamedQuery(name = "PhieuDangKy.findByNgayDky", query = "SELECT p FROM PhieuDangKy p WHERE p.ngayDky = :ngayDky"),
    @NamedQuery(name = "PhieuDangKy.findByNgayHkham", query = "SELECT p FROM PhieuDangKy p WHERE p.ngayHkham = :ngayHkham")})
public class PhieuDangKy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_phieudk")
    private Integer idPhieudk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_dky")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_hkham")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayHkham;
    @JoinColumn(name = "id_bn", referencedColumnName = "id_bn")
    @ManyToOne(optional = false)
    private BenhNhan idBn;
    @JoinColumn(name = "id_yta", referencedColumnName = "id_yt")
    @ManyToOne(optional = false)
    private YTa idYta;

    public PhieuDangKy() {
    }

    public PhieuDangKy(Integer idPhieudk) {
        this.idPhieudk = idPhieudk;
    }

    public PhieuDangKy(Integer idPhieudk, Date ngayDky, Date ngayHkham) {
        this.idPhieudk = idPhieudk;
        this.ngayDky = ngayDky;
        this.ngayHkham = ngayHkham;
    }

    public Integer getIdPhieudk() {
        return idPhieudk;
    }

    public void setIdPhieudk(Integer idPhieudk) {
        this.idPhieudk = idPhieudk;
    }

    public Date getNgayDky() {
        return ngayDky;
    }

    public void setNgayDky(Date ngayDky) {
        this.ngayDky = ngayDky;
    }

    public Date getNgayHkham() {
        return ngayHkham;
    }

    public void setNgayHkham(Date ngayHkham) {
        this.ngayHkham = ngayHkham;
    }

    public BenhNhan getIdBn() {
        return idBn;
    }

    public void setIdBn(BenhNhan idBn) {
        this.idBn = idBn;
    }

    public YTa getIdYta() {
        return idYta;
    }

    public void setIdYta(YTa idYta) {
        this.idYta = idYta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhieudk != null ? idPhieudk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhieuDangKy)) {
            return false;
        }
        PhieuDangKy other = (PhieuDangKy) object;
        if ((this.idPhieudk == null && other.idPhieudk != null) || (this.idPhieudk != null && !this.idPhieudk.equals(other.idPhieudk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.PhieuDangKy[ idPhieudk=" + idPhieudk + " ]";
    }
    
}
