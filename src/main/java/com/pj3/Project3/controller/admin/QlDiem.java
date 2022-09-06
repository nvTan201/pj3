package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.dto.hsAndDiem;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.service.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ql-diem")
public class QlDiem {
    @Autowired
    private GdService gdService;
    @Autowired
    private LopService lopService;
    @Autowired
    private GvService gvService;
    @Autowired
    private MhService mhService;
    @Autowired
    private HsService hsservice;
    @GetMapping("/index")
    public String index(Model model){
        List<lop> lops = lopService.getAllLop();
        List<LopAndKhoa> rs = lopService.displayLop();
        model.addAttribute("lops",lops);
        model.addAttribute("rs",rs);
        return "admin/QuanLyDiem";
    }

    @GetMapping("/detail-lop/{id}")
    public String detailGd(@PathVariable("id") Long id, Model model){
        lop lop = lopService.findByIdLop(id);
        List<giangDayGetAll> rs = gdService.getByIdLop(id);
        List<monHoc> mh = mhService.getMonByLop(id);

        model.addAttribute("lop", lop);
        model.addAttribute("rs", rs);
        model.addAttribute("mh",mh);
        return "admin/qlDiemDetail";
    }
    @GetMapping("/{idLop}/detail/{id}")
    public String detailGd( @PathVariable("idLop") Long idLop,@PathVariable("id") Long id,Model model){

        List<hsAndDiem> hs = hsservice.getDiem(idLop,id);
        model.addAttribute("hs",hs);

//        return ResponseEntity.ok(hs);
        return "admin/detail";
    }
}
