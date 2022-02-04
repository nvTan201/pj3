package com.pj3.Project3.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @RequestMapping(value = {"/","home",""})
    public String home(){
        return "redirect:/giang-day/index";
    }
}
