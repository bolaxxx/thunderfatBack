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

import net.thunderfat.app.model.Medicion_General;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IMedicion_GeneralService;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping("/medicion_general")
public class Medicion_GeneralController {
	@Autowired
	private IMedicion_GeneralService serviceMedicion_General;
	@Autowired
	private IPacienteService servicePaciente;
	
	@RequestMapping(value="/index/{id}")
	public String listar(Model model,@PathVariable ("id")int id_paciente ) {
		Paciente paciente =servicePaciente.buscarPorId(id_paciente);
		List<Medicion_General>mediciones= serviceMedicion_General.listarPorPaciente(paciente);
		model.addAttribute("paciente", paciente);
		model.addAttribute("mediciones", mediciones);
		return	"medicion_general/listMedicion_General";
	}
	
	@RequestMapping(value="/create/{id}")
	public String Añadir(@PathVariable("id")int id_paciente,Model model) {
		Medicion_General medicion_general= new Medicion_General();
		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		medicion_general.setPaciente(paciente);
		
		model.addAttribute("medicion_general", medicion_general);
		return "medicion_general/formMedicion_General";
	}
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Medicion_General medicion_general, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		medicion_general.setPaciente(servicePaciente.buscarPorId(medicion_general.getPaciente().getId_usuario()));
		//int idpaciente=(int) model.asMap().get("paciente");
		//antecedentes_clinicos.setPaciente(servicePaciente.buscarPorId(idpaciente));
		serviceMedicion_General.insertar(medicion_general);

		attributes.addFlashAttribute("msg", "Los datos del antecedente clinico fueron guardados!");
		//attributes.
		//"redirect:/antecedente_clinico/index/"+medicion_general.getPaciente().getId_paciente()
		return "redirect:/medicion_general/index/"+medicion_general.getPaciente().getId_usuario();
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_medicion_general, RedirectAttributes attributes) {
		int id_paciente = serviceMedicion_General.buscarPorID(id_medicion_general).getPaciente().getId_usuario();
		serviceMedicion_General.eliminar(id_medicion_general);
		attributes.addFlashAttribute("msg", "La medicion general fue eliminada!.");
		return "redirect:/medicion_general/index/"+id_paciente;
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_medicion_general, Model model) {
		Medicion_General  medicion_general= serviceMedicion_General.buscarPorID(id_medicion_general);
		model.addAttribute("medicion_general", medicion_general);
		return "medicion_general/formMedicion_General";
	}
	@GetMapping(value="/datosGrafica/{id}")
	@ResponseBody
	List<Medicion_General> datosParaGrafica(@PathVariable ("id")int id_paciente){
		Paciente paciente=servicePaciente.buscarPorId(id_paciente);
		List <Medicion_General>lista= serviceMedicion_General.listarPorPaciente(paciente);
		return lista;
	}
	
	
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> medicion) {
		System.out.println(medicion);
		Medicion_General pacienteinsert = new Medicion_General();
		if(medicion.get("id_medicion_general").equals("")) {
						
			System.out.println("paso por le if ");
			pacienteinsert.setPeso_ideal(Double.parseDouble(medicion.get("peso_ideal"))); 
			System.out.println(" peso_ideal seteada");
			pacienteinsert.setPeso_actual(Double.parseDouble(medicion.get("peso_actual"))); 
			System.out.println(" peso_actual setteado ");
			pacienteinsert.setBrazo(Double.parseDouble(medicion.get("brazo")));
			System.out.println(" brazo seteada");
			pacienteinsert.setIcc(Double.parseDouble(medicion.get("icc")));
			System.out.println("  icc seteada");
			pacienteinsert.setPorcentajegrasas(Double.parseDouble(medicion.get("porcentajegrasas")));
			System.out.println(" masas osea seteada");
			pacienteinsert.setIMC(Double.parseDouble(medicion.get("IMC")));	
			pacienteinsert.setTension_min(Double.parseDouble(medicion.get("tension_min")));
			System.out.println(" %grasas setted");
			pacienteinsert.setTension_max(Double.parseDouble(medicion.get("tension_max")));
			System.out.println("  peso set");
			
			pacienteinsert.setCadera(Double.parseDouble(medicion.get("cadera")));
			pacienteinsert.setCintura(Double.parseDouble(medicion.get("cintura")));
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
		
			
			
			
			System.out.println(pacienteinsert);
		serviceMedicion_General.insertar(pacienteinsert);
		medicion.replace("id_medicion_general",Integer.toString(pacienteinsert.getId_medicion_general()));
		}else {
			pacienteinsert=serviceMedicion_General.buscarPorID((Integer.parseInt(medicion.get("id_medicion_general"))));
			pacienteinsert.setPeso_ideal(Double.parseDouble(medicion.get("peso_ideal"))); 
			System.out.println(" peso_ideal seteada");
			pacienteinsert.setPeso_actual(Double.parseDouble(medicion.get("peso_actual"))); 
			System.out.println(" peso_actual setteado ");
			pacienteinsert.setBrazo(Double.parseDouble(medicion.get("brazo")));
			System.out.println(" brazo seteada");
			pacienteinsert.setIcc(Double.parseDouble(medicion.get("icc")));
			System.out.println("  icc seteada");
			pacienteinsert.setPorcentajegrasas(Double.parseDouble(medicion.get("porcentajegrasas")));
			System.out.println(" masas osea seteada");
			pacienteinsert.setIMC(Double.parseDouble(medicion.get("IMC")));	
			pacienteinsert.setTension_min(Double.parseDouble(medicion.get("tension_min")));
			System.out.println(" %grasas setted");
			pacienteinsert.setTension_max(Double.parseDouble(medicion.get("tension_max")));
			System.out.println("  peso set");
			
			pacienteinsert.setCadera(Double.parseDouble(medicion.get("cadera")));
			pacienteinsert.setCintura(Double.parseDouble(medicion.get("cintura")));
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
		
			
			
			System.out.println(pacienteinsert);
		serviceMedicion_General.insertar(pacienteinsert);
		
		
		}
		return medicion;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_antecedente) {
		 serviceMedicion_General.eliminar(id_antecedente);
		return id_antecedente;
	}

	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Medicion_General ddatosMedicion(@PathVariable("id")int id_medicion) {
		return serviceMedicion_General.buscarPorID(id_medicion);
	}
}
