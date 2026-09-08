package com.example.Veterinaria02092026.Service.Implements;

import com.example.Veterinaria02092026.Entity.HistoriaClinica;
import com.example.Veterinaria02092026.Entity.Mascota;
import com.example.Veterinaria02092026.Exception.ResourceNotFoundException;
import com.example.Veterinaria02092026.Repository.HistoriaClinicaRepository;
import com.example.Veterinaria02092026.Repository.MascotaRepository;
import com.example.Veterinaria02092026.Service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor

public class HistoriaClinicaServiceImp implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaRepository;
    private final MascotaRepository mascotaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<HistoriaClinica> listarTodas() {
        return historiaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HistoriaClinica buscarPorId(Long id) {
        return historiaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Historia clínica no encontrada: " + id));
    }

    @Override
    @Transactional
    public HistoriaClinica crear(HistoriaClinica historia, Long mascotaId) {
        Mascota mascota = mascotaRepository
                .findById(mascotaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mascota no encontrada: " + mascotaId));

        historia.setMascota(mascota);

        return historiaRepository.save(historia);
    }

    @Override
    @Transactional
    public HistoriaClinica actualizar(Long id, HistoriaClinica datos) {
        HistoriaClinica actual = buscarPorId(id);

        actual.setFechaApertura(datos.getFechaApertura());
        actual.setAntecedentes(datos.getAntecedentes());
        actual.setObservaciones(datos.getObservaciones());

        return historiaRepository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        historiaRepository.delete(buscarPorId(id));
    }
}