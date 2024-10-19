package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Citas;

public interface ICitasRepository extends JpaRepository<Citas, Integer> {

}
