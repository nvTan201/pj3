package com.pj3.Project3.config;

import com.pj3.Project3.model.giaoVien;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class customUserDetails implements UserDetails {

    giaoVien giaoVien;

    public customUserDetails(giaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String role = "";
        if (giaoVien.getQuyen() == 1){
            role = "ROLE_ADMIN";
        }else {
            role = "ROLE_USER";
        }
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return giaoVien.getMatKhauGv();
    }

    @Override
    public String getUsername() {
        return giaoVien.getEmailGv();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
