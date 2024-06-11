package com.example.connect_health.repository;

import com.example.connect_health.model.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity,Long> {
    List<ConsultaEntity> findAllByOrderByDataAsc();
}
