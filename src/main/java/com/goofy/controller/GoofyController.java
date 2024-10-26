package com.goofy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goofy.interfaces.ICitasRepository;
import com.goofy.interfaces.IDuenioRepository;
import com.goofy.interfaces.IVeterinarioRepository;
import com.goofy.model.Dueño;
import com.goofy.model.Veterinarios;

@Controller
public class GoofyController {

	@Autowired
	private IVeterinarioRepository repoVet;

	@Autowired
	private IDuenioRepository repoDue;

	@Autowired
	private ICitasRepository repoCit;

	// Login

	@GetMapping("/AccesoSistema")
	public String cargarAccesoSistema(Model model) {
		return "AccesoSistema";
	}

	@PostMapping("/AccesoSistema")
	public String leerSesion(@RequestParam String correo, @RequestParam String contraseña, Model model) {
		Dueño d = repoDue.findByCorreoAndContraseña(correo, contraseña);
		if (d != null) {
			System.out.println("Funciona");
			model.addAttribute("mensaje", "Bienvenido");
			model.addAttribute("cssmensaje", "DueSi");
			return "redirect:/AgendarCita";
		} else {
			System.out.println("No Funciona");
			model.addAttribute("mensaje", "Usuario o clave erroneos");
			model.addAttribute("cssmensaje", "DueNo");
			return "AccesoSistema";
		}
	}

	// Angendar Cita

	@GetMapping("/AgendarCita")
	public String cargarAgendarCita(Model model) {
		model.addAttribute("veterinario", new Veterinarios());
		model.addAttribute("lstVeterinarios", repoVet.findAll());
		return "AgendarCita";
	}

	// Citas

	@GetMapping("/Citas")
	public String cargarCitas(Model model) {
		model.addAttribute("lstCitas", repoCit.findAll());
		return "Citas";
	}

	// InfoMedicos

	@GetMapping("/InfoMedicos")
	public String cargarInfoMedicos(Model model) {
		model.addAttribute("lstMedicos", repoVet.findAll());
		return "InfoMedicos";
	}

	// RegistrarMascota

	@GetMapping("/MascotaRegistro")
	public String cargarMascotasRegistro() {
		return "MascotaRegistro";
	}

	// Perfil

	@GetMapping("/Perfil")
	public String cargarPerfil() {
		return "Perfil";
	}

	// Plantilla

	@GetMapping("/Plantilla")
	public String cargarPlantilla() {
		return "Plantilla";
	}
}
