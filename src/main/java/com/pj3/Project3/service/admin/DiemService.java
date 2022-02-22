package com.pj3.Project3.service.admin;

import com.pj3.Project3.dto.hsAndDiem;
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

    public hsAndDiem findOne(Long id){
        Optional<hsAndDiem> diem = iDiemRepository.findOneDiem(id);
        hsAndDiem rs = null;
        if (diem != null){
            rs = diem.get();
        }
        return rs;
    }

    public diem addDiem(diem diem){
        if (diem != null){
            iDiemRepository.save(diem);
        }
        return null;
    }

    public diem editDiem(diem diem, Long id){
        diem d = iDiemRepository.getById(id);
        if (diem != null){
            d.setDiemLyThuyet(diem.getDiemLyThuyet());
            d.setDiemLyThuyet1(diem.getDiemLyThuyet1());
            d.setDiemThucHanh(diem.getDiemThucHanh());
            d.setDiemThucHanh1(diem.getDiemThucHanh1());
            d.setTrangThai(diem.getTrangThai());
            d.setDiemTb(diem.getDiemTb());
            d.setKetQua(diem.getKetQua());
            d.setHocSinh(diem.getHocSinh());
            d.setGiangDay(diem.getGiangDay());

            iDiemRepository.save(d);
        }
        return null;
    }
}
