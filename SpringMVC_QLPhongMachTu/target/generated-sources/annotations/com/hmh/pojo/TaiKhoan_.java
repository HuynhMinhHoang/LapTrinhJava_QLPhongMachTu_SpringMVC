package com.hmh.pojo;

import com.hmh.pojo.ChiTietThoiGianTruc;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.UserRole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T00:55:41")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-03T18:51:26")
>>>>>>> b8b493f4f58144ecd15c58f4fb7909e2befa7a9b
@StaticMetamodel(TaiKhoan.class)
public class TaiKhoan_ { 

    public static volatile SingularAttribute<TaiKhoan, String> taiKhoan;
    public static volatile SingularAttribute<TaiKhoan, String> sdt;
    public static volatile SingularAttribute<TaiKhoan, String> matKhau;
    public static volatile SingularAttribute<TaiKhoan, Integer> idTk;
    public static volatile SetAttribute<TaiKhoan, PhieuDangKy> phieuDangKySet2;
    public static volatile SingularAttribute<TaiKhoan, UserRole> idRole;
    public static volatile SetAttribute<TaiKhoan, PhieuDangKy> phieuDangKySet1;
    public static volatile SetAttribute<TaiKhoan, PhieuDangKy> phieuDangKySet;
    public static volatile SingularAttribute<TaiKhoan, String> gioiTinh;
    public static volatile SingularAttribute<TaiKhoan, String> diaChi;
    public static volatile SingularAttribute<TaiKhoan, Date> ngaySinh;
    public static volatile SetAttribute<TaiKhoan, ChiTietThoiGianTruc> chiTietThoiGianTrucSet;
    public static volatile SingularAttribute<TaiKhoan, String> hoTen;
    public static volatile SingularAttribute<TaiKhoan, String> email;
    public static volatile SingularAttribute<TaiKhoan, String> avt;

}