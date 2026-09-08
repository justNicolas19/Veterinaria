package com.example.Veterinaria02092026.Service;

import com.example.Veterinaria02092026.Entity.Veterinario;

import java.util.List;

public interface VeterinarioService {

    List<Veterinario> listarTodos();

    Veterinario buscarPorId(Long id);

    Veterinario guardar(Veterinario veterinario);

    Veterinario actualizar(Long id, Veterinario veterinario);

    void eliminar(Long id);

}
