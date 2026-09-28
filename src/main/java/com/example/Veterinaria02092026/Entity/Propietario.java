package com.example.Veterinaria02092026.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "propietario")
@Data
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Column(unique = true)
    private String documento;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @OneToMany(mappedBy = "propietario")
    @JsonIgnore
    private List<Mascota> mascotas;
}