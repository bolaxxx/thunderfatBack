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
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private IPacienteService servicePaciente;
	
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Paciente> listaPacientes = servicePaciente.ListarPaciente();
		model.addAttribute("paciente", listaPacientes);
		return "pacientes/listPaciente";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Alimento alimento) {
		return "pacientes/formPaciente";
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
	public String guardar(@ModelAttribute Paciente paciente, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		servicePaciente.insertar(paciente);
		attributes.addFlashAttribute("msg", "Los datos del Paciente fueron guardados!");
		return "redirect:/pacientes/index";
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
		servicePaciente.eliminar(id_alimento);
		attributes.addFlashAttribute("msg", "El Paciente fue eliminada!.");
		return "redirect:/pacientes/index";
	}

	/**
	 * Metodo para mostrar el formulario de Editar
	 * 
	 * @param idNoticia
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_paciente, Model model) {
		Paciente paciente= servicePaciente.buscarPorId(id_paciente);
		model.addAttribute("paciente", paciente);
		return "pacientes/formPaciente";
	}

	@GetMapping (value="/{id}/index")
	public String listarPacientesPorNutri(@PathVariable("id") int id_nutricionista, Model modelo) {
		
//		List <Paciente>lista = servicePaciente.listarPorNutricionista(id_nutricionista);
//		modelo.addAttribute("pacientes", lista);
		return "pacientes/listPaciente";
		}

}
