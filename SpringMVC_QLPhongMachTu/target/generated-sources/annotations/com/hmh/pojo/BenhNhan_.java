package com.hmh.pojo;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-27T16:48:09")
@StaticMetamodel(BenhNhan.class)
public class BenhNhan_ { 

    public static volatile SingularAttribute<BenhNhan, Date> namSinh;
    public static volatile SingularAttribute<BenhNhan, String> diaChi;
    public static volatile SingularAttribute<BenhNhan, TaiKhoan> idTk;
    public static volatile SingularAttribute<BenhNhan, Integer> idBn;
    public static volatile SetAttribute<BenhNhan, PhieuDangKy> phieuDangKySet;
    public static volatile SingularAttribute<BenhNhan, String> hoTen;
    public static volatile SingularAttribute<BenhNhan, Short> gioiTinh;
    public static volatile SingularAttribute<BenhNhan, String> email;
    public static volatile SetAttribute<BenhNhan, PhieuKhamBenh> phieuKhamBenhSet;

}