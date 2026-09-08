package com.example.Veterinaria02092026.Service.Implements;

import com.example.Veterinaria02092026.Entity.Mascota;
import com.example.Veterinaria02092026.Entity.Propietario;
import com.example.Veterinaria02092026.Entity.Veterinario;
import com.example.Veterinaria02092026.Exception.ResourceNotFoundException;
import com.example.Veterinaria02092026.Repository.MascotaRepository;
import com.example.Veterinaria02092026.Repository.PropietarioRepository;
import com.example.Veterinaria02092026.Repository.VeterinarioRepository;
import com.example.Veterinaria02092026.Service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MascotaServiceImp implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota buscarPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mascota no encontrada: " + id));
    }

    @Override
    @Transactional
    public Mascota guardar(Mascota mascota, Long propietarioId) {
        Propietario propietario = propietarioRepository
                .findById(propietarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Propietario no encontrado"));

        mascota.setPropietario(propietario);

        return mascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public Mascota actualizar(Long id, Mascota datos) {
        Mascota actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setEspecie(datos.getEspecie());
        actual.setRaza(datos.getRaza());
        actual.setEdad(datos.getEdad());
        actual.setPeso(datos.getPeso());

        return mascotaRepository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        mascotaRepository.delete(buscarPorId(id));
    }

    @Override
    public List<Mascota> buscarPorPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    @Override
    @Transactional
    public Mascota asignarVeterinario(Long mascotaId, Long veterinarioId) {
        Mascota mascota = buscarPorId(mascotaId);

        Veterinario veterinario = veterinarioRepository
                .findById(veterinarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Veterinario no encontrado"));

        mascota.getVeterinarios().add(veterinario);

        return mascotaRepository.save(mascota);
    }
}