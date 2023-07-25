package com.hmh.pojo;

import com.hmh.pojo.ChiTietThuoc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-07-25T17:14:21")
@StaticMetamodel(Thuoc.class)
public class Thuoc_ { 

    public static volatile SingularAttribute<Thuoc, Date> hanSd;
    public static volatile SingularAttribute<Thuoc, String> donVi;
    public static volatile SetAttribute<Thuoc, ChiTietThuoc> chiTietThuocSet;
    public static volatile SingularAttribute<Thuoc, Long> giaThuoc;
    public static volatile SingularAttribute<Thuoc, Integer> idThuoc;
    public static volatile SingularAttribute<Thuoc, String> xuatXu;
    public static volatile SingularAttribute<Thuoc, String> tenThuoc;
    public static volatile SingularAttribute<Thuoc, Date> ngayNhap;

}