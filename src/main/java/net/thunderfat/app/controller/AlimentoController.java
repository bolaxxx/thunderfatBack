package net.thunderfat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.service.IAlimentoService;

@Controller
@RequestMapping(value= "/alimento")
public class AlimentoController {
	@Autowired
	private IAlimentoService serviceAlimento;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Alimento> listaAlimentos = serviceAlimento.ListarAlimentos();
		model.addAttribute("alimentos", listaAlimentos);
		return "alimento/listAlimento";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Alimento alimento) {
		return "alimento/formAlimento";
	}

	/**
	 * Metodo para guardar el registro de la Noticia
	 * 
	 * @param noticia
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Alimento alimento, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		serviceAlimento.insertar(alimento);
		attributes.addFlashAttribute("msg", "Los datos del alimento  fueron guardados!");
		return "redirect:/alimento/index";
	}

	/**
	 * Metodo para eliminar una noticia
	 * 
	 * @param idNoticia
	 * @param model
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_alimento, RedirectAttributes attributes) {
		serviceAlimento.eliminar(id_alimento);
		attributes.addFlashAttribute("msg", "La noticia fue eliminada!.");
		return "redirect:/alimento/index";
	}

	/**
	 * Metodo para mostrar el formulario de Editar
	 * 
	 * @param idNoticia
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_alimento, Model model) {
		Alimento alimento= serviceAlimento.buscarPorId(id_alimento);
		model.addAttribute("alimento", alimento);
		return "alimento/formAlimento";
	}


}
