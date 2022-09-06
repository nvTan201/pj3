package com.pj3.Project3.service.admin;

import com.pj3.Project3.model.khoa;
import com.pj3.Project3.repository.admin.IKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaService{

    @Autowired
    IKhoaRepository iKhoaRepository;

    public List<khoa> getAllKhoa() {
        return iKhoaRepository.getAllKhoadb();
    }

    public khoa addKhoa(khoa khoa) {
        if(khoa != null){
            return iKhoaRepository.save(khoa);
        }
        return null;
    }

    public khoa findByIdKhoa(Long id){
        Optional<khoa> rs = iKhoaRepository.findById(id);
        khoa khoa = null;
        if (rs != null){
            khoa = rs.get();
        }
        return khoa;
    }

    public khoa editKhoa(Long id , khoa khoa){
        khoa khoa1 = iKhoaRepository.getById(id);
        if(khoa != null){

            khoa1.setTenKhoa(khoa.getTenKhoa());
            khoa1.setHoc(khoa.getHoc());
            khoa1.setNamNhapHoc(khoa.getNamNhapHoc());
            iKhoaRepository.save(khoa1);
        }
        return null;
    }
}
