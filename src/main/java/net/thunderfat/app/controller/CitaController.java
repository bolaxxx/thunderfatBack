package net.thunderfat.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Cita;
import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.ICitaService;
import net.thunderfat.app.service.INutricionistaService;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping(value = "/cita")
@CrossOrigin
public class CitaController {
	@Autowired
	private ICitaService serviceCita;
	@Autowired
	private IPacienteService servicePaciente;
	@Autowired
	private INutricionistaService serviceNutricionista;

	@GetMapping(value = "nutricionista/index/{id}")
	public String mostrarCita(@PathVariable("id") int id_nutricionista, Model model) {

		Nutricionista nutricionista = serviceNutricionista.buscarPorId(id_nutricionista);
		List<Cita> citas = serviceCita.ListarPorNutricionista(nutricionista);
		model.addAttribute("nutricionista", nutricionista);
		model.addAttribute("citas", citas);
		model.addAttribute("paciente", servicePaciente.listarPacienteNutrcionista(id_nutricionista));

		return "cita/listCitaNutricionista";
	}

	@RequestMapping(value = "/create/{id}")
	public String añadirCita(@PathVariable("id") int id_nutricionista, Model model) {
		Nutricionista nutricionista = serviceNutricionista.buscarPorId(id_nutricionista);
		List<Paciente> pacientes = servicePaciente.listarPacienteNutrcionista(id_nutricionista);
		Cita cita = new Cita();
		model.addAttribute("cita", cita);
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("nutricionista", nutricionista);
		return "cita/formCita";

	}

	@PostMapping(value = "/save")
	public String guardarCita(@ModelAttribute Cita cita, BindingResult result, Model model,
			RedirectAttributes attributes) {

		System.out.println(cita);

		serviceCita.insertar(cita);

		return "redirect:/cita/nutricionista/index/" + cita.getNutricionista().getId_usuario();

	}

	@PostMapping(value = "/saveAjax", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public void guardarCitaAjax(@RequestBody HashMap<String, Object> cita, HttpServletRequest request,
			BindingResult result) {

		System.out.println(cita);
		String fechaini = (String) cita.get("fecha_ini");
		String fechafin = (String) cita.get("fecha_fin");
		int id_paciente = (int) cita.get("id_paciente");
		int id_nutricionista = (int) cita.get("id_nutricionista");
		System.out.println(fechaini + " inicio");
		System.out.println(fechafin + " fin");
		System.out.println(id_paciente + "paciente");
		System.out.println(id_nutricionista + "nutricionista");
		Cita cita2 = new Cita();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME ;

		cita2.setFecha_fin(LocalDateTime.parse(fechafin, formatter));
		cita2.setFecha_ini(LocalDateTime.parse(fechaini, formatter));
		cita2.setNutricionista(serviceNutricionista.buscarPorId(id_nutricionista));
		cita2.setPaciente(servicePaciente.buscarPorId(id_paciente));
		System.out.println(cita2);
		// serviceCita.insertar(cita);cita.getNutricionista().getId_usuario()
		serviceCita.insertar(cita2);
		//return "redirect:/cita/nutricionista/index/";

	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_cita, RedirectAttributes attributes) {
		int id_nutricionista = serviceCita.buscarPorID(id_cita).getNutricionista().getId_usuario();
		serviceCita.eliminar(id_cita);
		attributes.addFlashAttribute("msg", "La cita fue eliminada!.");
		return "redirect:/cita/nutricionista/index/" + id_nutricionista;
	}

	/**
	 * Metodo para mostrar el formulario de Editar
	 * 
	 * @param idNoticia
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_cita, Model model) {

		Cita cita = serviceCita.buscarPorID(id_cita);
		List<Paciente> pacientes = servicePaciente.listarPacienteNutrcionista(cita.getNutricionista().getId_usuario());
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("cita", cita);
		return "cita/formCita";
	}

	@GetMapping(value = "paciente/index/{id}")
	public String mostrarCitaPaciente(@PathVariable("id") int id_paciente, Model model) {

		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		List<Cita> citas = serviceCita.ListarPorPaciente(paciente);
		// model.addAttribute("nutricionista", nutricionista);
		model.addAttribute("citas", citas);

		return "cita/listCita";
	}

	@RequestMapping(value = "/citasNutricionista/{id}")
	@ResponseBody
	ArrayList<Map> getCitasPaciente(@PathVariable("id") int id_nutricionista,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("start") LocalDate startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("end") LocalDate endDate) {

		// Map<String, Object> respuesta = new LinkedHashMap<String, Object>();
		Nutricionista nutricionista = serviceNutricionista.buscarPorId(id_nutricionista);
		ArrayList<Map> result = serviceCita.ListarPorPacienteEntreFechas(nutricionista, startDate, endDate);

		return result;
	}

}
