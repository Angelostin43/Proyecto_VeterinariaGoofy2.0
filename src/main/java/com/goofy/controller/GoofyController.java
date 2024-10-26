package com.goofy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goofy.interfaces.ICitasRepository;
import com.goofy.interfaces.IDuenioRepository;
import com.goofy.interfaces.IMascotaRepository;
import com.goofy.interfaces.IVeterinariosRepository;
import com.goofy.model.Duenio;
import com.goofy.model.Veterinario;

import jakarta.servlet.http.HttpSession;


@Controller
public class GoofyController {

	@Autowired
	private IVeterinariosRepository repoVet;

	@Autowired
	private IDuenioRepository repoDue;

	@Autowired
	private ICitasRepository repoCit;
	
	@GetMapping("/AccesoSistema")
	public String cargarAccesoSistema(Model model) {
		return "AccesoSistema";
	}

	@PostMapping("/AccesoSistema")
	public String leerSesion(@RequestParam String correo, @RequestParam String contraseña, Model model) {
		Duenio d = repoDue.findByCorreoAndContraseña(correo, contraseña);
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

	@GetMapping("/AgendarCita")
	public String cargarAgendarCita(Model model) {
		model.addAttribute("veterinario", new Veterinario());
		model.addAttribute("lstVeterinarios", repoVet.findAll());
		return "AgendarCita";
	}


	@GetMapping("/Citas")
	public String cargarCitas(Model model) {
		model.addAttribute("lstCitas", repoCit.findAll());
		return "Citas";
	}
	
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
	@Autowired
	private IMascotaRepository repoMascota;
	
	@PostMapping("/actualizarPerfil")
	public String actualizarPerfil(@ModelAttribute Duenio dueñoActualizado, HttpSession session) {
	    Duenio usuarioActual = (Duenio) session.getAttribute("usuarioLogueado");
	    if (usuarioActual != null) {
	        usuarioActual.setNombre(dueñoActualizado.getNombre());
	        usuarioActual.setApellido(dueñoActualizado.getApellido());
	        usuarioActual.setTelefono(dueñoActualizado.getTelefono());
	        usuarioActual.setCorreo(dueñoActualizado.getCorreo());
	        
	        repoDue.save(usuarioActual);
	        session.setAttribute("usuarioLogueado", usuarioActual);
	    }
	    return "redirect:/Perfil";
	}


}
