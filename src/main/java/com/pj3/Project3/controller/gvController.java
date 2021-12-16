package com.pj3.Project3.controller;


import java.util.List;

import com.pj3.Project3.model.giaoVien;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pj3.Project3.service.IGvService;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/giaoVien")
public class gvController {

	@Autowired
	private IGvService igvservice;
	
	@GetMapping("/list")
	public String getAllGv (HttpServletRequest request) {
		List<giaoVien> rs = igvservice.getAllGv();
		request.setAttribute("rs", rs);
		return "home";
	}

}