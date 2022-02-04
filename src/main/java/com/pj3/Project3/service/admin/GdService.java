package com.pj3.Project3.service.admin;

import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.model.giangDay;
import com.pj3.Project3.repository.admin.IGdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GdService {

    @Autowired
    IGdRepository iGdRepository;

    public List<giangDayGetAll> getAll(){
        return iGdRepository.displayGdAll();
    }

    public List<giangDayGetAll> getByIdLop(Long id){
        return iGdRepository.findGdByIdLop(id);
    }

    public giangDay addGd(giangDay giangDay){
        if (giangDay != null){
            iGdRepository.save(giangDay);
        }
        return null;
    }

    public giangDayGetAll findByIdGd(Long id){
        Optional<giangDayGetAll> rs = iGdRepository.findGdById(id);
        giangDayGetAll giangDay = null;
        if (rs != null){
            giangDay = rs.get();
        }
        return giangDay;
    }

    public giangDay editGd(Long id, giangDay giangDay){
        giangDay rs = iGdRepository.getById(id);
        if (rs != null){
            rs.setNamHoc(giangDay.getNamHoc());
            rs.setHocKy(giangDay.getHocKy());
            rs.setGiaoVien(giangDay.getGiaoVien());
            rs.setMonHoc(giangDay.getMonHoc());
            rs.setLop(giangDay.getLop());
            rs.setChuNghiem(giangDay.getChuNghiem());
            rs.setTrangThai(giangDay.getTrangThai());

            return iGdRepository.save(rs);
        }
        return null;
    }
}
