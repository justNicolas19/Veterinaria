package com.example.Veterinaria02092026.Controller;

import com.example.Veterinaria02092026.Entity.Mascota;
import com.example.Veterinaria02092026.Service.Implements.MascotaServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
@AllArgsConstructor
public class MascotaController {

    private final MascotaServiceImp mascotaServiceImp;

    //Crear
    @PostMapping("/crear/{propietarioId}")
    public ResponseEntity<Mascota> crearMascota(@PathVariable Long propietarioId, @RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaServiceImp.guardar(mascota, propietarioId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    //Listar
    @GetMapping("/obtener")
    public ResponseEntity<List<Mascota>> obtenerMascotas() {
        List<Mascota> mascotas = mascotaServiceImp.listarTodas();
        return ResponseEntity.ok(mascotas);
    }

    //Obtener por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
        Mascota mascota = mascotaServiceImp.buscarPorId(id);
        return ResponseEntity.ok(mascota);
    }

    //Listar por Propietario
    @GetMapping("/propietario/{propietarioId}")
    public ResponseEntity<List<Mascota>> obtenerPorPropietario(@PathVariable Long propietarioId) {
        List<Mascota> mascotas = mascotaServiceImp.buscarPorPropietario(propietarioId);
        return ResponseEntity.ok(mascotas);
    }

    //Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaServiceImp.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    //Actualizar parcialmente
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Mascota> actualizarParcialmente(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota mascotaActualizada = mascotaServiceImp.actualizar(id, mascota);
        return ResponseEntity.ok(mascotaActualizada);
    }

    //Asignar veterinario
    @PatchMapping("/{mascotaId}/asignar-veterinario/{veterinarioId}")
    public ResponseEntity<Mascota> asignarVeterinario(@PathVariable Long mascotaId, @PathVariable Long veterinarioId) {
        Mascota mascotaActualizada = mascotaServiceImp.asignarVeterinario(mascotaId, veterinarioId);
        return ResponseEntity.ok(mascotaActualizada);
    }
}