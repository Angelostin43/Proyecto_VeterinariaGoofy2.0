package com.goofy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_veterinario")
public class Veterinario {
	@Id
	private int id_veterinario;
    private String dni;
    private String genero;
    private String nombre;
    private String apellido;
    private String telefono;
}
