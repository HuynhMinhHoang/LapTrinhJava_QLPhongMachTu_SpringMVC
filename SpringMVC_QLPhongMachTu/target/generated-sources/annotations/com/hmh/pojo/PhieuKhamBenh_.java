package com.hmh.pojo;

import com.hmh.pojo.BacSi;
import com.hmh.pojo.BenhNhan;
import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.HoaDon;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-07-28T03:42:36")
@StaticMetamodel(PhieuKhamBenh.class)
public class PhieuKhamBenh_ { 

    public static volatile SetAttribute<PhieuKhamBenh, ChiTietThuoc> chiTietThuocSet;
    public static volatile SingularAttribute<PhieuKhamBenh, BenhNhan> idBn;
    public static volatile SingularAttribute<PhieuKhamBenh, String> trieuChung;
    public static volatile SingularAttribute<PhieuKhamBenh, Integer> idPhieukham;
    public static volatile SingularAttribute<PhieuKhamBenh, String> ketLuan;
    public static volatile SetAttribute<PhieuKhamBenh, HoaDon> hoaDonSet;
    public static volatile SingularAttribute<PhieuKhamBenh, BacSi> idBs;

}