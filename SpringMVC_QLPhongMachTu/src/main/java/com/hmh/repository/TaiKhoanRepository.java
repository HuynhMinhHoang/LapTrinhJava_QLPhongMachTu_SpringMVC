/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.repository;

import com.hmh.pojo.TaiKhoan;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface TaiKhoanRepository{
    boolean addTaiKhoan(TaiKhoan tk);
    List<TaiKhoan> getTaiKhoan(String username);

}
