/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.pojo;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "tai_khoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByIdTk", query = "SELECT t FROM TaiKhoan t WHERE t.idTk = :idTk"),
    @NamedQuery(name = "TaiKhoan.findByUserRole", query = "SELECT t FROM TaiKhoan t WHERE t.userRole = :userRole"),
    @NamedQuery(name = "TaiKhoan.findByTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByAvt", query = "SELECT t FROM TaiKhoan t WHERE t.avt = :avt")})
public class TaiKhoan implements Serializable {

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String BACSI = "ROLE_BACSI";
    public static final String YTA = "ROLE_YTA";
    public static final String BENHNHAN = "ROLE_BENHNHAN";

    @Transient
    private String confirmmatKhau;
    @Transient 
    private MultipartFile file;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tk")
    private Integer idTk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_role")
    private String userRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tai_khoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "mat_khau")
    private String matKhau;
    @Size(max = 1000)
    @Column(name = "avt")
    private String avt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTk")
    private Set<BacSi> bacSiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTk")
    private Set<BenhNhan> benhNhanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTk")
    private Set<YTa> yTaSet;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer idTk) {
        this.idTk = idTk;
    }

    public TaiKhoan(Integer idTk, String userRole, String taiKhoan, String matKhau) {
        this.idTk = idTk;
        this.userRole = userRole;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getIdTk() {
        return idTk;
    }

    public void setIdTk(Integer idTk) {
        this.idTk = idTk;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    @XmlTransient
    public Set<BacSi> getBacSiSet() {
        return bacSiSet;
    }

    public void setBacSiSet(Set<BacSi> bacSiSet) {
        this.bacSiSet = bacSiSet;
    }

    @XmlTransient
    public Set<BenhNhan> getBenhNhanSet() {
        return benhNhanSet;
    }

    public void setBenhNhanSet(Set<BenhNhan> benhNhanSet) {
        this.benhNhanSet = benhNhanSet;
    }

    @XmlTransient
    public Set<YTa> getYTaSet() {
        return yTaSet;
    }

    public void setYTaSet(Set<YTa> yTaSet) {
        this.yTaSet = yTaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTk != null ? idTk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.idTk == null && other.idTk != null) || (this.idTk != null && !this.idTk.equals(other.idTk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hmh.pojo.TaiKhoan[ idTk=" + idTk + " ]";
    }

    /**
     * @return the confirmmatKhau
     */
    public String getConfirmmatKhau() {
        return confirmmatKhau;
    }

    /**
     * @param confirmmatKhau the confirmmatKhau to set
     */
    public void setConfirmmatKhau(String confirmmatKhau) {
        this.confirmmatKhau = confirmmatKhau;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
