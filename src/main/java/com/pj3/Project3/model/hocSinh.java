package com.pj3.Project3.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hocsinh")
public class hocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHs")
    private Long maHs;

    @Column(name = "hoTenHs", length = 100)
    private String hoTenHs;

    @Column(name = "ngaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private int gioiTinh;

    @Column(name = "emailHs")
    private String emailHs;

    @Column(name = "matKhauHs")
    private String matKhauHs;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "trangThai")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLop")
    private lop lop;

    public hocSinh() {
    }

    public hocSinh(String hoTenHs, Date ngaySinh, int gioiTinh, String emailHs, String matKhauHs, String sdt, int trangThai, com.pj3.Project3.model.lop lop) {
        this.hoTenHs = hoTenHs;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailHs = emailHs;
        this.matKhauHs = matKhauHs;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.lop = lop;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public com.pj3.Project3.model.lop getLop() {
        return lop;
    }

    public void setLop(com.pj3.Project3.model.lop lop) {
        this.lop = lop;
    }
}
