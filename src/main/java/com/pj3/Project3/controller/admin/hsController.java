package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.service.admin.HsService;
import com.pj3.Project3.service.admin.LopService;
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
@RequestMapping("/hoc-sinh")
public class hsController {
    @Autowired
    private HsService hsservice;

    @Autowired
    private LopService lopService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/index")
    public String getAllHs(HttpServletRequest request){
        List<hsLopAndKhoa> rs = hsservice.getAllHs();
        request.setAttribute("rs", rs);
        return "admin/hocSinh";
    }

    @GetMapping("/add")
    public String addHs(Model model){
        List<LopAndKhoa> lop = lopService.displayLop();
        model.addAttribute("lop",lop);
        return "admin/addHocSinh";
    }

    @PostMapping("/add")
    public String addProcess(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                             @RequestParam() int gioiTinh,@RequestParam() String sdt,
                             @RequestParam() String email,@RequestParam() lop lop){
        String pass = bCryptPasswordEncoder.encode("123");
        hocSinh hocSinh = new hocSinh(name, date, gioiTinh, email, pass, sdt, 1, lop);
        hsservice.addHs(hocSinh);
        return "redirect:/hoc-sinh/index";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model){
        hocSinh hs = hsservice.findByIdHs(id);
        List<LopAndKhoa> lop = lopService.displayLop();
        model.addAttribute("hs",hs);
        model.addAttribute("lop",lop);
        return "admin/editHocSinh";
    }

    @PutMapping("/edit/{id}")
    public String edit(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                       @RequestParam() int gioiTinh,@RequestParam() String sdt,
                       @RequestParam() String email,@RequestParam() lop lop,
                       @PathVariable("id") Long id){
        hocSinh hocSinh = new hocSinh(name,date,gioiTinh,email,"1",sdt,1,lop);
        hsservice.editHs(id,hocSinh);
        return "redirect:/hoc-sinh/index";
    }

    @DeleteMapping("/destroy/{id}")
    public String destroyHs(@PathVariable("id") Long id){
        hsservice.destroy(id);
        return "redirect:/hoc-sinh/index";
    }
}
