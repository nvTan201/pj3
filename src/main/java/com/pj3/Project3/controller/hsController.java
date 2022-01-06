package com.pj3.Project3.controller;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.HsService;
import com.pj3.Project3.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hoc-sinh")
public class hsController {
    @Autowired
    private HsService hsservice;

    @Autowired
    private LopService lopService;

    @GetMapping("/index")
    public String getAllHs(HttpServletRequest request){
        List<hsLopAndKhoa> rs = hsservice.getAllHs();
        request.setAttribute("rs", rs);
        return "admin/hocSinh";
    }

    @GetMapping("/add")
    public String add(Model model){
        List<LopAndKhoa> lop = lopService.displayLopById();
        model.addAttribute("lop",lop);
        return "admin/addHocSinh";
    }

    @PostMapping("/add")
    public String addProcess(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                             @RequestParam() int gioiTinh,@RequestParam() String sdt,
                             @RequestParam() String email,@RequestParam() lop lop){
        hocSinh hocSinh = new hocSinh(name, date, gioiTinh, email, "1", sdt, 1, lop);
        hsservice.addHs(hocSinh);
        return "redirect:/hoc-sinh/index";
    }

}