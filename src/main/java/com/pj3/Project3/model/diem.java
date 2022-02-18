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
    private Float diemLyThuyet;

    @Column(name = "diemLyThuyet1")
    private Float diemLyThuyet1;

    @Column(name = "diemThucHanh")
    private Float diemThucHanh;

    @Column(name = "diemThucHanh1")
    private Float diemThucHanh1;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "diemTb")
    private Float diemTb;

    @Column(name = "ketQua")
    private Integer ketQua;

    @ManyToOne()
    @JoinColumn(name="maHs")
    private hocSinh hocSinh;

    @ManyToOne()
    @JoinColumn(name="maGd")
    private giangDay giangDay;

    public diem() {
    }

    public diem(Float diemLyThuyet, Float diemLyThuyet1, Float diemThucHanh, Float diemThucHanh1, Integer trangThai, Float diemTb, Integer ketQua, com.pj3.Project3.model.hocSinh hocSinh, com.pj3.Project3.model.giangDay giangDay) {
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

    public Float getDiemLyThuyet() {
        return diemLyThuyet;
    }

    public void setDiemLyThuyet(Float diemLyThuyet) {
        this.diemLyThuyet = diemLyThuyet;
    }

    public Float getDiemLyThuyet1() {
        return diemLyThuyet1;
    }

    public void setDiemLyThuyet1(Float diemLyThuyet1) {
        this.diemLyThuyet1 = diemLyThuyet1;
    }

    public Float getDiemThucHanh() {
        return diemThucHanh;
    }

    public void setDiemThucHanh(Float diemThucHanh) {
        this.diemThucHanh = diemThucHanh;
    }

    public Float getDiemThucHanh1() {
        return diemThucHanh1;
    }

    public void setDiemThucHanh1(Float diemThucHanh1) {
        this.diemThucHanh1 = diemThucHanh1;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Float getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(Float diemTb) {
        this.diemTb = diemTb;
    }

    public Integer getKetQua() {
        return ketQua;
    }

    public void setKetQua(Integer ketQua) {
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
