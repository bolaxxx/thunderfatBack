package net.thunderfat.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.model.Antecedentes_Clinicos;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IAntecedente_ClinicoService;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping("/antecedente_clinico")
public class Antecedentes_ClinicosController {
	@Autowired
	private IAntecedente_ClinicoService serviceAntecedente;
	@Autowired
	private IPacienteService servicePaciente;

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Antecedentes_Clinicos> listaAntecedente = serviceAntecedente.listarAntecedentes();
		model.addAttribute("antecedentes_clinicos", listaAntecedente);
		return "antecedente_clinico/listAntecedente_Clinico";
	}
	@GetMapping(value="/index/{id}")
	public String mostrarIndexPorPaciente(Model model,@PathVariable ("id")int id_paciente) {
		Paciente pacienteBuscado = servicePaciente.buscarPorId(id_paciente);
		List <Antecedentes_Clinicos>antecedentes_clinicos=serviceAntecedente.listarAntecedenteporPaciente(pacienteBuscado);
		String nombre = pacienteBuscado.getNombre()+' ' +pacienteBuscado.getApellidos();
		model.addAttribute("nombre", nombre);
		model.addAttribute("antecedentes_clinicos", antecedentes_clinicos);
		model.addAttribute("paciente", id_paciente);
		return"antecedente_clinico/listAntecedente_Clinico";
	}
	
	@GetMapping(value = "/create/{id}")
	public String crear(Model model, @PathVariable("id") int id_paciente) {
		Antecedentes_Clinicos antecedentes_clinicos= new Antecedentes_Clinicos();
		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		antecedentes_clinicos.setPaciente(paciente);
		
		model.addAttribute("antecedentes_clinicos", antecedentes_clinicos);
		
		return "antecedente_clinico/formAntecedente_Clinico";
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
	public String guardar(@ModelAttribute Antecedentes_Clinicos antecedentes_clinicos, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		antecedentes_clinicos.setPaciente(servicePaciente.buscarPorId(antecedentes_clinicos.getPaciente().getId_usuario()));
		//int idpaciente=(int) model.asMap().get("paciente");
		//antecedentes_clinicos.setPaciente(servicePaciente.buscarPorId(idpaciente));
		serviceAntecedente.insertar(antecedentes_clinicos);

		attributes.addFlashAttribute("msg", "Los datos del antecedente clinico fueron guardados!");
		//attributes.
		return "redirect:/antecedente_clinico/index/"+antecedentes_clinicos.getPaciente().getId_usuario();
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
	public String eliminar(@PathVariable("id") int id_antecedente, RedirectAttributes attributes) {
		int id_paciente = serviceAntecedente.buscarPorID(id_antecedente).getPaciente().getId_usuario();
		serviceAntecedente.eliminar(id_antecedente);
		attributes.addFlashAttribute("msg", "El Antecedente clinico fue eliminado!.");
		return "redirect:/antecedente_clinico/index/"+id_paciente;
	}

	/**
	 * Metodo para mostrar el formulario de Editar
	 * 
	 * @param idNoticia
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_antecedente, Model model) {
		Antecedentes_Clinicos antecedentes_clinicos = serviceAntecedente.buscarPorID(id_antecedente);
		model.addAttribute("antecedentes_clinicos", antecedentes_clinicos);
		return "antecedente_clinico/formAntecedente_Clinico";
	}
	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Antecedentes_Clinicos detallePaciente(@PathVariable ("id") int id_antecedente) {
		return serviceAntecedente.buscarPorID(id_antecedente);
	}
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> antecedente) {
		System.out.println(antecedente);
		Antecedentes_Clinicos pacienteinsert = new Antecedentes_Clinicos();
		if(antecedente.get("id_antecedente").equals("")) {
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(antecedente.get("id_paciente")))); 
			pacienteinsert.setObservacion(antecedente.get("observacion"));
			pacienteinsert.setFecha(LocalDate.parse(antecedente.get("fecha")));
			pacienteinsert.setAntecedente_clinico(antecedente.get("antecedente"));
			
			System.out.println(pacienteinsert);
		serviceAntecedente.insertar(pacienteinsert);
		antecedente.replace("id_antecedente",Integer.toString(pacienteinsert.getId_antecedentes_clinicos()));
		}else {
			pacienteinsert=serviceAntecedente.buscarPorID((Integer.parseInt(antecedente.get("id_antecedente"))));
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(antecedente.get("id_paciente")))); 
			pacienteinsert.setObservacion(antecedente.get("observacion"));
			pacienteinsert.setFecha(LocalDate.parse(antecedente.get("fecha")));
			pacienteinsert.setAntecedente_clinico(antecedente.get("antecedente"));
		
			serviceAntecedente.insertar(pacienteinsert);
		
		
		}
		return antecedente;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_antecedente) {
		 serviceAntecedente.eliminar(id_antecedente);
		return id_antecedente;
	}
}
