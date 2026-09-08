package com.example.Veterinaria02092026.Controller;

import com.example.Veterinaria02092026.Entity.Propietario;
import com.example.Veterinaria02092026.Service.Implements.PropietarioServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class PropietarioController {

    private final PropietarioServiceImp propietarioServiceImp;

    //Crear

    @PostMapping("/crear")
    public ResponseEntity<Propietario> crearPropietario(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioServiceImp.guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPropietario);
    }
    //Listar
    @GetMapping("/obtener")
    public ResponseEntity<List<Propietario>> obtenerPropietarios() {
        List<Propietario> usuarios = propietarioServiceImp.listarTodos();
        return ResponseEntity.ok(usuarios);
    }
    //Obtener por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<Propietario> obtenerPorId(@PathVariable Long id) {
        Propietario propietario = propietarioServiceImp.buscarPorId(id);
        return ResponseEntity.ok(propietario);
    }
    //Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        propietarioServiceImp.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    //ACTUALIZAR PARCIALMENTE
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizarParcialmente(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario propietarioActualizado = propietarioServiceImp.actualizar(id, propietario);
        return ResponseEntity.ok(propietarioActualizado);
    }
}
