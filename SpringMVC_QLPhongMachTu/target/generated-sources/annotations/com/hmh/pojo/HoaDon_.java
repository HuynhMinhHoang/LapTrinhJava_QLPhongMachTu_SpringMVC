package com.hmh.pojo;

import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.YTa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-06T01:56:01")
@StaticMetamodel(HoaDon.class)
public class HoaDon_ { 

    public static volatile SingularAttribute<HoaDon, Integer> idHoadon;
    public static volatile SingularAttribute<HoaDon, Long> tienKham;
    public static volatile SingularAttribute<HoaDon, Date> ngayThanhToan;
    public static volatile SingularAttribute<HoaDon, PhieuKhamBenh> idPhieukham;
    public static volatile SingularAttribute<HoaDon, YTa> idYta;
    public static volatile SingularAttribute<HoaDon, Long> tienThuoc;

}