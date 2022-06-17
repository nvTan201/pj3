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

    public giangDay addGd(giangDay giangDay, Long id, Long idLop){
        giangDay gd = iGdRepository.checkChuNghiem(id, idLop);
        if (gd == null){
            if (giangDay != null){
                iGdRepository.save(giangDay);
            }
            return null;
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

    public List<giangDayGetAll> findGdByGv(Long gv, int nh){
        List<giangDayGetAll> lops = iGdRepository.findGdByGv(gv,nh);
        if(lops != null){
            return lops;
        }
        return null;
    }

    public giangDayGetAll findMasterClass(Long gv, int nh){
        Optional<giangDayGetAll> gd = iGdRepository.findMasterClass(gv, nh);
        if(gd != null){
            giangDayGetAll rs = gd.get();
            return rs;
        }
        return null;
    }

    public giangDay getIdGd(Long maGv, Long maLop, Long maMon){
        giangDay id = iGdRepository.getIdGd(maGv, maLop, maMon);
        if (id != null){
            return id;
        }
        return null;
    }

    public giangDayGetAll getGdByGv(Long maGv, Long maLop, Long maMon, int nh){
        giangDayGetAll rs = iGdRepository.getGdByGv(maGv, maLop, maMon, nh);
        if (rs != null){
            return rs;
        }
        return null;
    }

}
