package com.pj3.Project3.service;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.lop;
import com.pj3.Project3.repository.IGdRepository;
import com.pj3.Project3.repository.ILopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LopService{

    @Autowired
    public ILopRepository iLopRepository;

    @Autowired
    public IGdRepository iGdRepository;

    public List<lop> getAllLop() {
        return iLopRepository.findAll();
    }

    public lop addLop(lop lop) {
        if (lop != null){
            return iLopRepository.save(lop);
        }
        return null;
    }

    public List<LopAndKhoa> displayLop(){
        List<LopAndKhoa> lop = iLopRepository.displayLop();
        return lop;
    }

    public lop findByIdLop(Long id){
        Optional<lop> rs = iLopRepository.findById(id);
        lop lop = null;
        if(rs != null){
            lop = rs.get();
        }
        return lop;
    }

    public lop editLop(Long id, lop lop){
        lop lop1 = iLopRepository.getById(id);
        if (lop1 != null){
            lop1.setTenLop(lop.getTenLop());
            lop1.setKhoa(lop.getKhoa());

            return iLopRepository.save(lop1);
        }
        return null;
    }

}
