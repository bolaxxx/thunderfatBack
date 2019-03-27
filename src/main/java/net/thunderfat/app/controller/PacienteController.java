package net.thunderfat.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
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

import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.INutricionistaService;
import net.thunderfat.app.service.IPacienteService;
@CrossOrigin
@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private IPacienteService servicePaciente;
	@Autowired
	private INutricionistaService serviceNutricionista;
	

	
	
	@GetMapping(value = "/create/{id}")
	public String crear(@PathVariable("id")int id_nutricionista,Model model) {
		model.addAttribute("nutricionista", id_nutricionista);
		model.addAttribute("paciente", new Paciente());
		
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
		return "redirect:/paciente/"+paciente.getNutricionista().getId_usuario()+"/index";
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
	public String eliminar(@PathVariable("id") int id_paciente, RedirectAttributes attributes) {
		int id_nutricionista =servicePaciente.buscarPorId(id_paciente).getNutricionista().getId_usuario();
		servicePaciente.eliminar(id_paciente);
		attributes.addFlashAttribute("msg", "El Paciente fue eliminada!.");
		return "redirect:/paciente/"+id_nutricionista+"/index";
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

//	@GetMapping (value="/{id}/index")
//	public String listarPacientesPorNutri(@PathVariable("id") int id_nutricionista, Model modelo) {
//		
//	List <Paciente>lista = servicePaciente.listarporNutricionista(id_nutricionista);
//	//System.out.println(lista);
//		modelo.addAttribute("pacientes", lista);
//		return "pacientes/listPaciente";
//		}
	@GetMapping (value="/{id}/index")
	public String listarPacientesPorNutri(@PathVariable("id") int id_nutricionista, Model modelo) {
		
	List <Paciente>lista = servicePaciente.listarPacienteNutrcionista(id_nutricionista);
	//System.out.println(lista);
		modelo.addAttribute("nutricionista", id_nutricionista);
		modelo.addAttribute("pacientes", lista);
		return "pacientes/listPaciente";
		}

	@RequestMapping(value="/paciente/{id}/")
	@ResponseBody
	public List<Paciente>pacientesPorNutricionista(@PathVariable ("id") int id_nutricionista ){
		List <Paciente>lista = servicePaciente.listarPacienteNutrcionista(id_nutricionista);

		return lista;
		
	}
	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Paciente detallePaciente(@PathVariable ("id") int id_paciente) {
		return servicePaciente.buscarPorId(id_paciente);
	}
	@RequestMapping(value="/nutricionista/lista/{id}/")
	@ResponseBody
	public Map<String, ArrayList> listaPaciente(@PathVariable ("id") int id_nutricionista) {
		Map<String,ArrayList> result= new LinkedHashMap();
		result.put("results",servicePaciente.listarPacienteNutricionistaSelect(id_nutricionista) );
	
		return result;
	}
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> paciente) {
		System.out.println(paciente);
		Paciente pacienteinsert = new Paciente();
		if(paciente.get("id_usuario").equals("")) {
			pacienteinsert.setAltura(Double.parseDouble(paciente.get("altura")));
			pacienteinsert.setApellidos(paciente.get("apellidos"));
			pacienteinsert.setNombre(paciente.get("nombre"));
			pacienteinsert.setDni(paciente.get("dni"));
			pacienteinsert.setCodigopostal(paciente.get("codigopostal"));
			pacienteinsert.setEmail(paciente.get("email"));
			pacienteinsert.setDireccion(paciente.get("direccion"));
			pacienteinsert.setFechanacimiento(LocalDate.parse(paciente.get("fechanacimiento")));
			pacienteinsert.setLocalidad(paciente.get("localidad"));
			pacienteinsert.setSexo(paciente.get("sexo"));	
			pacienteinsert.setTelefono(paciente.get("telefono"));
			pacienteinsert.setProvincia(paciente.get("provincia"));
			pacienteinsert.setNutricionista(serviceNutricionista.buscarPorId(Integer.parseInt(paciente.get("id_nutricionista"))));
			System.out.println(pacienteinsert);
		servicePaciente.insertar(pacienteinsert);
		paciente.replace("id_usuario",Integer.toString(pacienteinsert.getId_usuario()));
		}else {
			pacienteinsert=servicePaciente.buscarPorId((Integer.parseInt(paciente.get("id_usuario"))));
			pacienteinsert.setAltura(Double.parseDouble(paciente.get("altura")));
			pacienteinsert.setApellidos(paciente.get("apellidos"));
			pacienteinsert.setNombre(paciente.get("nombre"));
			pacienteinsert.setDni(paciente.get("dni"));
			pacienteinsert.setCodigopostal(paciente.get("codigopostal"));
			pacienteinsert.setEmail(paciente.get("email"));
			pacienteinsert.setDireccion(paciente.get("direccion"));
			pacienteinsert.setFechanacimiento(LocalDate.parse(paciente.get("fechanacimiento")));
			pacienteinsert.setLocalidad(paciente.get("localidad"));
			pacienteinsert.setSexo(paciente.get("sexo"));	
			pacienteinsert.setTelefono(paciente.get("telefono"));
			pacienteinsert.setProvincia(paciente.get("provincia"));
			servicePaciente.insertar(pacienteinsert);
		
		
		}
	return paciente;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_paciente) {
		System.out.println(id_paciente+"este el id quye receibo para borarr");
		 servicePaciente.eliminar(id_paciente);
		return id_paciente;
	}
}
