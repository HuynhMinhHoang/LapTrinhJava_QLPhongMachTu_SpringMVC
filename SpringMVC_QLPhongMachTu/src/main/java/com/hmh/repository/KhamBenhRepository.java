/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository;

import com.hmh.pojo.DichVu;
import com.hmh.pojo.PhieuDangKy;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public interface KhamBenhRepository {
    PhieuDangKy getPDK(int id);
    
    List<DichVu> getDichVu();
    
    List<PhieuDangKy> getLichSuKham(Map<String, String> params, int idBn);
}
