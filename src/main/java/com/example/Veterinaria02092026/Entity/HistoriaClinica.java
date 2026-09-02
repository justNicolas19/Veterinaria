package com.example.Veterinaria02092026.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura;

    private String antecedentes;

    private String observaciones;

    @OneToOne
    @JoinColumn(name = "mascota_id", unique = true)
    private Mascota mascota;
}