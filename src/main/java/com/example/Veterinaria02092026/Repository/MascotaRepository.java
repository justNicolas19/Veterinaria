package com.example.Veterinaria02092026.Repository;

import com.example.Veterinaria02092026.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByPropietarioId(Long propietarioId);
}