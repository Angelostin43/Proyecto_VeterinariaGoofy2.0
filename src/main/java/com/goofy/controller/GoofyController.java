package com.goofy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.goofy.interfaces.ICitasRepository;
import com.goofy.interfaces.IVeterinariosRepository;
import com.goofy.model.Veterinario;

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
	private IVeterinariosRepository repoVet;

	@GetMapping("/InfoMedicos")
	public String cargarInfoMedicos(Model model) {
		model.addAttribute("veterinario", new Veterinario());
		model.addAttribute("lstVets", repoVet.findAll());
		return "InfoMedicos";
	}
	
	@PostMapping("/grabar")
	public String grabarInfoMedicos(Model model, @ModelAttribute Veterinario veterinario) {
		System.out.println(veterinario);
		repoVet.save(veterinario);
		return "redirect:/InfoMedicos";
	}
	
	@GetMapping("/editar/{id_veterinario}")
	public String editar(@PathVariable Integer id_veterinario, Model model) {
		Veterinario v = repoVet.findById(id_veterinario).get();
		model.addAttribute("veterinario", v);
		model.addAttribute("lstVets", repoVet.findAll());
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
