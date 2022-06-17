package com.pj3.Project3.controller.teacher;

import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.dto.hsAndDiem;
import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.service.admin.GdService;
import com.pj3.Project3.service.admin.GvService;
import com.pj3.Project3.service.admin.HsService;
import com.pj3.Project3.service.admin.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("teacher/class")
public class lopGvController {


    @Autowired
    private GdService gdService;

    @Autowired
    private HsService hsService;

    @Autowired
    private GvService gvService;

    @Autowired
    private LopService lopService;

    @GetMapping("/index")
    public String getClassByGv(HttpServletRequest request, Model model){
        int nh = new Date().getYear()+1900;
        Principal userPrincipal = request.getUserPrincipal();
        String email = userPrincipal.getName();
        giaoVien gv = gvService.findOne(email);
        Long id = gv.getMaGv();
        List<giangDayGetAll> rs = gdService.findGdByGv(id,nh);
        model.addAttribute("rs", rs);
        return "teacher/home";
    }

    @GetMapping("/master")
    public String getMasterClass(HttpServletRequest request, Model model){
        int nh = new Date().getYear()+1900;
        Principal userPrincipal = request.getUserPrincipal();
        String email = userPrincipal.getName();
        giaoVien gv = gvService.findOne(email);
        Long id = gv.getMaGv();

        giangDayGetAll rs = gdService.findMasterClass(id, nh);
        List<hsAndDiem> hs = hsService.getByIdLop(rs.getMa_lop());

        model.addAttribute("rs",rs);
        model.addAttribute("hs",hs);
        return "teacher/masterClass";
    }

    @GetMapping("/detail/{id}")
    public String detailClass(@PathVariable() Long id, HttpServletRequest request, Model model, Long mon){

        int nh = new Date().getYear()+1900;
        Principal userPrincipal = request.getUserPrincipal();
        String email = userPrincipal.getName();
        giaoVien gv = gvService.findOne(email);
        Long idGv = gv.getMaGv();

        giangDayGetAll rs = gdService.getGdByGv(idGv, id, mon, nh);
        List<hsAndDiem> hs = hsService.getByIdLop(id);
//        return rs;
        model.addAttribute("rs", rs);
        model.addAttribute("hs", hs);
        return "teacher/detailClass";
    }
}
