package com.pj3.Project3.repository.admin;

import com.pj3.Project3.dto.giangDayGetAll;
import com.pj3.Project3.model.giangDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IGdRepository extends JpaRepository<giangDay, Long> {
    @Query(value = "SELECT gd.ma_gd, gd.nam_hoc, gd.hoc_ky, gv.ma_gv, gv.ho_ten_gv, mh.ma_mon, mh.ten_mon, l.ma_lop, l.ten_lop, k.ten_khoa, gd.trang_thai, gd.chu_nghiem\n" +
            "FROM lop l\n" +
            "LEFT JOIN giangday gd ON gd.ma_lop = l.ma_lop\n" +
            "LEFT JOIN giaovien gv on gd.ma_gv = gv.ma_gv\n" +
            "LEFT JOIN monhoc mh on gd.ma_mon = mh.ma_mon\n" +
            "LEFT JOIN khoa k ON l.id_khoa = k.id_khoa\n" +
            "ORDER BY chu_nghiem AND nam_hoc DESC", nativeQuery = true)
    List<giangDayGetAll> displayGdAll();

    @Query(value = "SELECT gd.ma_gd, gd.nam_hoc, gd.hoc_ky, gv.ma_gv, gv.ho_ten_gv, mh.ma_mon, mh.ten_mon, l.ma_lop, l.ten_lop, k.ten_khoa, gd.trang_thai, gd.chu_nghiem\n" +
            "FROM giangday gd \n" +
            "INNER JOIN giaovien gv on gd.ma_gv = gv.ma_gv\n" +
            "INNER JOIN monhoc mh on gd.ma_mon = mh.ma_mon\n" +
            "INNER JOIN lop l ON gd.ma_lop = l.ma_lop\n" +
            "INNER JOIN khoa k ON l.id_khoa = k.id_khoa\n" +
            "WHERE l.ma_lop = ?\n" +
            "ORDER BY chu_nghiem AND nam_hoc DESC", nativeQuery = true)
    List<giangDayGetAll> findGdByIdLop(Long id);

    @Query(value = "SELECT gd.ma_gd, gd.nam_hoc, gd.hoc_ky, gv.ma_gv, gv.ho_ten_gv, mh.ma_mon, mh.ten_mon, l.ma_lop, l.ten_lop, k.ten_khoa, gd.trang_thai, gd.chu_nghiem\n" +
            "FROM giangday gd \n" +
            "INNER JOIN giaovien gv on gd.ma_gv = gv.ma_gv\n" +
            "INNER JOIN monhoc mh on gd.ma_mon = mh.ma_mon\n" +
            "INNER JOIN lop l ON gd.ma_lop = l.ma_lop\n" +
            "INNER JOIN khoa k ON l.id_khoa = k.id_khoa\n" +
            "WHERE gd.ma_gd = ?\n" +
            "ORDER BY chu_nghiem AND nam_hoc DESC", nativeQuery = true)
    Optional<giangDayGetAll> findGdById(Long id);
}
