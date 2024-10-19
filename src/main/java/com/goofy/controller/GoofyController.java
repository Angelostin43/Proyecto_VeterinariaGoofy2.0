package com.goofy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goofy.interfaces.ICitasRepository;
import com.goofy.interfaces.IMedicosRepository;

@Controller
public class GoofyController {

	@GetMapping("/AccesoSistema")
	public String cargarAccesoSistema() {
		return "AccesoSistema";
	}

	@GetMapping("/AgendarCita")
	public String cargarAgendarCita() {
		return "AgendarCita";
	}

	@Autowired
	private ICitasRepository repoCit;

	@GetMapping("/Citas")
	public String cargarCitas(Model model) {
		model.addAttribute("lstCitas", repoCit.findAll());
		return "Citas";
	}

	@Autowired
	private IMedicosRepository repoMed;

	@GetMapping("/InfoMedicos")
	public String cargarInfoMedicos(Model model) {
		model.addAttribute("lstMedicos", repoMed.findAll());
		return "InfoMedicos";
	}

	@GetMapping("/MascotaRegistro")
	public String cargarMascotasRegistro() {
		return "MascotaRegistro";
	}

	@GetMapping("/Perfil")
	public String cargarPerfil() {
		return "Perfil";
	}
}
