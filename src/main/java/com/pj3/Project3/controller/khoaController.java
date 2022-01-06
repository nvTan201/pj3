package com.pj3.Project3.controller;

import com.pj3.Project3.model.khoa;
import com.pj3.Project3.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("khoa")
public class khoaController {

    @Autowired
    public KhoaService khoaService;

    @GetMapping("/index")
    public String getAll(Model model){
        List<khoa> rs = khoaService.getAllKhoa();
        model.addAttribute("rs",rs);
        return "admin/khoa";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam() String name){
        khoa rs = new khoa(name);
        khoaService.addKhoa(rs);
        return "redirect:/khoa/index";
    }
}
