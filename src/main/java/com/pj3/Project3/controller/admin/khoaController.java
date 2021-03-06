package com.pj3.Project3.controller.admin;

import com.pj3.Project3.model.khoa;
import com.pj3.Project3.service.admin.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public String add(Model model, @RequestParam() String name, @DateTimeFormat(pattern="yyyy-MM-dd") Date date, @RequestParam int hoc){
        khoa rs = new khoa(name,date,hoc);
        khoaService.addKhoa(rs);
        return "redirect:/khoa/index";
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<khoa> editKhoa(@PathVariable("id") Long id){
        khoa khoa = khoaService.findByIdKhoa(id);
        return new ResponseEntity<khoa>(khoa, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")

    public String editKhoa(@PathVariable() Long id , @RequestParam() String name, @DateTimeFormat(pattern="yyyy-MM-dd") Date date, @RequestParam int hoc){
        khoa khoa = new khoa(name, date, hoc);
        khoaService.editKhoa(id,khoa);
        return "redirect:/khoa/index";
    }
}
