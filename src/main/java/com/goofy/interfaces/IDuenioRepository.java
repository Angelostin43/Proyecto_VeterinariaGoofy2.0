package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.goofy.model.Duenio;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Integer> {
	Duenio findByCorreoAndContraseña(String correo, String contraseña);
}