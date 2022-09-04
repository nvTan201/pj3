package com.pj3.Project3.repository.admin;

import com.pj3.Project3.dto.hsAndDiem;
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

    @Query(value = "SELECT h.ma_hs,h.ho_ten_hs,h.ngay_sinh,h.gioi_tinh,h.email_hs, h.mat_khau_hs,h.sdt,h.trang_thai,concat(l.ten_lop,k.ten_khoa) as ten_lop FROM hocsinh h INNER JOIN lop l ON h.ma_lop = l.ma_lop INNER JOIN khoa k ON l.id_khoa = k.id_khoa WHERE h.ma_lop = ?1", nativeQuery = true)
    List<hsLopAndKhoa> findByIdLop(Long maLop);

    @Query(value = "SELECT hs.ma_hs, hs.ho_ten_hs, hs.ngay_sinh, hs.gioi_tinh,\n" +
            "d.ma_diem, d.diem_ly_thuyet, d.diem_ly_thuyet1, d.diem_thuc_hanh, d.diem_thuc_hanh1, d.diem_tb, d.trang_thai, d.ket_qua \n" +
            "FROM hocsinh hs\n" +
            "LEFT JOIN diem d ON d.ma_hs = hs.ma_hs\n" +
            "WHERE hs.ma_lop = ?1", nativeQuery = true)
    List<hsAndDiem> findByHs(Long maLop);

    @Query(value = "SELECT d.diem_ly_thuyet,d.diem_ly_thuyet1,d.diem_thuc_hanh,d.diem_thuc_hanh1,d.diem_tb,d.ket_qua,d.ma_hs,d.ma_gd AS maGd, hs.ho_ten_hs,gd.ma_gd as ma_gd FROM diem d INNER JOIN giangday gd ON d.ma_gd = gd.ma_gd " +
            "INNER JOIN hocsinh hs ON hs.ma_hs = d.ma_hs WHERE gd.ma_lop = ?1 AND gd.ma_mon = ?2", nativeQuery = true)
    List<hsAndDiem> findHsByMon(Long lop,Long mon);
}
