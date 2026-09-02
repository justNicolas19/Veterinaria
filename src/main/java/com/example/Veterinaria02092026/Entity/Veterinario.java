package com.example.Veterinaria02092026.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "veterinario")
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La tarjeta profesional es obligatoria")
    @Column(unique = true)
    private String tarjetaProfesional;

    private String especialidad;

    @NotBlank(message = "El correo es obligatorio")
    @Email
    @Column(unique = true)
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;
}