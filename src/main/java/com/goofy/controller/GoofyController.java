package com.goofy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/Citas")
    public String cargarCitas() {
        return "Citas";
    }

    @GetMapping("/InfoMedicos")
    public String cargarInfoMedicos() {
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
