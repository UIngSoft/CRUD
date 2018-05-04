package com.cest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ConsultaController {

	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/consultarElementos")
	public String getHome(Model modelo) {
		return "consulta";
	}
	
}
