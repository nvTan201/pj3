package com.pj3.Project3.repository;

import com.pj3.Project3.model.lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILopRepository extends JpaRepository<lop, Long> {
}
