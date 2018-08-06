package net.thunderfat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.service.IAntecedente_TratamientoService;

@Controller
@RequestMapping(value= "/antecedente_tratamiento")
public class Antecedente_TratamientoController {
	@Autowired
	private IAntecedente_TratamientoService serviceAntecedente_Tratamiento;
	
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model model) {
		List<Antecedente_Tratamiento> listaAntecedentes=serviceAntecedente_Tratamiento.listarAntecedentes_Tratamiento();
		model.addAttribute("antecedente_tratamiento",listaAntecedentes);
		return "antecedente_tratamiento/listAntecedente_Tratamiento";
	}
	@GetMapping("/create")
	public String crear (@ModelAttribute Antecedente_Tratamiento antecedente) {
		
		return "antecedente_tratamiento/formAntecedente_Tratamiento";
	}
	@PostMapping("/save")
	public String guardar(@ModelAttribute Antecedente_Tratamiento antecedente, BindingResult result, Model model,
			RedirectAttributes attributes) {
	
	return  "redirect:/antecedente_tratamiento/index";
	}
	
	

}
