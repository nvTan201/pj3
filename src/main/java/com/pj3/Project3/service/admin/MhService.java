package com.pj3.Project3.service.admin;

import com.pj3.Project3.model.monHoc;
import com.pj3.Project3.repository.admin.IMhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public monHoc findByIdMh(Long id){
        Optional<monHoc> rs = iMhRepository.findById(id);
        monHoc monHoc = null;
        if (rs != null){
            monHoc = rs.get();
            return monHoc;
        }
        return null;
    }

    public monHoc editMh(Long id, monHoc monHoc) {
        monHoc byId = iMhRepository.getById(id);
        if(byId !=null){
            byId.setTenMon(monHoc.getTenMon());
            return iMhRepository.save(byId);
        }
        return null;
    }

    public boolean destroyMh(Long id){
        if (id >= 1){
            monHoc monHoc = iMhRepository.getById(id);
            if(monHoc != null){
                iMhRepository.delete(monHoc);
                return true;
            }
        }
        return false;
    }
}
