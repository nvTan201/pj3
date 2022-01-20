package com.pj3.Project3.repository;

import com.pj3.Project3.dto.gvByEmail;
import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.model.giaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGvRepository extends JpaRepository<giaoVien, Long> {
    @Query(value = "SELECT * FROM giaovien g WHERE g.trang_thai = ?1", nativeQuery = true)
    List<giaoVien> displayGvFindById(int trang_thai);

//    @Query(value = "SELECT gv.ma_gv, gv.email_gv, gv.mat_khau_gv, gv.quyen FROM giaovien gv WHERE gv.email_gv = ?1", nativeQuery = true)
    Optional<giaoVien> findByEmailGv(String email);
}
