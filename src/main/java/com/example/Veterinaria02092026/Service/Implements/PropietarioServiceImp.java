package com.example.Veterinaria02092026.Service.Implements;
import com.example.Veterinaria02092026.Entity.Propietario;
import com.example.Veterinaria02092026.Exception.ResourceNotFoundException;
import com.example.Veterinaria02092026.Repository.PropietarioRepository;
import com.example.Veterinaria02092026.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PropietarioServiceImp implements PropietarioService {

    private final PropietarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Propietario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietario buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Propietario no encontrado: " + id));
    }

    @Override
    @Transactional
    public Propietario guardar(
            Propietario propietario
    ) {
        return repository.save(propietario);
    }

    @Override
    @Transactional
    public Propietario actualizar(
            Long id,
            Propietario datos
    ) {

        Propietario actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setDocumento(datos.getDocumento());
        actual.setTelefono(datos.getTelefono());

        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        Propietario propietario =
                buscarPorId(id);

        repository.delete(propietario);
    }
}