package com.pj3.Project3.service;

import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.repository.IHsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HsService implements IHsService{

    @Autowired
    public IHsRepository iHsRepository;

    @Override
    public List<hocSinh> getAllHs() {
        return iHsRepository.findAll();
    }

    @Override
    public hocSinh addHs(hocSinh hocSinh) {
        if(hocSinh != null){
            return iHsRepository.save(hocSinh);
        }
        return null;
    }


}
