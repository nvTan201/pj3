package com.pj3.Project3.service.admin;

import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.repository.admin.IHsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HsService{

    @Autowired
    public IHsRepository iHsRepository;

    public List<hsLopAndKhoa> getAllHs() {
        return iHsRepository.displayHs();
    }

    public hocSinh addHs(hocSinh hocSinh) {
        if(hocSinh != null){
            return iHsRepository.save(hocSinh);
        }
        return null;
    }

    public hocSinh findByIdHs(Long id){
        Optional<hocSinh> rs = iHsRepository.findById(id);
        hocSinh hocSinh = null;
        if(rs!=null){
            hocSinh = rs.get();
            return hocSinh;
        }
        return null;
    }

    public hocSinh editHs(Long id, hocSinh hocSinh){
        hocSinh hsById = iHsRepository.getById(id);
        if(hsById != null){
            hsById.setHoTenHs(hocSinh.getHoTenHs());
            hsById.setNgaySinh(hocSinh.getNgaySinh());
            hsById.setGioiTinh(hocSinh.getGioiTinh());
            hsById.setSdt(hocSinh.getSdt());
            hsById.setLop(hocSinh.getLop());
            hsById.setEmailHs(hocSinh.getEmailHs());

            return iHsRepository.save(hsById);
        }
        return null;
    }

    public hocSinh destroy(long id){
        hocSinh hsById = iHsRepository.getById(id);
        if(hsById != null && hsById.getTrangThai() == 1){
            hsById.setTrangThai(0);
            return iHsRepository.save(hsById);
        }
        return null;
    }

}
