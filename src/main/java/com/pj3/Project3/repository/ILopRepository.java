package com.pj3.Project3.repository;

import com.pj3.Project3.model.lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILopRepository extends JpaRepository<lop, Long> {
    @Query(value = "SELECT * FROM lop INNER JOIN khoa ON lop.khoa = khoa.id_khoa", nativeQuery = true)
    List<lop> findAllLop();

}
