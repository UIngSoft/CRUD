package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cest.Dao.SedeDAO;
import com.cest.Models.Extintor;
import com.cest.Models.Sede;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {
	@Autowired
	private SedeDAO sedeDao;

	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrar(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "registrarExtintor";
	}
	
}