package com.pj3.Project3.service;

import com.pj3.Project3.model.lop;
import com.pj3.Project3.repository.ILopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopService implements ILopService{

    @Autowired
    public ILopRepository iLopRepository;

    @Override
    public List<lop> getAllLop() {
        return iLopRepository.findAllLop();
    }
}
