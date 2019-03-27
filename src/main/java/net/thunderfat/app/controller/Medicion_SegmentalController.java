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
import net.thunderfat.app.model.Medicion_Segmental;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IMedicion_SegmentalService;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping("/medicion_segmental")
public class Medicion_SegmentalController {
	@Autowired
	private IPacienteService servicePaciente;
	@Autowired
	private IMedicion_SegmentalService serviceMedicion_Segmental;

	@RequestMapping(value="/index/{id}")
	public String listar(Model model,@PathVariable ("id")int id_paciente ) {
		Paciente paciente =servicePaciente.buscarPorId(id_paciente);
		List<Medicion_Segmental>mediciones= serviceMedicion_Segmental.buscarPorPaciente(paciente);
		model.addAttribute("paciente", paciente);
		model.addAttribute("mediciones", mediciones);
		return	"medicion_segmental/listMedicion_Segmental";
	}
	
	@RequestMapping(value="/create/{id}")
	public String Añadir(@PathVariable("id")int id_paciente,Model model) {
		Medicion_Segmental medicion_segmental= new Medicion_Segmental();
		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		medicion_segmental.setPaciente(paciente);
		
		model.addAttribute("medicion_segmental", medicion_segmental);
		return "medicion_segmental/formMedicion_Segmental";
	}
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Medicion_Segmental medicion_segmental, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		medicion_segmental.setPaciente(servicePaciente.buscarPorId(medicion_segmental.getPaciente().getId_usuario()));
		//int idpaciente=(int) model.asMap().get("paciente");
		//antecedentes_clinicos.setPaciente(servicePaciente.buscarPorId(idpaciente));
		serviceMedicion_Segmental.insertar(medicion_segmental);

		attributes.addFlashAttribute("msg", "Los datos del antecedente clinico fueron guardados!");
		//attributes.
		//"redirect:/antecedente_clinico/index/"+medicion_general.getPaciente().getId_paciente()
		return "redirect:/medicion_segmental/index/"+medicion_segmental.getPaciente().getId_usuario();
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_medicion_segmental, RedirectAttributes attributes) {
		int id_paciente = serviceMedicion_Segmental.buscarPorId(id_medicion_segmental).getPaciente().getId_usuario();
		serviceMedicion_Segmental.eliminar(id_medicion_segmental);
		attributes.addFlashAttribute("msg", "La medicion segmental fue eliminada!.");
		return "redirect:/medicion_segmental/index/"+id_paciente;
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int id_medicion_segmental, Model model) {
		Medicion_Segmental  medicion_segmental= serviceMedicion_Segmental.buscarPorId(id_medicion_segmental);
		model.addAttribute("medicion_segmental", medicion_segmental);
		return "medicion_segmental/formMedicion_Segmental";
	}
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> medicion) {
		System.out.println(medicion);
		Medicion_Segmental pacienteinsert = new Medicion_Segmental();
		if(medicion.get("id_medicion_segmental").equals("")) {
				
			System.out.println("paso por le if ");
			pacienteinsert.setBdporcentajegrasas(Double.parseDouble(medicion.get("bdporcentajegrasas"))); 
			System.out.println(" peso_ideal seteada");
			pacienteinsert.setBd_musculo(Double.parseDouble(medicion.get("bd_musculo"))); 
			System.out.println(" bd_musculo setteado ");
			pacienteinsert.setBimusculo(Double.parseDouble(medicion.get("bimusculo")));
			System.out.println(" brazo seteada");
			pacienteinsert.setPiporcentajegrasas(Double.parseDouble(medicion.get("piporcentajegrasas")));
			System.out.println("  icc seteada");
			pacienteinsert.setPdmusculo(Double.parseDouble(medicion.get("pdmusculo")));	
			pacienteinsert.setPdporcentajegrasas(Double.parseDouble(medicion.get("pdporcentajegrasas")));
			pacienteinsert.setTporcentajegrasa(Double.parseDouble(medicion.get("tporcentajegrasa")));
			System.out.println(" masas osea seteada");
			pacienteinsert.setTmusculo(Double.parseDouble(medicion.get("tmusculo")));	
			pacienteinsert.setPimusculo(Double.parseDouble(medicion.get("pimusculo")));
			System.out.println(" %grasas setted");
			pacienteinsert.setBiporcentajegrasas(Double.parseDouble(medicion.get("biporcentajegrasas")));
			System.out.println("  peso set");
			
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
		
			
			
			
			System.out.println(pacienteinsert);
		serviceMedicion_Segmental.insertar(pacienteinsert);
		medicion.replace("id_medicion_general",Integer.toString(pacienteinsert.getId_medicion_segmental()));
		}else {
			pacienteinsert=serviceMedicion_Segmental.buscarPorId((Integer.parseInt(medicion.get("id_medicion_segmental"))));
			System.out.println("paso por le if ");
			pacienteinsert.setBdporcentajegrasas(Double.parseDouble(medicion.get("bdporcentajegrasas"))); 
			System.out.println(" peso_ideal seteada");
			pacienteinsert.setBd_musculo(Double.parseDouble(medicion.get("bd_musculo"))); 
			System.out.println(" bd_musculo setteado ");
			pacienteinsert.setBimusculo(Double.parseDouble(medicion.get("bimusculo")));
			System.out.println(" brazo seteada");
			pacienteinsert.setPiporcentajegrasas(Double.parseDouble(medicion.get("piporcentajegrasas")));
			System.out.println("  icc seteada");
			pacienteinsert.setPdmusculo(Double.parseDouble(medicion.get("pdmusculo")));	
			pacienteinsert.setPdporcentajegrasas(Double.parseDouble(medicion.get("pdporcentajegrasas")));
			pacienteinsert.setTporcentajegrasa(Double.parseDouble(medicion.get("tporcentajegrasa")));
			System.out.println(" masas osea seteada");
			pacienteinsert.setTmusculo(Double.parseDouble(medicion.get("tmusculo")));	
			pacienteinsert.setPimusculo(Double.parseDouble(medicion.get("pimusculo")));
			System.out.println(" %grasas setted");
			pacienteinsert.setBiporcentajegrasas(Double.parseDouble(medicion.get("biporcentajegrasas")));
			System.out.println("  peso set");
			
		
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
		
			
			
			System.out.println(pacienteinsert);
		serviceMedicion_Segmental.insertar(pacienteinsert);
		
		
		}
		return medicion;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_antecedente) {
		 serviceMedicion_Segmental.eliminar(id_antecedente);
		return id_antecedente;
	}

	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Medicion_Segmental ddatosMedicion(@PathVariable("id")int id_medicion) {
		return serviceMedicion_Segmental.buscarPorId(id_medicion);
	}
}
