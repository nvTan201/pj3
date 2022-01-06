package com.pj3.Project3.repository;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILopRepository extends JpaRepository<lop, Long> {

    @Query(value = "SELECT l.ma_lop,l.ten_lop,k.ten_khoa FROM `lop` l INNER JOIN khoa k ON l.id_khoa = k.id_khoa;",nativeQuery = true)
    List<LopAndKhoa> displayLopById();
}
