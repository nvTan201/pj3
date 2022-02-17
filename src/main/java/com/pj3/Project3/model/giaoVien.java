package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "giaovien")
public class giaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maGv")
    private Long maGv;

    @Column(name = "hoTenGv", length = 50,
    columnDefinition = "varchar(50)")
    private String hoTenGv;

    @Column(name = "ngaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private int gioiTinh;

    @Column(name = "emailGv")
    private String emailGv;

    @Column(name = "matKhauGv")
    private String matKhauGv;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "trangThai")
    private int trangThai;

    @Column(name = "quyen")
    private int quyen;

    @OneToMany(mappedBy = "giaoVien")
    private List<giangDay> giangDays = new ArrayList<>();

    public giaoVien(String hoTenGv, Date ngaySinh, int gioiTinh, String emailGv, String matKhauGv, String sdt, int trangThai, int quyen) {
        this.hoTenGv = hoTenGv;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailGv = emailGv;
        this.matKhauGv = matKhauGv;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.quyen = quyen;
    }

    public giaoVien() {
    }



    public Long getMaGv() {
        return maGv;
    }

    public void setMaGv(Long maGv) {
        this.maGv = maGv;
    }

    public String getHoTenGv() {
        return hoTenGv;
    }

    public void setHoTenGv(String hoTenGv) {
        this.hoTenGv = hoTenGv;
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

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
}
