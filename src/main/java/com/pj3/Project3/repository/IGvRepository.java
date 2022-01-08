package com.pj3.Project3.repository;

import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.model.giaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGvRepository extends JpaRepository<giaoVien, Long> {
    @Query(value = "SELECT * FROM giaovien g WHERE g.trang_thai = ?1", nativeQuery = true)
    List<giaoVien> displayGvFindById(int trang_thai);
}
