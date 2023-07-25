/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t"),
    @NamedQuery(name = "Thuoc.findByIdThuoc", query = "SELECT t FROM Thuoc t WHERE t.idThuoc = :idThuoc"),
    @NamedQuery(name = "Thuoc.findByTenThuoc", query = "SELECT t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc"),
    @NamedQuery(name = "Thuoc.findByXuatXu", query = "SELECT t FROM Thuoc t WHERE t.xuatXu = :xuatXu"),
    @NamedQuery(name = "Thuoc.findByNgayNhap", query = "SELECT t FROM Thuoc t WHERE t.ngayNhap = :ngayNhap"),
    @NamedQuery(name = "Thuoc.findByHanSd", query = "SELECT t FROM Thuoc t WHERE t.hanSd = :hanSd"),
    @NamedQuery(name = "Thuoc.findByGiaThuoc", query = "SELECT t FROM Thuoc t WHERE t.giaThuoc = :giaThuoc"),
    @NamedQuery(name = "Thuoc.findByDonVi", query = "SELECT t FROM Thuoc t WHERE t.donVi = :donVi")})
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_thuoc")
    private Integer idThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten_thuoc")
    private String tenThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "xuat_xu")
    private String xuatXu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_nhap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNhap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "han_sd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hanSd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_thuoc")
    private long giaThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "don_vi")
    private String donVi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThuoc")
    private Set<ChiTietThuoc> chiTietThuocSet;

    public Thuoc() {
    }

    public Thuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public Thuoc(Integer idThuoc, String tenThuoc, String xuatXu, Date ngayNhap, Date hanSd, long giaThuoc, String donVi) {
        this.idThuoc = idThuoc;
        this.tenThuoc = tenThuoc;
        this.xuatXu = xuatXu;
        this.ngayNhap = ngayNhap;
        this.hanSd = hanSd;
        this.giaThuoc = giaThuoc;
        this.donVi = donVi;
    }

    public Integer getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getHanSd() {
        return hanSd;
    }

    public void setHanSd(Date hanSd) {
        this.hanSd = hanSd;
    }

    public long getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(long giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    @XmlTransient
    public Set<ChiTietThuoc> getChiTietThuocSet() {
        return chiTietThuocSet;
    }

    public void setChiTietThuocSet(Set<ChiTietThuoc> chiTietThuocSet) {
        this.chiTietThuocSet = chiTietThuocSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThuoc != null ? idThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thuoc)) {
            return false;
        }
        Thuoc other = (Thuoc) object;
        if ((this.idThuoc == null && other.idThuoc != null) || (this.idThuoc != null && !this.idThuoc.equals(other.idThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.Thuoc[ idThuoc=" + idThuoc + " ]";
    }
    
}
