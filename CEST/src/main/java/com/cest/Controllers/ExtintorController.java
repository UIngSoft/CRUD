package com.cest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cest.Models.Extintor;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {
	

	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrar(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		return "registrarExtintor";
	}
	
}