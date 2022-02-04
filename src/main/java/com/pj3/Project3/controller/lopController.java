package com.pj3.Project3.controller;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.model.khoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.KhoaService;
import com.pj3.Project3.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        List<LopAndKhoa> rs = lopService.displayLop();
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

    @GetMapping("/edit/{id}")
    public ResponseEntity<lop> editLop(@PathVariable("id") Long id){
        lop rs = lopService.findByIdLop(id);
        return new ResponseEntity<lop>(rs,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public String editLop(@PathVariable() Long id,
                                       @RequestParam String name, @RequestParam khoa khoa){
        lop lop = new lop(name, khoa);
        lopService.editLop(id, lop);
        return "redirect:/lop/index";
    }

//    @GetMapping("/view/{id}")
//    public String views(@PathVariable() Long id, Model model){
//        List<giangDayGetAll> rs = lopService.viewsDetail(id);
//        model.addAttribute("rs", rs);
//        return "lopDetail";
//    }

}
