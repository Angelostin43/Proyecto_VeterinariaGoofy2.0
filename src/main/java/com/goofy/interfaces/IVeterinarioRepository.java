package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Veterinarios;

public interface IVeterinarioRepository extends JpaRepository<Veterinarios, Integer> {

}
