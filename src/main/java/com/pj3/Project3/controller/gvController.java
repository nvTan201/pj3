package com.pj3.Project3.controller;


import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.service.IGvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/giao-vien")
public class gvController {

	@Autowired
	private IGvService igvservice;
	
	@GetMapping("/get-all")
	public String getAllGv (HttpServletRequest request) {
		List<giaoVien> rs = igvservice.getAllGv();
		request.setAttribute("rs", rs);
		return "home";
	}

}