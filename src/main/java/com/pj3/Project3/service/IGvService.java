package com.pj3.Project3.service;

import java.util.List;

import com.pj3.Project3.model.Gv;

public interface IGvService {
	//them 
	public Gv addGv(Gv gv);
	
	//lay tat ca 
	public List<Gv> getAllGv();
	
	//lay theo id
	public Gv getById(long maGv);
	
	//chinh sua 
	public Gv updateGv(long maGv, Gv gv); 
	
	//xoa 
	public boolean deleteGv(long maGv);
	
	
}
