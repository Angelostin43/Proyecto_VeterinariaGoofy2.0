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
import com.goofy.model.Mascota;
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
	@Autowired
	private IMascotaRepository repoMas;
	
	@GetMapping("/AccesoSistema")
	public String cargarAccesoSistema(Model model) {
		return "AccesoSistema";
	}


	@PostMapping("/login")
	public String iniciarSesion(@RequestParam("correo") String correo, 
	                            @RequestParam("contraseña") String contraseña, 
	                            HttpSession session, 
	                            Model model) {
	    Duenio usuarioLogueado = repoDue.findByCorreoAndContraseña(correo, contraseña);
	    System.out.println("Usuario logueado: " + usuarioLogueado);

	    if (usuarioLogueado != null) {
	        session.setAttribute("usuarioLogueado", usuarioLogueado);
	        model.addAttribute("usuarioLogueado", usuarioLogueado); 
	        return "Perfil"; 
	    } else {
	        model.addAttribute("error", "Correo o contraseña incorrectos");
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
	   @GetMapping("/mascotasLista")
	    public String listarMascotas(@RequestParam("idDueno") int idDueno, Model model) {
		    System.out.println("IDDUeño"+idDueno);
	        List<Mascota> mascotas = repoMas.findByDueño_Id(idDueno); 
	        model.addAttribute("mascotas", mascotas);
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
