package com.pj3.Project3.model;

import javax.persistence.*;

@Entity
@Table(name = "giangday")
public class giangDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maGd")
    private Long maGd;

    @Column(name = "namHoc")
    private int namHoc;

    @Column(name = "hocKy")
    private String hocKy;

    @ManyToOne()
    @JoinColumn(name="maGv")
    private giaoVien giaoVien;

    @ManyToOne()
    @JoinColumn(name="maMon")
    private monHoc monHoc;

    @ManyToOne()
    @JoinColumn(name="maLop")
    private lop lop;

    @Column(name = "trangThai")
    private int trangThai;

    @Column(name = "chuNghiem")
    private int chuNghiem;

    public giangDay() {
    }

    public giangDay(int namHoc, String hocKy, com.pj3.Project3.model.giaoVien giaoVien, com.pj3.Project3.model.monHoc monHoc, com.pj3.Project3.model.lop lop, int trangThai, int chuNghiem) {
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.giaoVien = giaoVien;
        this.monHoc = monHoc;
        this.lop = lop;
        this.trangThai = trangThai;
        this.chuNghiem = chuNghiem;
    }

    public Long getMaGd() {
        return maGd;
    }

    public void setMaGd(Long maGd) {
        this.maGd = maGd;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public com.pj3.Project3.model.giaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(com.pj3.Project3.model.giaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public com.pj3.Project3.model.monHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(com.pj3.Project3.model.monHoc monHoc) {
        this.monHoc = monHoc;
    }

    public com.pj3.Project3.model.lop getLop() {
        return lop;
    }

    public void setLop(com.pj3.Project3.model.lop lop) {
        this.lop = lop;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getChuNghiem() {
        return chuNghiem;
    }

    public void setChuNghiem(int chuNghiem) {
        this.chuNghiem = chuNghiem;
    }
}
