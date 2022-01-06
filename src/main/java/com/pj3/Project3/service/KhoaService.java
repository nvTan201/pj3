package com.pj3.Project3.service;

import com.pj3.Project3.model.khoa;
import com.pj3.Project3.repository.IKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
