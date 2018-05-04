package com.cest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cest.Models.Usuario;


/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class HomeController {

	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/home")
	public String getHome(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "home";
	}
	
}
