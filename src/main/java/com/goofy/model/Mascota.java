package com.goofy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private int id;
    private int Edad;
    private double Peso;
    private String Nombre;
    private String Raza;
    private String Sexo;
    
    @Column(name = "id_dueño", insertable = false, updatable = false)
    public int id_dueño;
    
    @ManyToOne
    @JoinColumn(name = "id_dueño")
    public Duenio dueño;
}
