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
@Table(name = "bac_si")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BacSi.findAll", query = "SELECT b FROM BacSi b"),
    @NamedQuery(name = "BacSi.findByIdBs", query = "SELECT b FROM BacSi b WHERE b.idBs = :idBs"),
    @NamedQuery(name = "BacSi.findByHoTen", query = "SELECT b FROM BacSi b WHERE b.hoTen = :hoTen"),
    @NamedQuery(name = "BacSi.findByGioiTinh", query = "SELECT b FROM BacSi b WHERE b.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "BacSi.findByNamSinh", query = "SELECT b FROM BacSi b WHERE b.namSinh = :namSinh")})
public class BacSi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bs")
    private Integer idBs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ho_ten")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioi_tinh")
    private short gioiTinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_sinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date namSinh;
    @JoinColumn(name = "id_tk", referencedColumnName = "id_tk")
    @ManyToOne(optional = false)
    private TaiKhoan idTk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBs")
    private Set<PhieuKhamBenh> phieuKhamBenhSet;

    public BacSi() {
    }

    public BacSi(Integer idBs) {
        this.idBs = idBs;
    }

    public BacSi(Integer idBs, String hoTen, short gioiTinh, Date namSinh) {
        this.idBs = idBs;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public Integer getIdBs() {
        return idBs;
    }

    public void setIdBs(Integer idBs) {
        this.idBs = idBs;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public TaiKhoan getIdTk() {
        return idTk;
    }

    public void setIdTk(TaiKhoan idTk) {
        this.idTk = idTk;
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
        hash += (idBs != null ? idBs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BacSi)) {
            return false;
        }
        BacSi other = (BacSi) object;
        if ((this.idBs == null && other.idBs != null) || (this.idBs != null && !this.idBs.equals(other.idBs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.BacSi[ idBs=" + idBs + " ]";
    }
    
}
