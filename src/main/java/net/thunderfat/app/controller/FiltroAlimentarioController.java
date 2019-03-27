package net.thunderfat.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.thunderfat.app.model.Alimento;
import net.thunderfat.app.model.FiltroAlimentario;
import net.thunderfat.app.service.IAlimentoService;
import net.thunderfat.app.service.IFiltroAlimentarioService;
import net.thunderfat.app.service.INutricionistaService;
@CrossOrigin
@Controller
@RequestMapping(value = "/filtro_alimentario")

public class FiltroAlimentarioController {
	@Autowired
	private IFiltroAlimentarioService filtroAlimentarioService;
	@Autowired
	private INutricionistaService nutricionistaService;
	@Autowired
	private IAlimentoService alimentoService;

	@RequestMapping(value = "/index/{id}")
	public String listarPorNutricionistas(@PathVariable("id") int id_nutricionista, Model model) {
		
		model.addAttribute("nutricionista", nutricionistaService.buscarPorId(id_nutricionista));
		model.addAttribute("filtrosalimentarios",
				filtroAlimentarioService.listarporNutricionista(nutricionistaService.buscarPorId(id_nutricionista)));

		return "filtroalimentario/listFiltro";
	}

	@RequestMapping(value = "/create/{id}")
	public String crearFiltro(@PathVariable("id") int id_nutricionista, Model model) {
		model.addAttribute("alimentos", alimentoService.ListarAlimentos());
		model.addAttribute("nutricionista", id_nutricionista);
		model.addAttribute("filtroAlimentario", new FiltroAlimentario());

		return "filtroalimentario/formFiltro";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute FiltroAlimentario filtro, BindingResult result, Model model,
			RedirectAttributes attributes) {
	
		System.out.println(filtro);		
		
		for(int i =0 ;i<filtro.getAlimentos().size();i++) {
			filtro.getAlimentos().set(i, alimentoService.buscarPorId(filtro.getAlimentos().get(i).getId_alimento()));
		}
		filtroAlimentarioService.insertar(filtro);
		attributes.addFlashAttribute("msg", "El Filtro Alimentario fue guardado!");

		return "redirect:/filtro_alimentario/index/" + filtro.getNutricionista().getId_usuario();

	}

	@RequestMapping(value = "/edit/{id}")
	public String editarFiltroAlimentario(@PathVariable("id") int id_filtro, Model model) {
		model.addAttribute("alimentos", alimentoService.ListarAlimentos());
		model.addAttribute("nutricionista", filtroAlimentarioService.buscarPorId(id_filtro).getNutricionista().getId_usuario());
		System.out.println(filtroAlimentarioService.buscarPorId(id_filtro));
		model.addAttribute("filtroAlimentario", filtroAlimentarioService.buscarPorId(id_filtro));

		return "filtroalimentario/formFiltro";
	}
	@RequestMapping(value="/delete/{id}")
	public String borrarFiltroAlimentario(@PathVariable("id")int id_filtro, Model model,RedirectAttributes attributes) {
		
		int i =filtroAlimentarioService.buscarPorId(id_filtro).getNutricionista().getId_usuario();
		filtroAlimentarioService.eliminar(id_filtro);
		attributes.addFlashAttribute("msg", "El Filtro Alimentario fue eliminado!");
		return "redirect:/filtro_alimentario/index/"+i;
	}

	@RequestMapping(value="alimentos/{id}")
	@ResponseBody
	public List<Alimento> alimentosDeUnFiltro(@PathVariable("id") int id_filtroalimentario){
		System.out.println("peticion recibida en el back ");
		return filtroAlimentarioService.buscarPorId(id_filtroalimentario).getAlimentos();
	}
	@RequestMapping(value="alimentosSelect/")
	@ResponseBody
	public Map<String, ArrayList> listarAlimentos(){
		 Map<String,ArrayList> result= new LinkedHashMap();
		 result.put("results", alimentoService.listarParaSelect());
		return result;
	}
	
	@PostMapping(value = "/saveAjax", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public void guardarCitaAjax(@RequestBody HashMap<String, Object> filtro, HttpServletRequest request,
			BindingResult result) {

		System.out.println(filtro);
		String nombre = (String) filtro.get("nombre");
		System.out.println(filtro.get("alimentos"));
		String alimentoString=filtro.get("alimentos").toString();
		System.out.println(alimentoString);
		String[] items = alimentoString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").replaceAll(" ", "").split(",");

		int[] results = new int[items.length];

		for (int i = 0; i < items.length; i++) {
		    try {
		        results[i] = Integer.parseInt(items[i]);
		    } catch (NumberFormatException nfe) {
		        //NOTE: write something here if you need to recover from formatting errors
		    };
		}
		ArrayList<Alimento> name = new ArrayList <Alimento>();
		for (int j=0;j<results.length;j++) {
			System.out.println(results[j]+"resultado en int ");
			
		}
//		ArrayList<Integer> fechafin =filtro.get("alimento").;
//		int id_paciente = (int) cita.get("id_paciente");
//		int id_nutricionista = (int) cita.get("id_nutricionista");
//		System.out.println(fechaini + " inicio");
//		System.out.println(fechafin + " fin");
//		System.out.println(id_paciente + "paciente");
//		System.out.println(id_nutricionista + "nutricionista");
//		Cita cita2 = new Cita();
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME ;
//
//		cita2.setFecha_fin(LocalDateTime.parse(fechafin, formatter));
//		cita2.setFecha_ini(LocalDateTime.parse(fechaini, formatter));
//		cita2.setNutricionista(serviceNutricionista.buscarPorId(id_nutricionista));
//		cita2.setPaciente(servicePaciente.buscarPorId(id_paciente));
//		System.out.println(cita2);
//		// serviceCita.insertar(cita);cita.getNutricionista().getId_usuario()
//		serviceCita.insertar(cita2);
//		//return "redirect:/cita/nutricionista/index/";

	}
}
