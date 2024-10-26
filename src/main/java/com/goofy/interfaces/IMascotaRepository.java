package com.goofy.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goofy.model.Mascota;
	public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {
	    List<Mascota> findByDueño_Id(int id);
	    }
