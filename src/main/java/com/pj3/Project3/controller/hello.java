package com.pj3.Project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hello {
    @Autowired

    @GetMapping("/test")
    public String hello(){
        return "test";
    }
}
