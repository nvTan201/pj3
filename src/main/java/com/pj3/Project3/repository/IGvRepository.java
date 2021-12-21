package com.pj3.Project3.repository;

import com.pj3.Project3.model.giaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IGvRepository extends JpaRepository<giaoVien, Long> {

}
