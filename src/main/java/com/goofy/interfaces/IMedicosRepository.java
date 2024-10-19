package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Medicos;

public interface IMedicosRepository extends JpaRepository<Medicos, Integer> {

}
