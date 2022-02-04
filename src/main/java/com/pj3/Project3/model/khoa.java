package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="khoa")
public class khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKhoa")
    private long idKhoa;

    @Column(name = "tenKhoa")
    private String tenKhoa;

    @Column(name = "namNhapHoc")
    @Temporal(TemporalType.DATE)
    private Date namNhapHoc;

    @Column(name = "hoc")
    private int hoc;

    @OneToMany(mappedBy = "khoa")
    private List<lop> lop = new ArrayList<>();

    public khoa() {
    }

    public khoa(String tenKhoa, Date namNhapHoc, int hoc) {
        this.tenKhoa = tenKhoa;
        this.namNhapHoc = namNhapHoc;
        this.hoc = hoc;
    }

    public long getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(long idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public Date getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(Date namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public int getHoc() {
        return hoc;
    }

    public void setHoc(int hoc) {
        this.hoc = hoc;
    }
}
