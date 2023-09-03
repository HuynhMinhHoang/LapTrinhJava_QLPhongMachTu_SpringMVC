package com.hmh.pojo;

import com.hmh.pojo.PhieuDangKy;
import com.hmh.pojo.TienKham;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T00:55:41")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-03T18:51:26")
>>>>>>> b8b493f4f58144ecd15c58f4fb7909e2befa7a9b
@StaticMetamodel(HoaDon.class)
public class HoaDon_ { 

    public static volatile SingularAttribute<HoaDon, Integer> idHoadon;
    public static volatile SingularAttribute<HoaDon, TienKham> tienKham;
    public static volatile SingularAttribute<HoaDon, Date> ngayThanhToan;
    public static volatile SingularAttribute<HoaDon, Long> tienDv;
    public static volatile SingularAttribute<HoaDon, Long> tienThuoc;
    public static volatile SingularAttribute<HoaDon, PhieuDangKy> idPhieudky;

}