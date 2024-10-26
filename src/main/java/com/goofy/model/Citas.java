package com.goofy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_ficha_atencion")
public class Citas {
	@Id
	private int id_ficha;
    private String fech_cita;
    private int id_mascota;
    private int id_veterinario;
    
    @ManyToOne
	@JoinColumn(name = "id_mascota",
	insertable = false, updatable = false)
	private Mascota objMascota;
    
    @ManyToOne
	@JoinColumn(name = "id_veterinario",
	insertable = false, updatable = false)
	private Veterinario objVet;
}
