package com.pj3.Project3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gv")
public class Gv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maGv;
	
	@Column(name = "hoTenGv")
	private String hoTenGv;
	
	@Column(name = "ngaySinh")
	private String ngaySinh;

	@Column(name = "gioiTinh")
	private int gioiTinh;

	@Column(name = "emailGv")
	private String emailGv;

	@Column(name = "matKhauGv")
	private String matKhauGv;

	@Column(name = "sdt")
	private int sdt;

	@Column(name = "quyen")
	private int quyen;
	
	public Gv() {
		super();
	}
	
	public Gv(long maGv, String hoTenGv, String ngaySinh, int gioiTinh, String emailGv, String matKhauGv, int sdt,
			int quyen) {
		super();
		this.maGv = maGv;
		this.hoTenGv = hoTenGv;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.emailGv = emailGv;
		this.matKhauGv = matKhauGv;
		this.sdt = sdt;
		this.quyen = quyen;
	}

	public long getMaGv() {
		return maGv;
	}

	public void setMaGv(long maGv) {
		this.maGv = maGv;
	}

	public String getHoTenGv() {
		return hoTenGv;
	}

	public void setHoTenGv(String hoTenGv) {
		this.hoTenGv = hoTenGv;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmailGv() {
		return emailGv;
	}

	public void setEmailGv(String emailGv) {
		this.emailGv = emailGv;
	}

	public String getMatKhauGv() {
		return matKhauGv;
	}

	public void setMatKhauGv(String matKhauGv) {
		this.matKhauGv = matKhauGv;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public int isQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	
}
