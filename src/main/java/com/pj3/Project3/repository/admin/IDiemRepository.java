package com.pj3.Project3.repository.admin;

import com.pj3.Project3.dto.hsAndDiem;
import com.pj3.Project3.model.diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IDiemRepository extends JpaRepository<diem, Long> {

    @Query(value = "SELECT hs.ma_hs, hs.ho_ten_hs, hs.ngay_sinh, hs.gioi_tinh,\n" +
            "d.ma_diem, d.diem_ly_thuyet, d.diem_ly_thuyet1, d.diem_thuc_hanh, d.diem_thuc_hanh1, d.diem_tb, d.trang_thai, d.ket_qua \n" +
            "FROM hocsinh hs\n" +
            "LEFT JOIN diem d ON d.ma_hs = hs.ma_hs\n" +
            "WHERE d.ma_diem = ?1", nativeQuery = true)
    Optional<hsAndDiem> findOneDiem(Long ma_diem);



}
