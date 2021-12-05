package com.pj3.Project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj3.Project3.model.Gv;
import com.pj3.Project3.repository.IGvRepository;


@Service
public class GvService implements IGvService {

	@Autowired
	public IGvRepository gvrepository;
	
	@Override
	public Gv addGv(Gv gv) {
		if (gv != null) {
			return gvrepository.save(gv);
		}
		return null;
	}

	@Override
	public List<Gv> getAllGv() {
		return gvrepository.findAll();
	}

	@Override
	public Gv getById(long maGv) {
		return gvrepository.getById(maGv);
	}

	@Override
	public Gv updateGv(long maGv, Gv gv) {
		Gv gvbyid = gvrepository.getById(maGv);
		if (gvbyid != null) {
			gvbyid.setHoTenGv(gv.getHoTenGv());
			gvbyid.setEmailGv(gv.getEmailGv());
			gvbyid.setMatKhauGv(gv.getMatKhauGv());
			gvbyid.setNgaySinh(gv.getNgaySinh());
			gvbyid.setGioiTinh(gv.isGioiTinh());
			gvbyid.setSdt(gv.getSdt());
			gvbyid.setQuyen(gv.isQuyen());
			
			return gvrepository.save(gvbyid);
		}
		return null;
	}

	@Override
	public boolean deleteGv(long maGv) {
		if (maGv >= 1) {
			Gv gv = gvrepository.getById(maGv);
			if (gv!= null) {
				gvrepository.delete(gv);
				return true;
			}
		}
		return false;
	}

}

