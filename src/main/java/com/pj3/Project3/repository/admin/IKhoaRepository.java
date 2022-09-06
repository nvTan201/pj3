package com.pj3.Project3.repository.admin;

import com.pj3.Project3.dto.LopAndKhoa;
import com.pj3.Project3.model.khoa;
import com.pj3.Project3.model.monHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhoaRepository extends JpaRepository<khoa, Long> {

    @Query(value ="SELECT * FROM `khoa` ORDER BY `khoa`.`id_khoa` DESC", nativeQuery = true)
    List<khoa> getAllKhoadb();

    @Query(value ="SELECT * FROM `khoa` WHERE id_khoa =?1", nativeQuery = true)
    List<khoa> displayKhoaById(Long id);

}
