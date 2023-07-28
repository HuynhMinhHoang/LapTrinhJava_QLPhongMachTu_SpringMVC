/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.service.impl;

import com.hmh.pojo.TaiKhoan;
import com.hmh.repository.TaiKhoanRepository;
import com.hmh.service.TaiKhoanService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service("userDetailsService")
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addTaiKhoan(TaiKhoan tk) {
        String pass = tk.getMatKhau();
        tk.setMatKhau(this.passwordEncoder.encode(pass));
        tk.setUserRole(TaiKhoan.BENHNHAN);

        return this.taiKhoanRepository.addTaiKhoan(tk);
    }

    @Override
    public List<TaiKhoan> getTaiKhoan(String username) {
        return this.taiKhoanRepository.getTaiKhoan(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TaiKhoan> users = this.getTaiKhoan(username);
        TaiKhoan user = users.get(0);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Tai khoan khong ton tai!");
        }
        
        

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(user.getTaiKhoan(), user.getMatKhau(), authorities);

    }

}
