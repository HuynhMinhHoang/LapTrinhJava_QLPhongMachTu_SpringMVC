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
@Table(name = "hoa_don")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findByIdHoadon", query = "SELECT h FROM HoaDon h WHERE h.idHoadon = :idHoadon"),
    @NamedQuery(name = "HoaDon.findByNgayThanhToan", query = "SELECT h FROM HoaDon h WHERE h.ngayThanhToan = :ngayThanhToan"),
    @NamedQuery(name = "HoaDon.findByTienKham", query = "SELECT h FROM HoaDon h WHERE h.tienKham = :tienKham"),
    @NamedQuery(name = "HoaDon.findByTienThuoc", query = "SELECT h FROM HoaDon h WHERE h.tienThuoc = :tienThuoc")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hoadon")
    private Integer idHoadon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_thanh_toan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayThanhToan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tien_kham")
    private long tienKham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tien_thuoc")
    private long tienThuoc;
    @JoinColumn(name = "id_phieukham", referencedColumnName = "id_phieukham")
    @ManyToOne(optional = false)
    private PhieuKhamBenh idPhieukham;
    @JoinColumn(name = "id_yta", referencedColumnName = "id_yt")
    @ManyToOne(optional = false)
    private YTa idYta;

    public HoaDon() {
    }

    public HoaDon(Integer idHoadon) {
        this.idHoadon = idHoadon;
    }

    public HoaDon(Integer idHoadon, Date ngayThanhToan, long tienKham, long tienThuoc) {
        this.idHoadon = idHoadon;
        this.ngayThanhToan = ngayThanhToan;
        this.tienKham = tienKham;
        this.tienThuoc = tienThuoc;
    }

    public Integer getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(Integer idHoadon) {
        this.idHoadon = idHoadon;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public long getTienKham() {
        return tienKham;
    }

    public void setTienKham(long tienKham) {
        this.tienKham = tienKham;
    }

    public long getTienThuoc() {
        return tienThuoc;
    }

    public void setTienThuoc(long tienThuoc) {
        this.tienThuoc = tienThuoc;
    }

    public PhieuKhamBenh getIdPhieukham() {
        return idPhieukham;
    }

    public void setIdPhieukham(PhieuKhamBenh idPhieukham) {
        this.idPhieukham = idPhieukham;
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
        hash += (idHoadon != null ? idHoadon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.idHoadon == null && other.idHoadon != null) || (this.idHoadon != null && !this.idHoadon.equals(other.idHoadon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.HoaDon[ idHoadon=" + idHoadon + " ]";
    }
    
}
