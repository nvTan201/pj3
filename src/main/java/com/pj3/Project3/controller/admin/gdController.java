package com.pj3.Project3.controller.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.model.giangDay;
import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.service.admin.GdService;
import com.pj3.Project3.service.admin.GvService;
import com.pj3.Project3.service.admin.LopService;
import com.pj3.Project3.service.admin.MhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/giang-day")
public class gdController {

    @Autowired
    private GdService gdService;
    @Autowired
    private LopService lopService;
    @Autowired
    private GvService gvService;
    @Autowired
    private MhService mhService;

    @GetMapping("/index")
    public String index(Model model){
        List<lop> lops = lopService.getAllLop();
        List<LopAndKhoa> rs = lopService.displayLop();
        model.addAttribute("lops",lops);
        model.addAttribute("rs",rs);
        return "admin/giangDay";
    }

    @GetMapping("detail/{id}")
    public String detailGd(@PathVariable("id") Long id, Model model){
        lop lop = lopService.findByIdLop(id);
        List<giangDayGetAll> rs = gdService.getByIdLop(id);
        model.addAttribute("lop", lop);
        model.addAttribute("rs", rs);
        return "admin/gdDetail";
    }

    @GetMapping("add/{id}")
    public String addGd(Model model,@PathVariable() Long id){
        List<giaoVien> gv = gvService.getAllGv();
        List<LopAndKhoa> lops = lopService.displayLop();
        lop lop = lopService.findByIdLop(id);
        List<monHoc> mh = mhService.getAll();
        model.addAttribute("gv",gv);
        model.addAttribute("lops",lops);
        model.addAttribute("lop",lop);
        model.addAttribute("mh",mh);
        return "admin/addGd";
    }

    @PostMapping("add")
    public RedirectView add(@RequestParam() int namhoc, @RequestParam() String hocky, @RequestParam() giaoVien giaovien
        , @RequestParam() monHoc mon, @RequestParam() lop lop){
        boolean check=  this.checkGV(giaovien.getMaGv(),mon.getMaMon(),lop.getMaLop());
        String url = "/giang-day/detail/" + lop.getMaLop();
       if (check){
           giangDay giangDay = new giangDay(namhoc, hocky, giaovien, mon, lop,0,0);
           gdService.addGd(giangDay, giaovien.getMaGv(), lop.getMaLop());
       }
        return new RedirectView(url);

//        return giangDay;
    }

    public boolean checkGV(Long giaovienId, Long monId, Long lopId ) {
        List<giangDayGetAll> gv = gdService.getByIdLop(lopId);
        AtomicBoolean check= new AtomicBoolean(true);
        gv.forEach((element)->{
            if (element.getMa_gv().equals(giaovienId) || element.getMa_mon().equals(monId) ){
              check.set(false);
            }
        });
            return check.get();
    }
    @GetMapping("/edit/{id}")
    public String editGd(@PathVariable Long id, Model model){
        giangDayGetAll rs = gdService.findByIdGd(id);
        List<giaoVien> gv = gvService.getAllGv();
        List<LopAndKhoa> lop = lopService.displayLop();
        List<monHoc> mh = mhService.getAll();
        model.addAttribute("rs",rs);
        model.addAttribute("gv",gv);
        model.addAttribute("lop",lop);
        model.addAttribute("mh",mh);
        return "admin/editGiangDay";
    }

    @PutMapping("/edit/{id}")
    public RedirectView editGd(@RequestParam() int namhoc, @RequestParam() String hocky,@RequestParam() giaoVien giaovien
            ,@RequestParam() monHoc mon, @RequestParam() lop lop, @RequestParam int trangThai
            , @PathVariable Long id){
        giangDay giangDay = new giangDay(namhoc, hocky, giaovien, mon, lop, trangThai, 0);
        gdService.editGd(id,giangDay);
        String url = "/giang-day/detail/" + lop.getMaLop();
        return new RedirectView(url);
    }
}
