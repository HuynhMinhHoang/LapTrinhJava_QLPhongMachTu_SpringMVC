package com.hmh.pojo;

import com.hmh.pojo.HoaDon;
import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-25T17:14:21")
@StaticMetamodel(YTa.class)
public class YTa_ { 

    public static volatile SingularAttribute<YTa, Date> namSinh;
    public static volatile SingularAttribute<YTa, TaiKhoan> idTk;
    public static volatile SingularAttribute<YTa, Integer> idYt;
    public static volatile SetAttribute<YTa, PhieuDangKy> phieuDangKySet;
    public static volatile SingularAttribute<YTa, String> hoTen;
    public static volatile SingularAttribute<YTa, Short> gioiTinh;
    public static volatile SetAttribute<YTa, HoaDon> hoaDonSet;

}