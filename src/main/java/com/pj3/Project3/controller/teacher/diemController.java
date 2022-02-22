package com.pj3.Project3.controller.teacher;

import com.pj3.Project3.dto.hsAndDiem;
import com.pj3.Project3.model.diem;
import com.pj3.Project3.model.giangDay;
import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.service.admin.DiemService;
import com.pj3.Project3.service.admin.GdService;
import com.pj3.Project3.service.admin.GvService;
import com.pj3.Project3.service.admin.HsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("teacher/diem")
public class diemController {

    @Autowired
    DiemService diemService;
    @Autowired
    GvService gvService;
    @Autowired
    GdService gdService;
    @Autowired
    HsService hsService;

    @GetMapping("/view/{id}")
    @ResponseBody
    public diem getDiemHs(@PathVariable() Long id){
        if (id == 0){
            return null;
        }
        diem rs = diemService.findById(id);
        return rs;
    }

    @GetMapping("/add/{id}")
    @ResponseBody
    public hsAndDiem getOne(@PathVariable() Long id){
        if (id == 0){
            return null;
        }
        hsAndDiem rs = diemService.findOne(id);

        return rs ;
    }

    @PostMapping("/add")
    public String addDiem(@RequestParam() @Nullable Long lop, @RequestParam() @Nullable Long mon,
                          @RequestParam() @Nullable Float dlt, @RequestParam() @Nullable Float dth,
                          @RequestParam() int trangThai, @RequestParam Long idHs,
                          HttpServletRequest request){
        Principal userPrincipal = request.getUserPrincipal();
        String email = userPrincipal.getName();
        giaoVien gv = gvService.findOne(email);
        Long id = gv.getMaGv();
        giangDay gd = gdService.getIdGd(id,lop,mon);
        hocSinh hs = hsService.findByIdHs(idHs);
        diem diem =null;
        Integer ketQua = null;
        if (trangThai == 1){
            if(dlt != null && dlt >=5){
                ketQua = 1;
            } else if(dth != null && dth >=5){
                ketQua = 1;
            } else if(dlt != null && dth != null && dlt >=5 && dth >=5){
                ketQua = 1;
            }
        }

        diem = new diem(dlt, null, dth, null, trangThai, null, ketQua, hs, gd);

        diemService.addDiem(diem);
        return "redirect:/teacher/class/master";
//        return diem;
    }

    @PostMapping("/edit/{id}")
    public String editDiem(@RequestParam() @Nullable Long lop, @RequestParam() @Nullable Long mon,
                           @RequestParam() @Nullable Float dlt, @RequestParam() @Nullable Float dth,
                           @RequestParam() int trangThai, @RequestParam Long idHs,
                           @PathVariable() Long id, HttpServletRequest request
    ){

        Principal userPrincipal = request.getUserPrincipal();
        String email = userPrincipal.getName();
        giaoVien gv = gvService.findOne(email);
        Long idGv = gv.getMaGv();
        giangDay gd = gdService.getIdGd(idGv,lop,mon);
        hocSinh hs = hsService.findByIdHs(idHs);
        Integer ketQua = null;

        diem rs = diemService.findById(id);
        diem diem = new diem(null, null, null, null, trangThai, null, null, hs, gd);;

        if (rs.getDiemLyThuyet() != null) {
            diem.setDiemLyThuyet(rs.getDiemLyThuyet());
            diem.setDiemLyThuyet1(dlt);
            if (trangThai == 1) {
                if(dlt == null){
                    if ((rs.getDiemLyThuyet())/2 >= 5) {
                        ketQua = 1;
                    }
                }else {
                    if ((rs.getDiemLyThuyet() + dlt) / 2 >= 5) {
                        ketQua = 1;
                    }
                }
            }
        } else {
            diem.setDiemLyThuyet(dlt);
            if(dlt == null){
                if ((rs.getDiemLyThuyet())/2 >= 5) {
                    ketQua = 1;
                }
            }else {
                if (trangThai == 1) {
                    if (dlt >= 5) {
                        ketQua = 1;
                    }
                }
            }
        }
        if(ketQua != null) {
            if (rs.getDiemThucHanh() != null) {
                diem.setDiemThucHanh(rs.getDiemThucHanh());
                diem.setDiemThucHanh1(dth);
                if (trangThai == 1) {
                    if (dth == null) {
                        if (rs.getDiemThucHanh() != null) {
                            if ((rs.getDiemThucHanh()) / 2 >= 5) {
                                ketQua = 1;
                            }
                        }
                    } else {
                        if ((rs.getDiemThucHanh() + dth) / 2 >= 5) {
                            ketQua = 1;
                        }
                    }
                }
            } else {
                diem.setDiemThucHanh(dth);
                if (dth == null) {
                    if (rs.getDiemThucHanh() != null) {
                        if ((rs.getDiemThucHanh()) / 2 >= 5) {
                            ketQua = 1;
                        }
                    }
                } else {
                    if (trangThai == 1) {
                        if (dth >= 5) {
                            ketQua = 1;
                        }
                    }
                }
            }
        } else {
            if (rs.getDiemThucHanh()!=null) {
                diem.setDiemThucHanh(rs.getDiemThucHanh());
                diem.setDiemThucHanh1(dth);
            } else {
                diem.setDiemThucHanh(dth);
            }
        }
        diem.setKetQua(ketQua);

        diemService.editDiem(diem, id);
        return "redirect:/teacher/class/master";
//        return diem;
    }
}
