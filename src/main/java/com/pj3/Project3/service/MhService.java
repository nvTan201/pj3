package com.pj3.Project3.service;

import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.repository.IMhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MhService{

    @Autowired
    public IMhRepository iMhRepository;

    public List<monHoc> getAll() {
        return iMhRepository.findAll();
    }

    public monHoc addMh(monHoc monHoc) {
        if(monHoc != null){
            return iMhRepository.save(monHoc);
        }
        return null;
    }

    public monHoc editMh(long id, monHoc monHoc) {
        monHoc byId = iMhRepository.getById(id);
        if(byId !=null){
            byId.setTenMon(monHoc.getTenMon());
            return iMhRepository.save(byId);
        }
        return null;
    }

}
