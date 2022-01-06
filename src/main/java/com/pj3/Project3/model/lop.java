package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lop")
public class lop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLop")
    private long maLop;

    @Column(name = "tenLop")
    private String tenLop;

    @ManyToOne()
    @JoinColumn(name="idKhoa")
    private khoa khoa;

    @OneToMany(mappedBy = "lop")
    private List<hocSinh> hocSinhs = new ArrayList<>();

    @OneToMany(mappedBy = "lop")
    private List<giangDay> giangDays = new ArrayList<>();

    public lop() {
    }

    public lop(String tenLop, com.pj3.Project3.model.khoa khoa) {
        this.tenLop = tenLop;
        this.khoa = khoa;
    }

    public long getMaLop() {
        return maLop;
    }

    public void setMaLop(long maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public com.pj3.Project3.model.khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(com.pj3.Project3.model.khoa khoa) {
        this.khoa = khoa;
    }




}
