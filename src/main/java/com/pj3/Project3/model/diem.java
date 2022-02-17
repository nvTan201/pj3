package com.pj3.Project3.model;

import javax.persistence.*;

@Entity
@Table(name = "diem")
public class diem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDiem")
    private Long maDiem;

    @Column(name = "diemLyThuyet")
    private int diemLyThuyet;

    @Column(name = "diemLyThuyet1")
    private int diemLyThuyet1;

    @Column(name = "diemThucHanh")
    private int diemThucHanh;

    @Column(name = "diemThucHanh1")
    private int diemThucHanh1;

    @Column(name = "trangThai")
    private int trangThai;

    @Column(name = "diemTb")
    private int diemTb;

    @Column(name = "ketQua")
    private int ketQua;

    @ManyToOne()
    @JoinColumn(name="maHs")
    private hocSinh hocSinh;

    @ManyToOne()
    @JoinColumn(name="maGd")
    private giangDay giangDay;

    public diem() {
    }

    public diem(int diemLyThuyet, int diemLyThuyet1, int diemThucHanh, int diemThucHanh1, int trangThai, int diemTb, int ketQua, com.pj3.Project3.model.hocSinh hocSinh, com.pj3.Project3.model.giangDay giangDay) {
        this.diemLyThuyet = diemLyThuyet;
        this.diemLyThuyet1 = diemLyThuyet1;
        this.diemThucHanh = diemThucHanh;
        this.diemThucHanh1 = diemThucHanh1;
        this.trangThai = trangThai;
        this.diemTb = diemTb;
        this.ketQua = ketQua;
        this.hocSinh = hocSinh;
        this.giangDay = giangDay;
    }

    public Long getMaDiem() {
        return maDiem;
    }

    public void setMaDiem(Long maDiem) {
        this.maDiem = maDiem;
    }

    public int getDiemLyThuyet() {
        return diemLyThuyet;
    }

    public void setDiemLyThuyet(int diemLyThuyet) {
        this.diemLyThuyet = diemLyThuyet;
    }

    public int getDiemLyThuyet1() {
        return diemLyThuyet1;
    }

    public void setDiemLyThuyet1(int diemLyThuyet1) {
        this.diemLyThuyet1 = diemLyThuyet1;
    }

    public int getDiemThucHanh() {
        return diemThucHanh;
    }

    public void setDiemThucHanh(int diemThucHanh) {
        this.diemThucHanh = diemThucHanh;
    }

    public int getDiemThucHanh1() {
        return diemThucHanh1;
    }

    public void setDiemThucHanh1(int diemThucHanh1) {
        this.diemThucHanh1 = diemThucHanh1;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(int diemTb) {
        this.diemTb = diemTb;
    }

    public int getKetQua() {
        return ketQua;
    }

    public void setKetQua(int ketQua) {
        this.ketQua = ketQua;
    }

    public com.pj3.Project3.model.hocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(com.pj3.Project3.model.hocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    public com.pj3.Project3.model.giangDay getGiangDay() {
        return giangDay;
    }

    public void setGiangDay(com.pj3.Project3.model.giangDay giangDay) {
        this.giangDay = giangDay;
    }
}
