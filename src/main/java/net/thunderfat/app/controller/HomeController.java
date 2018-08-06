package net.thunderfat.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String goHome(Model model) {
		List<String>lista=new LinkedList<String>();
		lista.add("bola");
		lista.add("caca");
		lista.add("bolero");
		model.addAttribute("lista",lista);
		return "home";
	
}
	@RequestMapping (value="/details")
	public String mostrarDetalle(Model model) {
		
		String titulo ="sex";
		model.addAttribute("titulos", titulo);
		
		return "detalle";
		
	}
	
}
