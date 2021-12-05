package com.pj3.Project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pj3.Project3.model.Gv;

@Repository
public interface IGvRepository extends JpaRepository<Gv, Long> {
}
