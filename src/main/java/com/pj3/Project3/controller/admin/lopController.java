package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.khoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.service.admin.KhoaService;
import com.pj3.Project3.service.admin.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/lop")
public class lopController {

    @Autowired
    public KhoaService khoaService;

    @Autowired
    private LopService lopService;

    @GetMapping("/index")
    public String getAllLop(Model model){
        List<LopAndKhoa> rs = lopService.displayLop();
        List<khoa> k = khoaService.getAllKhoa();
        model.addAttribute("rs",rs);
        model.addAttribute("k",k);
        return "admin/lop";

    }

    @PostMapping("/add")
    public String addLop(@RequestParam() String tenlop, @RequestParam() khoa khoa){
        boolean check = this.checkLop(tenlop, khoa);
        if (check){
            lop rs = new lop(tenlop, khoa);
            lopService.addLop(rs);
        }
        return "redirect:/lop/index";
    }
    public boolean checkLop(String tenLop, khoa khoa) {
        List<LopAndKhoa> rs = lopService.displayLop();
        List<khoa> k = khoaService.getAllKhoa();
        AtomicBoolean check= new AtomicBoolean(true);
        rs.forEach((element)->{
            if (element.getTen_lop().equals(tenLop) || element.getTen_khoa().equals(khoa)){
                check.set(false);
            }
        });
        return check.get();
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<lop> editLop(@PathVariable("id") Long id){
        lop rs = lopService.findByIdLop(id);
        return new ResponseEntity<lop>(rs,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public String editLop(@PathVariable() Long id,
                                       @RequestParam String name, @RequestParam khoa khoa){
        lop lop = new lop(name, khoa);
        lopService.editLop(id, lop);
        return "redirect:/lop/index";
    }

//    @GetMapping("/view/{id}")
//    public String views(@PathVariable() Long id, Model model){
//        List<giangDayGetAll> rs = lopService.viewsDetail(id);
//        model.addAttribute("rs", rs);
//        return "lopDetail";
//    }

}
