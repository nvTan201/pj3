package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="khoa")
public class khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ManyToOne
//    @JoinColumn(name = "idKhoa")
    private long idKhoa;

    @Column(name = "tenKhoa")
    private String tenKhoa;

//    @OneToMany
//    @JoinColumn(name = "khoa")
//    List<lop> Lop;

    public khoa() {
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


    public khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
