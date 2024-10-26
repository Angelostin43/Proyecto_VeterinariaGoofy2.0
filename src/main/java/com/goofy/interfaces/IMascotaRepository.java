package com.goofy.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Mascota;


public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {

}
