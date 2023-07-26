package com.hmh.pojo;

import com.hmh.pojo.BacSi;
import com.hmh.pojo.BenhNhan;
import com.hmh.pojo.YTa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-26T15:24:27")
@StaticMetamodel(TaiKhoan.class)
public class TaiKhoan_ { 

    public static volatile SingularAttribute<TaiKhoan, String> taiKhoan;
    public static volatile SingularAttribute<TaiKhoan, String> matKhau;
    public static volatile SingularAttribute<TaiKhoan, Integer> idTk;
    public static volatile SetAttribute<TaiKhoan, BacSi> bacSiSet;
    public static volatile SetAttribute<TaiKhoan, YTa> yTaSet;
    public static volatile SingularAttribute<TaiKhoan, String> userRole;
    public static volatile SingularAttribute<TaiKhoan, String> avt;
    public static volatile SetAttribute<TaiKhoan, BenhNhan> benhNhanSet;

}