package com.goofy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_dueño")
public class Duenio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dueño")
	private int id;
	private int dni;
	private String genero;
	private String nombre;
	private String apellido;
	private int telefono;
	private String correo;
	private String contraseña;
}