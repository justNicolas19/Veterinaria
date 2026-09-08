package com.example.Veterinaria02092026.Controller;

import com.example.Veterinaria02092026.Entity.HistoriaClinica;
import com.example.Veterinaria02092026.Service.Implements.HistoriaClinicaServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historia-clinica")
@AllArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaServiceImp historiaClinicaServiceImp;

    //Crear
    @PostMapping("/crear/{mascotaId}")
    public ResponseEntity<HistoriaClinica> crearHistoria(@PathVariable Long mascotaId, @RequestBody HistoriaClinica historia) {
        HistoriaClinica nuevaHistoria = historiaClinicaServiceImp.crear(historia, mascotaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaHistoria);
    }

    //Listar
    @GetMapping("/obtener")
    public ResponseEntity<List<HistoriaClinica>> obtenerHistorias() {
        List<HistoriaClinica> historias = historiaClinicaServiceImp.listarTodas();
        return ResponseEntity.ok(historias);
    }

    //Obtener por Id
    @GetMapping("/listar/{id}")
    public ResponseEntity<HistoriaClinica> obtenerPorId(@PathVariable Long id) {
        HistoriaClinica historia = historiaClinicaServiceImp.buscarPorId(id);
        return ResponseEntity.ok(historia);
    }

    //Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarHistoria(@PathVariable Long id) {
        historiaClinicaServiceImp.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    //Actualizar parcialmente
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizarParcialmente(@PathVariable Long id, @RequestBody HistoriaClinica historia) {
        HistoriaClinica historiaActualizada = historiaClinicaServiceImp.actualizar(id, historia);
        return ResponseEntity.ok(historiaActualizada);
    }
}