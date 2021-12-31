package com.pj3.Project3.controller;

import com.pj3.Project3.dto.findAllClass;
import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.IHsService;
import com.pj3.Project3.service.ILopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/hoc-sinh")
public class hsController {
    @Autowired
    private IHsService ihsservice;

    @Autowired
    private ILopService iLopService;

    @GetMapping("/get-all")
    public String getAllHs(HttpServletRequest request){
        List<hocSinh> rs = ihsservice.getAllHs();
        request.setAttribute("rs", rs);
        return "hocSinh";
    }

    @GetMapping("/add")
    @ResponseBody
    public List<lop> add(HttpServletRequest request){
        List<lop> rs = iLopService.getAllLop();
        request.setAttribute("rs", rs);
        return rs;
    }

    @PostMapping("/add")
    public String addProcess(){

        return "hocSinh";
    }

}
