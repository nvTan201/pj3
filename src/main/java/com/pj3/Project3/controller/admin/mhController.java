package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.service.admin.MhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/mon-hoc")
public class mhController {
    @Autowired
    public MhService mhService;

    @GetMapping("/index")
    public String getAll(HttpServletRequest request){
        List<monHoc> rs = mhService.getAll();
        request.setAttribute("rs", rs);
        return "admin/monHoc";
    }
    @PostMapping("/add")
    public String add(Model model, @RequestParam() String name){
        boolean check= this.checkMon(name);
        if (check){
            monHoc rs = new monHoc(name);
            mhService.addMh(rs);
        }
//        model.addAttribute("success", "true");
        return "redirect:/mon-hoc/index";
    }
    public boolean checkMon(String name) {
        List<monHoc> rs = mhService.getAll();
        AtomicBoolean check= new AtomicBoolean(true);
        rs.forEach((element)->{
            if (element.getTenMon().equals(name)){
                check.set(false);
            }
        });
        return check.get();
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<monHoc> edit(@PathVariable("id") Long id){
        monHoc rs = mhService.findByIdMh(id);
        return new ResponseEntity<monHoc>(rs, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @RequestParam() String name){
        boolean check= this.checkMon(name);
        if(check){
            monHoc monHoc = new monHoc(name);
            mhService.editMh(id,monHoc);
        }
        return "redirect:/mon-hoc/index";
    }

    @DeleteMapping("/destroy/{id}")
    public String destroyMh(){
        return null;
    }
}
