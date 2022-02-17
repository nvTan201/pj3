package com.pj3.Project3.service.admin;

import com.pj3.Project3.config.customUserDetails;
import com.pj3.Project3.model.giaoVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("configUserDetailsService")
public class configUserDetailsService implements UserDetailsService {

    @Autowired
    GvService gvService;

    @Override
    public UserDetails loadUserByUsername(String username){

        giaoVien giaoVien = gvService.findOne(username);
        if (giaoVien != null){
            return new customUserDetails(giaoVien);
        }else {
            throw new UsernameNotFoundException(username);
        }
    }
}
