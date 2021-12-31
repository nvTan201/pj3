package com.pj3.Project3.controller;

import com.pj3.Project3.dto.findAllClass;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.ILopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class lopController {

    @Autowired
    public ILopService iLopService;

//    @RequestMapping("/list")
//    public List<findAllClass> getAllLop(){
//
//        return iLopService.getAllLop();
//    }
}
