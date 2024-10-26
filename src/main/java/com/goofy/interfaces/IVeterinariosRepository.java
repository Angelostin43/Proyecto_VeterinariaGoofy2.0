package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Veterinario;

public interface IVeterinariosRepository extends JpaRepository<Veterinario, Integer> {

}
