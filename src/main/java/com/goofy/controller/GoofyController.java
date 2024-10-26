package com.goofy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goofy.interfaces.ICitasRepository;
import com.goofy.interfaces.IDuenoRepository;
import com.goofy.interfaces.IMascotaRepository;
import com.goofy.interfaces.IMedicosRepository;
import com.goofy.model.Dueño;
import com.goofy.model.Mascota;

import jakarta.servlet.http.HttpSession;

@Controller
public class GoofyController {
	 @Autowired
	    private IDuenoRepository repoDueño;
	@GetMapping("/AccesoSistema")
	public String cargarAccesoSistema() {
		return "AccesoSistema";
	}
	@PostMapping("/login")
	public String iniciarSesion(@RequestParam("correo") String correo, 
	                            @RequestParam("contraseña") String contraseña, 
	                            HttpSession session, 
	                            Model model) {
	    Dueño usuarioLogueado = repoDueño.findByCorreoAndContraseña(correo, contraseña);
        System.out.println("Usuario logueado: " + usuarioLogueado);

	    
	    if (usuarioLogueado != null) {
	        session.setAttribute("usuarioLogueado", usuarioLogueado);
	        model.addAttribute("usuarioLogueado", usuarioLogueado);
	        return "Perfil"; // Redirige a la vista Perfil
	    } else {
	        model.addAttribute("error", "Correo o contraseña incorrectos");
	        return "AccesoSistema"; // Muestra mensaje de error
	    }
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
	@Autowired
	private IMascotaRepository repoMascota;
	
	@PostMapping("/actualizarPerfil")
	public String actualizarPerfil(@ModelAttribute Dueño dueñoActualizado, HttpSession session) {
	    Dueño usuarioActual = (Dueño) session.getAttribute("usuarioLogueado");
	    if (usuarioActual != null) {
	        usuarioActual.setNombre(dueñoActualizado.getNombre());
	        usuarioActual.setApellido(dueñoActualizado.getApellido());
	        usuarioActual.setTelefono(dueñoActualizado.getTelefono());
	        usuarioActual.setCorreo(dueñoActualizado.getCorreo());
	        
	        repoDueño.save(usuarioActual);
	        session.setAttribute("usuarioLogueado", usuarioActual);
	    }
	    return "redirect:/Perfil";
	}


}
