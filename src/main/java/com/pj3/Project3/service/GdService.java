package com.pj3.Project3.service;

import com.pj3.Project3.model.giangDay;
import com.pj3.Project3.repository.IGdRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GdService {

    @Autowired
    IGdRepository iGdRepository;

    public List<giangDay> getAll(){
        return iGdRepository.findAll();
    }
}
