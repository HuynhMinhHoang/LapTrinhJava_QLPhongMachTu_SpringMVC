package com.hmh.pojo;

import com.hmh.pojo.PhieuKhamBenh;
import com.hmh.pojo.TaiKhoan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-08-06T01:56:01")
@StaticMetamodel(BacSi.class)
public class BacSi_ { 

    public static volatile SingularAttribute<BacSi, Date> namSinh;
    public static volatile SingularAttribute<BacSi, TaiKhoan> idTk;
    public static volatile SingularAttribute<BacSi, String> hoTen;
    public static volatile SingularAttribute<BacSi, Short> gioiTinh;
    public static volatile SingularAttribute<BacSi, Integer> idBs;
    public static volatile SetAttribute<BacSi, PhieuKhamBenh> phieuKhamBenhSet;

}