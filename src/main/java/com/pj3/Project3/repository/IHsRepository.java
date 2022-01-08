package com.pj3.Project3.repository;

import com.pj3.Project3.model.hocSinh;
import com.pj3.Project3.dto.hsLopAndKhoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHsRepository extends JpaRepository<hocSinh, Long> {
    @Query(value = "SELECT h.ma_hs,h.ho_ten_hs,h.ngay_sinh,h.gioi_tinh,h.email_hs, h.mat_khau_hs,h.sdt,h.trang_thai,concat(l.ten_lop,k.ten_khoa) as ten_lop FROM hocsinh h INNER JOIN lop l ON h.ma_lop = l.ma_lop INNER JOIN khoa k ON l.id_khoa = k.id_khoa WHERE h.trang_thai=1", nativeQuery = true)
    List<hsLopAndKhoa> displayHs();

    @Query(value = "SELECT h.ma_hs,h.ho_ten_hs,h.ngay_sinh,h.gioi_tinh,h.email_hs, h.mat_khau_hs,h.sdt,h.trang_thai,concat(l.ten_lop,k.ten_khoa) as ten_lop FROM hocsinh h INNER JOIN lop l ON h.ma_lop = l.ma_lop INNER JOIN khoa k ON l.id_khoa = k.id_khoa WHERE h.ma_hs = ?1", nativeQuery = true)
    List<hsLopAndKhoa> displayHsFindById(Long ma_hs);
}
