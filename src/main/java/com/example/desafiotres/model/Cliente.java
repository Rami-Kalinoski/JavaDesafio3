package com.example.desafiotres.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table (name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column (name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    //@Transient
    private int edad;
}