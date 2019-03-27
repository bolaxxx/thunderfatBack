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
import net.thunderfat.app.model.Medicion_Especifica;
import net.thunderfat.app.model.Medicion_General;
import net.thunderfat.app.model.Paciente;
import net.thunderfat.app.service.IMedicion_EspecificaService;
import net.thunderfat.app.service.IMedicion_GeneralService;
import net.thunderfat.app.service.IPacienteService;

@Controller
@RequestMapping("/medicion_especifica")

public class Medicion_EspecificaController {
	@Autowired 
	private IMedicion_EspecificaService serviceMedicon_Espeficica;
	@Autowired
	private IMedicion_GeneralService serviceMedicion_General;
	@Autowired
	private IPacienteService servicePaciente;
	
	@RequestMapping(value="/index")
	public String listarMedicionesEspecifica() {
		
		return "medicion_especifica/formMedicion_Especifica";
	}
	
	@RequestMapping(value="/index/{id}")
	public String listarMedicionesEspecificaPorPaciente(@PathVariable("id")int id_paciente,Model model) {
		Paciente paciente =servicePaciente.buscarPorId(id_paciente);
		List<Medicion_Especifica>mediciones= serviceMedicon_Espeficica.buscarPorPaciente(paciente);
		model.addAttribute("paciente", paciente);
		model.addAttribute("mediciones", mediciones);
		return"medicion_especifica/listMedicion_Especifica";
	}
	
	@RequestMapping(value="/create/{id}")
	public String crearMedicionEspeficica(@PathVariable("id")int id_paciente ,Model model ) {
		
		Medicion_Especifica medicion_especifica= new Medicion_Especifica();
		Paciente paciente = servicePaciente.buscarPorId(id_paciente);
		medicion_especifica.setPaciente(paciente);
		//double peso = serviceMedicion_General.buscarUltimopeso(paciente.getId_usuario());
		model.addAttribute("medicion_especifica", medicion_especifica);
		model.addAttribute("paciente", paciente);
		//model.addAttribute("peso", peso);
		return"medicion_especifica/formMedicion_Especifica";
	}
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Medicion_Especifica medicion_especifica, BindingResult result, Model model,
			RedirectAttributes attributes) {
		// Insertamos la noticia
		medicion_especifica.setPaciente(servicePaciente.buscarPorId(medicion_especifica.getPaciente().getId_usuario()));
		medicion_especifica.calcularMBI();
		medicion_especifica.calcularGrasaIdMin();
		medicion_especifica.calcularGrasasIdMax();
		medicion_especifica.calcularGrasas();
		medicion_especifica.calcularAguaId();
		medicion_especifica.calcularMusculoIdMax();
		medicion_especifica.calcularMusculoIdMin();
		medicion_especifica.calcularPesoOxMuscMax();
		medicion_especifica.calcularPesoOxMuscMin();
		medicion_especifica.calcularLitrosAgua();
		medicion_especifica.calcularRetencionLiquidos();
		//int idpaciente=(int) model.asMap().get("paciente");
		//antecedentes_clinicos.setPaciente(servicePaciente.buscarPorId(idpaciente));
		serviceMedicon_Espeficica.insertar(medicion_especifica);

		attributes.addFlashAttribute("msg", "Los datos del medicion especifica fueron guardados!");
		//attributes.
		//"redirect:/antecedente_clinico/index/"+medicion_general.getPaciente().getId_paciente()
		return "redirect:/medicion_especifica/index/"+medicion_especifica.getPaciente().getId_usuario();
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editarMedicionEspecifica(@PathVariable("id")int id_medicion,Model model) {
		Medicion_Especifica medicion=serviceMedicon_Espeficica.buscarPorId(id_medicion);
		//double peso=serviceMedicion_General.buscarUltimopeso(medicion.getPaciente().getId_usuario());
		model.addAttribute("medicion_especifica", medicion);
		model.addAttribute("paciente", medicion.getPaciente());
		//model.addAttribute("peso", peso);
		
		return "medicion_especifica/formMedicion_Especifica";
	}
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id_medicion_especifica, RedirectAttributes attributes) {
		int id_paciente = serviceMedicon_Espeficica.buscarPorId(id_medicion_especifica).getPaciente().getId_usuario();
		serviceMedicon_Espeficica.eliminar(id_medicion_especifica);
		attributes.addFlashAttribute("msg", "La medicion Especificia fue eliminada!.");
		return "redirect:/medicion_especifica/index/"+id_paciente;
	}
	@RequestMapping(value="/datosGrafica/{id}")
	@ResponseBody
	public List<Medicion_Especifica> datosGrafica(@PathVariable("id")int id_paciente){
		Paciente paciente =servicePaciente.buscarPorId(id_paciente);
		List<Medicion_Especifica>mediciones= serviceMedicon_Espeficica.buscarPorPaciente(paciente);
		return mediciones;
	}
	@RequestMapping(value="/detalles/{id}/")
	@ResponseBody
	public Medicion_Especifica ddatosMedicion(@PathVariable("id")int id_medicion) {
		return serviceMedicon_Espeficica.buscarPorId(id_medicion);
	}
	
	@PostMapping(value="/saveAjax",produces = "application/json")
	@ResponseBody
	public Map<String,String> saveAjax(@RequestBody Map<String,String> medicion) {
		System.out.println(medicion);
		Medicion_Especifica pacienteinsert = new Medicion_Especifica();
		if(medicion.get("id_medicionespecifica").equals("")) {
			System.out.println("paso por le if ");
			pacienteinsert.setGrasavisceral(Double.parseDouble(medicion.get("grasasvisceral"))); 
			System.out.println(" grasas visceral seteada");
			pacienteinsert.setPorcentajeagua(Double.parseDouble(medicion.get("porcentajeagua"))); 
			System.out.println(" porcentaje de agua setteado ");
			pacienteinsert.setMetabolismo(Double.parseDouble(medicion.get("metabolismo")));
			System.out.println(" metabolismo seteada");
			pacienteinsert.setEdad_met(Integer.parseInt(medicion.get("edad_met")));
			System.out.println(" edad met seteada");
			pacienteinsert.setMusculo(Double.parseDouble(medicion.get("musculo")));
			System.out.println(" masas osea seteada");
			pacienteinsert.setMasa_osea(Double.parseDouble(medicion.get("masa_osea")));	
			pacienteinsert.setPorcentajegrasa(Double.parseDouble(medicion.get("porcentajegrasas")));
			System.out.println(" %grasas setted");
			pacienteinsert.setPeso(Double.parseDouble(medicion.get("peso")));
			System.out.println("  peso set");
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
			pacienteinsert.calcularMBI();
			pacienteinsert.calcularGrasaIdMin();
			pacienteinsert.calcularGrasasIdMax();
			pacienteinsert.calcularGrasas();
			pacienteinsert.calcularAguaId();
			pacienteinsert.calcularMusculoIdMax();
			pacienteinsert.calcularMusculoIdMin();
			pacienteinsert.calcularPesoOxMuscMax();
			pacienteinsert.calcularPesoOxMuscMin();
			pacienteinsert.calcularLitrosAgua();
			pacienteinsert.calcularRetencionLiquidos();
			
			
			
			
			System.out.println(pacienteinsert);
		serviceMedicon_Espeficica.insertar(pacienteinsert);
		medicion.replace("id_medicionespecifica",Integer.toString(pacienteinsert.getId_medicionespecifica()));
		}else {
			pacienteinsert=serviceMedicon_Espeficica.buscarPorId((Integer.parseInt(medicion.get("id_medicionespecifica"))));
			pacienteinsert.setPaciente(servicePaciente.buscarPorId(Integer.parseInt(medicion.get("id_paciente")))); 
			pacienteinsert.setGrasavisceral(Double.parseDouble(medicion.get("grasasvisceral"))); 
			pacienteinsert.setPorcentajeagua(Double.parseDouble(medicion.get("porcentajeagua"))); 
			pacienteinsert.setMetabolismo(Double.parseDouble(medicion.get("metabolismo")));
			pacienteinsert.setEdad_met(Integer.parseInt(medicion.get("edad_met")));
			pacienteinsert.setMusculo(Double.parseDouble(medicion.get("musculo")));
			pacienteinsert.setMasa_osea(Double.parseDouble(medicion.get("masa_osea")));	
			pacienteinsert.setPorcentajegrasa(Double.parseDouble(medicion.get("porcentajegrasas")));
			pacienteinsert.setPeso(Double.parseDouble(medicion.get("peso")));
			
			
			pacienteinsert.calcularMBI();
			pacienteinsert.calcularGrasaIdMin();
			pacienteinsert.calcularGrasasIdMax();
			pacienteinsert.calcularGrasas();
			pacienteinsert.calcularAguaId();
			pacienteinsert.calcularMusculoIdMax();
			pacienteinsert.calcularMusculoIdMin();
			pacienteinsert.calcularPesoOxMuscMax();
			pacienteinsert.calcularPesoOxMuscMin();
			pacienteinsert.calcularLitrosAgua();
			pacienteinsert.calcularRetencionLiquidos();
			
			
			pacienteinsert.setFecha(LocalDate.parse(medicion.get("fecha")));
			
			
			System.out.println(pacienteinsert);
		serviceMedicon_Espeficica.insertar(pacienteinsert);
		
		
		}
		return medicion;
	}
	@RequestMapping(value="/deleteAjax/{id}/")
	@ResponseBody
	public int eliminarAntecedente(@PathVariable ("id") int id_antecedente) {
		 serviceMedicon_Espeficica.eliminar(id_antecedente);
		return id_antecedente;
	}
}
