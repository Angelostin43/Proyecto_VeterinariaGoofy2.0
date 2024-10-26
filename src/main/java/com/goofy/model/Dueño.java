package com.goofy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "tb_dueño")
public class Dueño {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dni")

    private String dni;

    private String genero;

    private String nombre;

    private String apellido;

    private String telefono;

    private String correo;

    private String contraseña;
    }