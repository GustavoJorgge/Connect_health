package com.example.connect_health.repository;

import com.example.connect_health.model.ExameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<ExameEntity,Long> {
}
