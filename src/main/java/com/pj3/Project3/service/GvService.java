package com.pj3.Project3.service;

import java.util.List;
import java.util.Optional;

import com.pj3.Project3.model.giaoVien;
import com.pj3.Project3.model.hocSinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj3.Project3.repository.IGvRepository;


@Service
public class GvService {
	@Autowired
	IGvRepository iGvRepository;

	public List<giaoVien> getAllGv(){
		return iGvRepository.displayGvFindById(1);
	}

	public giaoVien addGv(giaoVien giaoVien){
		return iGvRepository.save(giaoVien);
	}

	public giaoVien findByIdGv(Long id){
		Optional<giaoVien> rs = iGvRepository.findById(id);
		giaoVien giaoVien = null;
		if(rs != null){
			giaoVien = rs.get();
		}
		return giaoVien;
	}

	public giaoVien editHs(Long id, giaoVien giaoVien){
		giaoVien gvById = iGvRepository.getById(id);
		if(gvById != null){
			gvById.setHoTenGv(giaoVien.getHoTenGv());
			gvById.setNgaySinh(giaoVien.getNgaySinh());
			gvById.setGioiTinh(giaoVien.getGioiTinh());
			gvById.setSdt(giaoVien.getSdt());
			gvById.setEmailGv(giaoVien.getEmailGv());
			gvById.setQuyen(giaoVien.getQuyen());

			return iGvRepository.save(gvById);
		}
		return null;
	}

	public giaoVien destroy(Long id){
		giaoVien gvById = iGvRepository.getById(id);
		if(gvById != null && gvById.getTrangThai() == 1){
			gvById.setTrangThai(0);
			return iGvRepository.save(gvById);
		}
		return null;
	}

}

