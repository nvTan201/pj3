package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.khoa;
import com.pj3.Project3.repository.admin.IKhoaRepository;
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
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/khoa")
public class khoaController {

    @Autowired
    public KhoaService khoaService;

    @Autowired
    IKhoaRepository iKhoaRepository;

    @GetMapping("/index")
    public String getAll(Model model){
        List<khoa> rs = khoaService.getAllKhoa();
        model.addAttribute("rs",rs);
        return "admin/khoa";
    }
    public boolean checkKhoa(String tenKhoa) {
        List<khoa> rs = khoaService.getAllKhoa();
        AtomicBoolean check= new AtomicBoolean(true);
        rs.forEach((element)->{
            if (element.getTenKhoa().equals(tenKhoa)){
                check.set(false);
            }
        });
        return check.get();
    }
    @PostMapping("/add")
    public String add(Model model, @RequestParam() String name, @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
       boolean check = this.checkKhoa(name);
       if (check){
           khoa rs = new khoa(name,date,1);
           khoaService.addKhoa(rs);
       }
        return "redirect:/khoa/index";
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<khoa> editKhoa(@PathVariable("id") Long id){
        khoa khoa = khoaService.findByIdKhoa(id);
        return new ResponseEntity<khoa>(khoa, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public String editKhoa(@PathVariable() Long id , @RequestParam() String name, @DateTimeFormat(pattern="yyyy-MM-dd") Date date){

//        khoa khoa1 = iKhoaRepository.getById(id);
        boolean check = this.checkKhoa(name);
        if (check){
            khoa khoa = new khoa(name, date, 1);
            khoaService.editKhoa(id,khoa);
        }
        return "redirect:/khoa/index";
    }
}
