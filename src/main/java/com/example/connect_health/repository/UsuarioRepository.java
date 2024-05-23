package com.example.connect_health.repository;

import com.example.connect_health.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
