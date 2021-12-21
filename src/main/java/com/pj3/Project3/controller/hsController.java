package com.pj3.Project3.controller;

import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.service.IHsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/hoc-sinh")
public class hsController {
    @Autowired
    private IHsService ihsservice;

    @GetMapping("/get-all")
    public String getAllHs(HttpServletRequest request){
        List<hocSinh> rs = ihsservice.getAllHs();
        request.setAttribute("rs", rs);
        return "hocSinh";
    }

    @GetMapping("/add")
    public String add(){
        return "addHocSinh";
    }


}
