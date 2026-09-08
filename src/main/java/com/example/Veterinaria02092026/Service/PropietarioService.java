package com.example.Veterinaria02092026.Service;
import java.util.List;
import com.example.Veterinaria02092026.Entity.Propietario;

public interface PropietarioService {

    List<Propietario> listarTodos();

    Propietario buscarPorId(Long id);

    Propietario guardar(Propietario propietario);

    Propietario actualizar(Long id, Propietario propietario);

    void eliminar(Long id);

}
