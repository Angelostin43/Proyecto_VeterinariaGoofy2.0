package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Veterinarios;

public interface IMedicosRepository extends JpaRepository<Veterinarios, Integer> {

}
