package com.hmh.pojo;

import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.PhieuDangKy;
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
@StaticMetamodel(PhieuKhamBenh.class)
public class PhieuKhamBenh_ { 

    public static volatile SetAttribute<PhieuKhamBenh, ChiTietThuoc> chiTietThuocSet;
    public static volatile SingularAttribute<PhieuKhamBenh, String> trieuChung;
    public static volatile SetAttribute<PhieuKhamBenh, PhieuDangKy> phieuDangKySet;
    public static volatile SingularAttribute<PhieuKhamBenh, Integer> idPhieukham;
    public static volatile SingularAttribute<PhieuKhamBenh, String> ketLuan;
    public static volatile SingularAttribute<PhieuKhamBenh, Date> ngayKhamBenh;

}