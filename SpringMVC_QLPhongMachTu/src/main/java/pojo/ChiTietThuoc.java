/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "chi_tiet_thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietThuoc.findAll", query = "SELECT c FROM ChiTietThuoc c"),
    @NamedQuery(name = "ChiTietThuoc.findByIdChitietThuoc", query = "SELECT c FROM ChiTietThuoc c WHERE c.idChitietThuoc = :idChitietThuoc"),
    @NamedQuery(name = "ChiTietThuoc.findBySoLuong", query = "SELECT c FROM ChiTietThuoc c WHERE c.soLuong = :soLuong")})
public class ChiTietThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chitiet_thuoc")
    private Integer idChitietThuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_luong")
    private long soLuong;
    @JoinColumn(name = "id_phieukham", referencedColumnName = "id_phieukham")
    @ManyToOne(optional = false)
    private PhieuKhamBenh idPhieukham;
    @JoinColumn(name = "id_thuoc", referencedColumnName = "id_thuoc")
    @ManyToOne(optional = false)
    private Thuoc idThuoc;

    public ChiTietThuoc() {
    }

    public ChiTietThuoc(Integer idChitietThuoc) {
        this.idChitietThuoc = idChitietThuoc;
    }

    public ChiTietThuoc(Integer idChitietThuoc, long soLuong) {
        this.idChitietThuoc = idChitietThuoc;
        this.soLuong = soLuong;
    }

    public Integer getIdChitietThuoc() {
        return idChitietThuoc;
    }

    public void setIdChitietThuoc(Integer idChitietThuoc) {
        this.idChitietThuoc = idChitietThuoc;
    }

    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }

    public PhieuKhamBenh getIdPhieukham() {
        return idPhieukham;
    }

    public void setIdPhieukham(PhieuKhamBenh idPhieukham) {
        this.idPhieukham = idPhieukham;
    }

    public Thuoc getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Thuoc idThuoc) {
        this.idThuoc = idThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChitietThuoc != null ? idChitietThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietThuoc)) {
            return false;
        }
        ChiTietThuoc other = (ChiTietThuoc) object;
        if ((this.idChitietThuoc == null && other.idChitietThuoc != null) || (this.idChitietThuoc != null && !this.idChitietThuoc.equals(other.idChitietThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.ChiTietThuoc[ idChitietThuoc=" + idChitietThuoc + " ]";
    }
    
}
