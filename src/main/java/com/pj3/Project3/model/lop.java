package com.pj3.Project3.model;

import javax.persistence.*;

@Entity
@Table(name = "lop")
public class lop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maLop;

    @Column(name = "tenLop")
    private String tenLop;

    @Column(name = "khoa")
//    @OneToMany
//    @JoinColumn(name = "khoa")
    private int khoa;

//    @ManyToOne
//    @JoinColumn(name = "idKhoa")
//    khoa Khoa;

    public lop() {
    }

    public lop(String tenLop, int khoa) {

        this.tenLop = tenLop;
        this.khoa = khoa;
    }

    public Long getMaLop() {
        return maLop;
    }

    public void setMaLop(Long maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }
}
