package net.thunderfat.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.thunderfat.app.model.Nutricionista;
import net.thunderfat.app.service.INutricionistaService;

@Controller

public class HomeController {
	@Autowired
	private INutricionistaService serviceNutricionista;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("bola");
		lista.add("caca");
		lista.add("bolero");
		model.addAttribute("lista", lista);
		return "home";

	}

	@RequestMapping(value = "/details")
	public String mostrarDetalle(Model model) {

		String titulo = "sex";
		model.addAttribute("titulos", titulo);

		return "detalle";

	}

	@RequestMapping(value = "/formLogin")
	public String formLogin() {
		return "formlogi El cuadro de reclasificación de cargas indirectas  n";
	}

	@RequestMapping(value = "/buscarNutricionista")
	public String buscarNutricionista(Model modelo) {
		List<String> provincias = serviceNutricionista.buscarProvincias();
		System.out.println(provincias);
		modelo.addAttribute("provincias", provincias);

		return "/buscarNutricionista";
	}

	@RequestMapping(value = "/localidadesenProvincia/{provincia}/")
	@ResponseBody
	public List<String> localidadesenProvincia(@PathVariable("provincia") String provincia) {
		List<String> localidades = serviceNutricionista.buscarLocalidadesporProvincia(provincia);
		return localidades;
	}

	@RequestMapping(value = "/nutricionistaEnLocalidad/{localidad}/")
	@ResponseBody
	public List<Nutricionista> nutricionistaEnLocalidad(@PathVariable("localidad") String localidad) {
		List<Nutricionista> lista = serviceNutricionista.listarNutricionistaporlocalidad(localidad);
		return lista;
	}
}
