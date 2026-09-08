package com.example.Veterinaria02092026.Service.Implements;

import com.example.Veterinaria02092026.Entity.Veterinario;
import com.example.Veterinaria02092026.Exception.ResourceNotFoundException;
import com.example.Veterinaria02092026.Repository.VeterinarioRepository;
import com.example.Veterinaria02092026.Service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioServiceImp implements VeterinarioService {

    private final VeterinarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Veterinario no encontrado: " + id));
    }

    @Override
    @Transactional
    public Veterinario guardar(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    @Transactional
    public Veterinario actualizar(Long id, Veterinario datos) {
        Veterinario actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setTarjetaProfesional(datos.getTarjetaProfesional());
        actual.setEspecialidad(datos.getEspecialidad());
        actual.setCorreo(datos.getCorreo());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.delete(buscarPorId(id));
    }
}