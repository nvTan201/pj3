package com.pj3.Project3.controller.teacher;

import com.pj3.Project3.model.diem;
import com.pj3.Project3.service.admin.DiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("teacher/diem")
public class diemController {

    @Autowired
    DiemService diemService;

    @GetMapping("/view/{id}")
    @ResponseBody
    public diem getDiemHs(@PathVariable() Long id){
        diem rs = diemService.findById(id);
//        return new ResponseEntity<diem>(rs, HttpStatus.OK);
        return rs;
    }
}
