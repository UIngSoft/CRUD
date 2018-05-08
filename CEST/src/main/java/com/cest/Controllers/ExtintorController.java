package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Extintor;
import com.cest.Services.ExtintorService;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {

	private ExtintorService extintorService;
	

	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private ExtintorDAO extintorDao;


	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrar(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "registrarExtintor";
	}
	
	@GetMapping(value = "/actualizarExtintor")
	public String getActualizar(Model modelo) {
		modelo.addAttribute("extintores", extintorDao.findAll());
		return "actualizarExtintor";
	}
	
	@PostMapping(value = "/actualizarExtintor")
	public ModelAndView save(@ModelAttribute Extintor extintor) {
		extintorService.update(extintor);
		return new ModelAndView("redirect:/home");
	}
	
}