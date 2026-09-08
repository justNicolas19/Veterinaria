package com.example.Veterinaria02092026.Repository;

import com.example.Veterinaria02092026.Entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}