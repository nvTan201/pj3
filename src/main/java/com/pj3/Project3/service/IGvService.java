package com.pj3.Project3.service;

import com.pj3.Project3.model.giaoVien;

import java.util.List;

public interface IGvService {
	//them 
	public giaoVien addGv(giaoVien giaoVien);
	
	//lay tat ca 
	public List<giaoVien> getAllGv();
	
	//lay theo id
	public giaoVien getById(long maGv);
	
	//chinh sua 
	public giaoVien updateGv(long maGv, giaoVien gv);
	
	//xoa 
	public boolean deleteGv(long maGv);
	
	
}
