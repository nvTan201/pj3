package com.pj3.Project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginGiaoVien {

    @RequestMapping("/login")
    public String viewLogin(){
        return "login";
    }
}
