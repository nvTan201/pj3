package com.pj3.Project3.service.admin;

import com.pj3.Project3.model.diem;
import com.pj3.Project3.repository.admin.IDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiemService {

    @Autowired
    IDiemRepository iDiemRepository;

    public diem findById(Long id){
        Optional<diem> diem = iDiemRepository.findById(id);
        diem rs = null;
        if (diem != null){
            rs = diem.get();
        }
        return rs;
    }
}
