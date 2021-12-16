package com.pj3.Project3.model;

import javax.persistence.*;

@Entity
@Table(name = "hocsinh")
public class hocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maHs;

    @Column(name = "hoTenHs")
    private String hoTenHs;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @Column(name = "gioiTinh")
    private int gioiTinh;

    @Column(name = "emailHs")
    private String emailHs;

    @Column(name = "matKhauHs")
    private String matKhauHs;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "maLop")
    private int maLop;

    public hocSinh() {
    }

    public hocSinh(Long maHs, String hoTenHs, String ngaySinh, int gioiTinh, String emailHs, String matKhauHs, String sdt, int maLop) {
        this.maHs = maHs;
        this.hoTenHs = hoTenHs;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailHs = emailHs;
        this.matKhauHs = matKhauHs;
        this.sdt = sdt;
        this.maLop = maLop;
    }

    public Long getMaHs() {
        return maHs;
    }

    public void setMaHs(Long maHs) {
        this.maHs = maHs;
    }

    public String getHoTenHs() {
        return hoTenHs;
    }

    public void setHoTenHs(String hoTenHs) {
        this.hoTenHs = hoTenHs;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmailHs() {
        return emailHs;
    }

    public void setEmailHs(String emailHs) {
        this.emailHs = emailHs;
    }

    public String getMatKhauHs() {
        return matKhauHs;
    }

    public void setMatKhauHs(String matKhauHs) {
        this.matKhauHs = matKhauHs;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }
}
