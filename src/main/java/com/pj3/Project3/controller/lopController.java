package com.pj3.Project3.controller;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.khoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.KhoaService;
import com.pj3.Project3.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class lopController {

    @Autowired
    public KhoaService khoaService;

    @Autowired
    private LopService lopService;

    @GetMapping("/index")
    public String getAllLop(Model model){
        List<LopAndKhoa> rs = lopService.displayLopById();
        List<khoa> k = khoaService.getAllKhoa();
        model.addAttribute("rs",rs);
        model.addAttribute("k",k);
        return "admin/lop";

    }

    @PostMapping("/add")
    public String addLop(@RequestParam() String tenlop, @RequestParam() khoa khoa){
        lop rs = new lop(tenlop, khoa);
        lopService.addLop(rs);
        return "redirect:/lop/index";
    }

}
