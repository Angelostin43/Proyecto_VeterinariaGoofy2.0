package com.goofy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_veterinario")
public class Veterinarios {
	@Id
	private int id_veterinario;
    private String DNI;
    private String Genero;
    private String Nombre;
    private String Apellido;
    private String Telefono;
}
