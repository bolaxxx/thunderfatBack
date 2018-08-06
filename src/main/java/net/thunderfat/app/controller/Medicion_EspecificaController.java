package net.thunderfat.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicion_especifica")

public class Medicion_EspecificaController {
	
	
	@RequestMapping(value="/index")
	public String listarMedicionesEspecifica() {
		
		return "medicion_especifica/formMedicion_Especifica";
	}

}
