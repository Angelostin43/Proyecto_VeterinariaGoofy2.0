package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.goofy.model.Dueño;

@Repository
public interface IDuenioRepository extends JpaRepository<Dueño, Integer> {
	Dueño findByCorreoAndContraseña(String correo, String contraseña);
}