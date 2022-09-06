package com.pj3.Project3.repository.admin;

import com.pj3.Project3.dto.hsLopAndKhoa;
import com.pj3.Project3.model.monHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMhRepository extends JpaRepository<monHoc, Long> {
    @Query(value = "SELECT monhoc.ma_mon AS \"ma_mon\", monhoc.ten_mon AS \"ten_mon\" FROM giangday\n" +
            "INNER JOIN monhoc on monhoc.ma_mon = giangday.ma_mon\n" +
            "WHERE giangday .ma_lop = ?1 \n" +
            "GROUP BY  monhoc.ma_mon ORDER BY `monhoc`.`ma_mon` DESC", nativeQuery = true)
    List<monHoc> getMonByLop(Long maLop);
}
