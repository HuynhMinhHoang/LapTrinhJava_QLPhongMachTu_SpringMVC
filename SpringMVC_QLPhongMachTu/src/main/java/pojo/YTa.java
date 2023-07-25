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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "y_ta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YTa.findAll", query = "SELECT y FROM YTa y"),
    @NamedQuery(name = "YTa.findByIdYt", query = "SELECT y FROM YTa y WHERE y.idYt = :idYt"),
    @NamedQuery(name = "YTa.findByHoTen", query = "SELECT y FROM YTa y WHERE y.hoTen = :hoTen"),
    @NamedQuery(name = "YTa.findByNamSinh", query = "SELECT y FROM YTa y WHERE y.namSinh = :namSinh"),
    @NamedQuery(name = "YTa.findByGioiTinh", query = "SELECT y FROM YTa y WHERE y.gioiTinh = :gioiTinh")})
public class YTa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_yt")
    private Integer idYt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ho_ten")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_sinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date namSinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioi_tinh")
    private short gioiTinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idYta")
    private Set<PhieuDangKy> phieuDangKySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idYta")
    private Set<HoaDon> hoaDonSet;
    @JoinColumn(name = "id_tk", referencedColumnName = "id_tk")
    @ManyToOne(optional = false)
    private TaiKhoan idTk;

    public YTa() {
    }

    public YTa(Integer idYt) {
        this.idYt = idYt;
    }

    public YTa(Integer idYt, String hoTen, Date namSinh, short gioiTinh) {
        this.idYt = idYt;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    public Integer getIdYt() {
        return idYt;
    }

    public void setIdYt(Integer idYt) {
        this.idYt = idYt;
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

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @XmlTransient
    public Set<PhieuDangKy> getPhieuDangKySet() {
        return phieuDangKySet;
    }

    public void setPhieuDangKySet(Set<PhieuDangKy> phieuDangKySet) {
        this.phieuDangKySet = phieuDangKySet;
    }

    @XmlTransient
    public Set<HoaDon> getHoaDonSet() {
        return hoaDonSet;
    }

    public void setHoaDonSet(Set<HoaDon> hoaDonSet) {
        this.hoaDonSet = hoaDonSet;
    }

    public TaiKhoan getIdTk() {
        return idTk;
    }

    public void setIdTk(TaiKhoan idTk) {
        this.idTk = idTk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idYt != null ? idYt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YTa)) {
            return false;
        }
        YTa other = (YTa) object;
        if ((this.idYt == null && other.idYt != null) || (this.idYt != null && !this.idYt.equals(other.idYt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.YTa[ idYt=" + idYt + " ]";
    }
    
}
