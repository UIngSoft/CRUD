package com.crudcontrato.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class IndexController {

	/*
	 * Visualiza pagina index
	 */
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
}
