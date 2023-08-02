/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.formatter;

import com.hmh.pojo.PhieuDangKy;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Asus
 */
public class PhieuDangKyFormatter implements Formatter<PhieuDangKy>{

    @Override
    public String print(PhieuDangKy phieuDangKy, Locale locale) {
        return String.valueOf(phieuDangKy.getIdBn());
    }

    @Override
    public PhieuDangKy parse(String idPhieudk, Locale locale) throws ParseException {
        return new PhieuDangKy(Integer.parseInt(idPhieudk));
    }
    
}
