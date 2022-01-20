package com.pj3.Project3.repository;

import com.pj3.Project3.model.giangDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGdRepository extends JpaRepository<giangDay, Long> {
}
