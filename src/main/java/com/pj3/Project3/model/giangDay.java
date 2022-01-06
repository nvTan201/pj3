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
}
