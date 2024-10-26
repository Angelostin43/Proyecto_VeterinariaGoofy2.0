package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Dueño;

public interface IDuenoRepository extends JpaRepository<Dueño, Integer> {
	  Dueño findByCorreoAndContraseña(String correo, String contraseña);
}
