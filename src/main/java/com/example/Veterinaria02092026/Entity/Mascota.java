package com.example.Veterinaria02092026.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import lombok.Data;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.List;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    private String especie;

    private String raza;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    @Min(value = 0, message = "El peso no puede ser negativo")
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToOne(mappedBy = "mascota")
    @JsonIgnore
    private HistoriaClinica historiaClinica;

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    private List<Veterinario> veterinarios;
}