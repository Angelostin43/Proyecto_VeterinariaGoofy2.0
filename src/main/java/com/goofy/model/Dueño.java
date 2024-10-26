package com.goofy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_dueño")
public class Dueño {
	@Id
	private int id_dueño;
	private int dni;
	private String genero;
	private String nombre;
	private String apellido;
	private int telefono;
	private String correo;
	private String contraseña;
}
