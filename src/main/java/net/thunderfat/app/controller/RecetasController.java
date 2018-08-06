package net.thunderfat.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Receta;
import net.thunderfat.app.service.IRecetaService;

@Controller 
@RequestMapping("/receta")
public class RecetasController {
	@Autowired
	private IRecetaService recetasService;
	
	@GetMapping (value="/create")
	public String crear(@ModelAttribute Receta receta ) {
		
		
		return "recetas/formReceta";
		
	}
	@GetMapping(value="/delete/{id}")
	public String borrar (@PathVariable("id") int id_receta, RedirectAttributes attributes) {
		recetasService.eliminar(id_receta);
		attributes.addFlashAttribute("msg", "El Paciente fue eliminada!.");
		return "redirect:/paciente/index";
		
	}
	@PostMapping(value="/save")
	public String guardar(Receta receta) {
		return "recetas/formReceta";
	}

}
