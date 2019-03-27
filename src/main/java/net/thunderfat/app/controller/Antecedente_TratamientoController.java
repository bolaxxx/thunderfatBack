package net.thunderfat.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Antecedente_Tratamiento;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IAntecedente_TratamientoService;
import net.thunderfat.app.service.IPacienteService;
@CrossOrigin
@Controller
@RequestMapping(value= "/antecedente_tratamiento")
public class Antecedente_TratamientoController {
	@Autowired
	private IAntecedente_TratamientoService serviceAntecedente_Tratamiento;
	@Autowired
	private IPacienteService servicePaciente;
	
	@GetMapping(value="/index/{id}")
	public String mostrarIndex(Model model,@PathVariable("id")int id_paciente) {
		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		List<Antecedente_Tratamiento> listaAntecedentes=serviceAntecedente_Tratamiento.buscarPorPaciente(id_paciente);
		model.addAttribute("antecedentes_tratamientos",listaAntecedentes);
		model.addAttribute("paciente", paciente);
		return "antecedente_tratamiento/listAntecedente_Tratamiento";
	}
	@GetMapping("/create/{id}")
	public String crear (Model model,@PathVariable ("id")int id_paciente) {
		Antecedente_Tratamiento antecedente = new Antecedente_Tratamiento();
		Paciente paciente= servicePaciente.buscarPorId(id_paciente);
		antecedente.setPaciente(paciente);
		model.addAttribute("paciente", paciente);
		model.addAttribute("antecedente_tratamiento", antecedente);
		return "antecedente_tratamiento/formAntecedente_Tratamiento";
	}
	@PostMapping("/save")
	public String guardar(@ModelAttribute Antecedente_Tratamiento antecedente_tratamiento, BindingResult result, Model model,
			RedirectAttributes attributes) {
		antecedente_tratamiento.setPaciente(servicePaciente.buscarPorId(antecedente_tratamiento.getPaciente().getId_usuario()));
		serviceAntecedente_Tratamiento.insertar(antecedente_tratamiento);
	
	return  "redirect:/antecedente_tratamiento/index/"+antecedente_tratamiento.getPaciente().getId_usuario();
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_antecedente, RedirectAttributes attributes) {
		int id_paciente = serviceAntecedente_Tratamiento.buscarPorId(id_antecedente).getPaciente().getId_usuario();
		serviceAntecedente_Tratamiento.eliminar(id_antecedente);
		attributes.addFlashAttribute("msg", "El Antecedente de Tratamiento fue eliminado!.");
		return "redirect:/antecedente_tratamiento/index/"+id_paciente;
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
		Antecedente_Tratamiento antecedente_tratamiento = serviceAntecedente_Tratamiento.buscarPorId(id_antecedente);
		model.addAttribute("antecedente_tratamiento", antecedente_tratamiento);
		return "antecedente_tratamiento/formAntecedente_Tratamiento";
	}
	
	
	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Antecedente_Tratamiento detallePaciente(@PathVariable ("id") int id_antecedente) {
		return serviceAntecedente_Tratamiento.buscarPorId(id_antecedente);
	}
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> antecedente) {
		System.out.println(antecedente);
		Antecedente_Tratamiento pacienteinsert = new Antecedente_Tratamiento();
		if(antecedente.get("id_antecedente").equals("")) {
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(antecedente.get("id_paciente")))); 
			pacienteinsert.setObservacion(antecedente.get("observacion"));
			pacienteinsert.setFecha(LocalDate.parse(antecedente.get("fecha")));
			pacienteinsert.setAntecedente(antecedente.get("antecedente"));
			
			System.out.println(pacienteinsert);
		serviceAntecedente_Tratamiento.insertar(pacienteinsert);
		antecedente.replace("id_antecedente",Integer.toString(pacienteinsert.getId_antecedente_tratamiento()));
		}else {
			pacienteinsert=serviceAntecedente_Tratamiento.buscarPorId((Integer.parseInt(antecedente.get("id_antecedente"))));
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(antecedente.get("id_paciente")))); 
			pacienteinsert.setObservacion(antecedente.get("observacion"));
			pacienteinsert.setFecha(LocalDate.parse(antecedente.get("fecha")));
			pacienteinsert.setAntecedente(antecedente.get("antecedente"));
		
			serviceAntecedente_Tratamiento.insertar(pacienteinsert);
		
		
		}
		return antecedente;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_antecedente) {
		 serviceAntecedente_Tratamiento.eliminar(id_antecedente);
		return id_antecedente;
	}
}
