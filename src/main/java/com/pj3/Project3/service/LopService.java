package com.pj3.Project3.service;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.repository.ILopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopService{

    @Autowired
    public ILopRepository iLopRepository;

    public List<lop> getAllLop() {
        return iLopRepository.findAll();
    }

    public lop addLop(lop lop) {
        if (lop != null){
            return iLopRepository.save(lop);
        }
        return null;
    }

    public List<LopAndKhoa> displayLopById(){
        List<LopAndKhoa> lop = iLopRepository.displayLopById();
        return lop;
    }


}
