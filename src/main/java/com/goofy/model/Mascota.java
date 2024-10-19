package com.goofy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Mascota")
public class Mascota {
	@Id
	private int id_mascota;
    private int Edad;
    private double Peso;
    private String Nombre;
    private String Raza;
    private String Sexo;
    private int id_dueño;
}
