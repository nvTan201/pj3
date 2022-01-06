package com.pj3.Project3.service;

import java.util.List;

import com.pj3.Project3.model.giaoVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj3.Project3.repository.IGvRepository;


@Service
public class GvService {

	public IGvRepository gvrepository;

	public giaoVien login(String email, String pass) {
		return null;
	}

	public giaoVien addGv(giaoVien giaoVien) {
		if (giaoVien != null) {
			return gvrepository.save(giaoVien);
		}
		return null;
	}

	public List<giaoVien> getAllGv() {
		return gvrepository.findAll();
	}

	public giaoVien getById(long maGv) {
		return gvrepository.getById(maGv);
	}

	public giaoVien updateGv(long maGv, giaoVien gv) {
		giaoVien gvbyid = gvrepository.getById(maGv);
		if (gvbyid != null) {
			gvbyid.setHoTenGv(gv.getHoTenGv());
			gvbyid.setEmailGv(gv.getEmailGv());
			gvbyid.setMatKhauGv(gv.getMatKhauGv());
			gvbyid.setNgaySinh(gv.getNgaySinh());
			gvbyid.setGioiTinh(gv.getGioiTinh());
			gvbyid.setSdt(gv.getSdt());
			gvbyid.setQuyen(gv.getQuyen());

			return gvrepository.save(gvbyid);
		}
		return null;
	}

	public boolean deleteGv(long maGv) {
		if (maGv >= 1) {
			giaoVien giaoVien = gvrepository.getById(maGv);
			if (giaoVien!= null) {
				gvrepository.delete(giaoVien);
				return true;
			}
		}
		return false;
	}

}

