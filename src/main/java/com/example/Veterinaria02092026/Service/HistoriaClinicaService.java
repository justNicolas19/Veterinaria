package com.example.Veterinaria02092026.Service;

import com.example.Veterinaria02092026.Entity.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodas();

    HistoriaClinica buscarPorId(Long id);

    HistoriaClinica crear(HistoriaClinica historia, Long mascotaId);

    HistoriaClinica actualizar(Long id, HistoriaClinica historia);

    void eliminar(Long id);
}
