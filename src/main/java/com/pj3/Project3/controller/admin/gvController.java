package com.pj3.Project3.controller.admin;


import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.service.admin.GvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/giao-vien")
public class gvController {

	@Autowired
	private GvService gvservice;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/index")
	public String getAllGv (HttpServletRequest request) {
		List<giaoVien> rs = gvservice.getAllGv();
		request.setAttribute("rs", rs);

		return "admin/giaoVien";
	}

	@GetMapping("/add")
	public String addGv(){
		return "admin/addGiaoVien";
	}

	@PostMapping("/add")
	public String addGv(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
						@RequestParam() int gioiTinh,@RequestParam() String sdt,
						@RequestParam() String email,@RequestParam() int quyen){
		String pass = bCryptPasswordEncoder.encode("123");

		giaoVien giaoVien = new giaoVien(name, date, gioiTinh, email, pass, sdt, 1, quyen);
		gvservice.addGv(giaoVien);
		return "redirect:/giao-vien/index";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model){
		giaoVien giaoVien = gvservice.findByIdGv(id);
		model.addAttribute("giaoVien", giaoVien);
		return "admin/editGiaoVien";
	}

	@PutMapping("/edit/{id}")
	public String edit(@RequestParam() String name,
					   @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
					   @RequestParam() int gioiTinh,@RequestParam() String sdt,
					   @RequestParam() String email,@RequestParam() int quyen,
					   @PathVariable("id") Long id){
		giaoVien giaoVien = new giaoVien(name, date, gioiTinh, email, "1", sdt, 1, quyen);
		gvservice.editHs(id,giaoVien);
		return "redirect:/giao-vien/index";
	}

	@DeleteMapping("/destroy/{id}")
	public String destroy(@PathVariable() Long id){
		gvservice.destroy(id);
		return "redirect:/giao-vien/index";
	}

}