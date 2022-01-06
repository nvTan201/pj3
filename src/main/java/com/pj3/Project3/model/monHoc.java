package com.pj3.Project3.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "monhoc")
public class monHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maMon;

    @Column(name = "tenMon")
    private String tenMon;

    @OneToMany(mappedBy = "monHoc")
    private List<giangDay> giangDays = new ArrayList<>();

    public monHoc() {
    }

    public monHoc(String tenMon) {
        this.tenMon = tenMon;
    }

    public long getMaMon() {
        return maMon;
    }

    public void setMaMon(long maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
}
