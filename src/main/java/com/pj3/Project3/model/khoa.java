package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "khoa")
    private List<lop> lop = new ArrayList<>();

    public khoa() {
    }

    public khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
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

}
