package com.pj3.Project3.controller;

import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.service.MhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/mh")
public class mhController {
    @Autowired
    public MhService mhService;

    @GetMapping("/index")
    public String getAll(HttpServletRequest request){
        List<monHoc> rs = mhService.getAll();
        request.setAttribute("rs", rs);
        return "admin/monHoc";
    }
    @PostMapping("/add")
    public String add(Model model, @RequestParam() String name){
        monHoc rs = new monHoc(name);
        mhService.addMh(rs);
//        model.addAttribute("success", "true");
        return "redirect:/mh/index";
    }
    @PutMapping("/edit")
    public String edit(@RequestParam() long id,@RequestParam() String name){

        return null;
    }
}
