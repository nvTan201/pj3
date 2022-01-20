package com.pj3.Project3.service;

import com.pj3.Project3.model.khoa;
import com.pj3.Project3.repository.IKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaService{

    @Autowired
    IKhoaRepository iKhoaRepository;

    public List<khoa> getAllKhoa() {
        return iKhoaRepository.findAll();
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
        if(khoa1 != null){
            khoa1.setTenKhoa(khoa.getTenKhoa());

            iKhoaRepository.save(khoa1);
        }
        return null;
    }
}
