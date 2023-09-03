package com.hmh.pojo;

import com.hmh.pojo.ChiTietThuoc;
import com.hmh.pojo.DonviThuoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T00:55:41")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-03T18:51:26")
>>>>>>> b8b493f4f58144ecd15c58f4fb7909e2befa7a9b
@StaticMetamodel(Thuoc.class)
public class Thuoc_ { 

    public static volatile SingularAttribute<Thuoc, DonviThuoc> donVi;
    public static volatile SetAttribute<Thuoc, ChiTietThuoc> chiTietThuocSet;
    public static volatile SingularAttribute<Thuoc, Long> giaThuoc;
    public static volatile SingularAttribute<Thuoc, Integer> idThuoc;
    public static volatile SingularAttribute<Thuoc, String> xuatXu;
    public static volatile SingularAttribute<Thuoc, String> tenThuoc;
    public static volatile SingularAttribute<Thuoc, Integer> soLuong;

}