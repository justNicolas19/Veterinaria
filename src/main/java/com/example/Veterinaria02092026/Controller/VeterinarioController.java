package com.example.Veterinaria02092026.Controller;

import com.example.Veterinaria02092026.Entity.Veterinario;
import com.example.Veterinaria02092026.Service.Implements.VeterinarioServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinario")
@AllArgsConstructor
public class VeterinarioController {

    private final VeterinarioServiceImp veterinarioServiceImp;

    //Crear
    @PostMapping("/crear")
    public ResponseEntity<Veterinario> crearVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario nuevoVeterinario = veterinarioServiceImp.guardar(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVeterinario);
    }

    //Listar
    @GetMapping("/obtener")
    public ResponseEntity<List<Veterinario>> obtenerVeterinarios() {
        List<Veterinario> veterinarios = veterinarioServiceImp.listarTodos();
        return ResponseEntity.ok(veterinarios);
    }

    //Obtener por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Long id) {
        Veterinario veterinario = veterinarioServiceImp.buscarPorId(id);
        return ResponseEntity.ok(veterinario);
    }

    //Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long id) {
        veterinarioServiceImp.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    //Actualizar parcialmente
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Veterinario> actualizarParcialmente(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        Veterinario veterinarioActualizado = veterinarioServiceImp.actualizar(id, veterinario);
        return ResponseEntity.ok(veterinarioActualizado);
    }
}