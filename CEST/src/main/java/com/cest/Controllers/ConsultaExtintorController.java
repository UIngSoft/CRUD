package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cest.Dao.ExtintorDAO;
import com.cest.Models.Extintor;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ConsultaExtintorController {

	@Autowired
	private ExtintorDAO extintorDao;
	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/consultarExtintor")
	public String getHome(Model modelo) {
		for (Extintor ex : extintorDao.findAll()) {
			System.out.println("ID: "+ex.getIdelemento());
		}
		modelo.addAttribute("extintores", extintorDao.findAll());
		return "consultarExtintor";
	}
	
}
