package net.thunderfat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.service.ICitaService;

@Controller
@RequestMapping(value ="/cita")
public class CitaController {
	@Autowired
	private ICitaService serviceCita;
	
	@GetMapping(value="/index")
	public String mostrarCita(Model modelo) {
		List<Cita>citas=serviceCita.ListarCita();
		
		modelo.addAttribute("citas",citas );
		
	return "cita/listCita";
	}
	

}
