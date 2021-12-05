package com.pj3.Project3.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pj3.Project3.model.Gv;
import com.pj3.Project3.service.IGvService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gv")
public class gvController {

	@Autowired
	private IGvService igvservice;
	
	@GetMapping("/list")
	public String getAllGv (HttpServletRequest request) {
		List<Gv> rs = new ArrayList<>();
		rs = igvservice.getAllGv();
		for (Gv value : rs){
			System.out.println(value.getHoTenGv());
		}
		request.setAttribute("rs", rs);
		return "home";
	}
}
