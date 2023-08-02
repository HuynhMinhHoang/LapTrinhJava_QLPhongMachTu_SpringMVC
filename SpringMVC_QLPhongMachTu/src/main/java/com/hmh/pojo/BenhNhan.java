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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "benh_nhan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BenhNhan.findAll", query = "SELECT b FROM BenhNhan b"),
    @NamedQuery(name = "BenhNhan.findByIdBn", query = "SELECT b FROM BenhNhan b WHERE b.idBn = :idBn"),
    @NamedQuery(name = "BenhNhan.findByHoTen", query = "SELECT b FROM BenhNhan b WHERE b.hoTen = :hoTen"),
    @NamedQuery(name = "BenhNhan.findByNamSinh", query = "SELECT b FROM BenhNhan b WHERE b.namSinh = :namSinh"),
    @NamedQuery(name = "BenhNhan.findByGioiTinh", query = "SELECT b FROM BenhNhan b WHERE b.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "BenhNhan.findByDiaChi", query = "SELECT b FROM BenhNhan b WHERE b.diaChi = :diaChi"),
    @NamedQuery(name = "BenhNhan.findByEmail", query = "SELECT b FROM BenhNhan b WHERE b.email = :email")})
public class BenhNhan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bn")
    private Integer idBn;
    @Size(max = 50)
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "nam_sinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date namSinh;
    @Column(name = "gioi_tinh")
    private Short gioiTinh;
    @Size(max = 50)
    @Column(name = "dia_chi")
    private String diaChi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "id_tk", referencedColumnName = "id_tk")
    @ManyToOne
    private TaiKhoan idTk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBn")
    private Set<PhieuDangKy> phieuDangKySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBn")
    private Set<PhieuKhamBenh> phieuKhamBenhSet;

    public BenhNhan() {
    }

    public BenhNhan(Integer idBn) {
        this.idBn = idBn;
    }

    public Integer getIdBn() {
        return idBn;
    }

    public void setIdBn(Integer idBn) {
        this.idBn = idBn;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public Short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoan getIdTk() {
        return idTk;
    }

    public void setIdTk(TaiKhoan idTk) {
        this.idTk = idTk;
    }

    @XmlTransient
    public Set<PhieuDangKy> getPhieuDangKySet() {
        return phieuDangKySet;
    }

    public void setPhieuDangKySet(Set<PhieuDangKy> phieuDangKySet) {
        this.phieuDangKySet = phieuDangKySet;
    }

    @XmlTransient
    public Set<PhieuKhamBenh> getPhieuKhamBenhSet() {
        return phieuKhamBenhSet;
    }

    public void setPhieuKhamBenhSet(Set<PhieuKhamBenh> phieuKhamBenhSet) {
        this.phieuKhamBenhSet = phieuKhamBenhSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBn != null ? idBn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BenhNhan)) {
            return false;
        }
        BenhNhan other = (BenhNhan) object;
        if ((this.idBn == null && other.idBn != null) || (this.idBn != null && !this.idBn.equals(other.idBn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.BenhNhan[ idBn=" + idBn + " ]";
    }
    
}
