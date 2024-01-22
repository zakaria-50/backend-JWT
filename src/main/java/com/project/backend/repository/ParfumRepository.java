package com.project.backend.repository;

import com.project.backend.entities.Parfum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
}
