package com.example.Veterinaria02092026.Repository;

import com.example.Veterinaria02092026.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}