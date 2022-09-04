package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.dto.giangDayGetAll;
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
import org.springframework.web.servlet.view.RedirectView;
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
    private HsService hsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

//    @GetMapping("/index")
//    public String getAllHs(HttpServletRequest request){
//        List<hsLopAndKhoa> rs = hsservice.getAllHs();
//        request.setAttribute("rs", rs);
//        return "admin/hocSinh";
//    }
    @GetMapping("/index")
    public String index(Model model){
        List<lop> lops = lopService.getAllLop();
        model.addAttribute("lops",lops);
        return "admin/hocSinh";
    }
    @GetMapping("detail/{id}")
    public String detailHs(@PathVariable("id") Long id, Model model){
        lop lop = lopService.findByIdLop(id);
//        hocSinh rs =hsService.getHsByIdLop(id);
        List<hsLopAndKhoa> rs = hsService.getHsByIdLop(id);
        model.addAttribute("lop", lop);
        model.addAttribute("rs", rs);
        return "admin/hsDetail";
    }
    @GetMapping("/add")
    public String addHs(Model model){
        List<LopAndKhoa> lop = lopService.displayLop();
        model.addAttribute("lop",lop);
        return "admin/addHocSinh";
    }


    @PostMapping("/add")
    public RedirectView addProcess(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                             @RequestParam() int gioiTinh,@RequestParam() String sdt,
                             @RequestParam() String email,@RequestParam() lop lop){
        String pass = bCryptPasswordEncoder.encode("123");
        hocSinh hocSinh = new hocSinh(name, date, gioiTinh, email, pass, sdt, 1, lop);
        hsservice.addHs(hocSinh);
        String url = "/hoc-sinh/detail/" + lop.getMaLop();
//        return "redirect:/hoc-sinh/detail" + lop.getTenLop();
        return new RedirectView(url);
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
    public RedirectView edit(@RequestParam() String name, @RequestParam() @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                       @RequestParam() int gioiTinh,@RequestParam() String sdt,
                       @RequestParam() String email,@RequestParam() lop lop,
                       @PathVariable("id") Long id){

        hocSinh hocSinh = new hocSinh(name,date,gioiTinh,email,"1",sdt,1,lop);
        hsservice.editHs(id,hocSinh);
        String url = "/hoc-sinh/detail/" + lop.getMaLop();
//        return "redirect:/hoc-sinh/index";
        return new RedirectView(url);
    }

    @DeleteMapping("/destroy/{id}")
    public String destroyHs(@PathVariable("id") Long id){
        hsservice.destroy(id);
        return "redirect:/hoc-sinh/index";
    }
}
