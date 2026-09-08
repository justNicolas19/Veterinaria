package com.example.Veterinaria02092026.Service;

import com.example.Veterinaria02092026.Entity.Mascota;

import java.util.List;

public interface MascotaService {

    List<Mascota> listarTodas();

    Mascota buscarPorId(Long id);

    Mascota guardar(Mascota mascota, Long propietarioId);

    Mascota actualizar(Long id, Mascota datos);

    void eliminar(Long id);

    List<Mascota> buscarPorPropietario(Long propietarioId);

    Mascota asignarVeterinario(Long mascotaId, Long veterinarioId);
}