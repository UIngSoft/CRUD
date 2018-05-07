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
public class ConsultaController {

	@Autowired
	private ExtintorDAO extintorDao;
	
	/*
	 * Visualiza pagina de consultas
	 */
	@GetMapping(value = "/consulta")
	public String getHome(Model modelo, @RequestParam String tipo, @RequestParam String sede) {
		System.out.println(sede);
		if (tipo.equals("general")) {
			modelo.addAttribute("elementos", extintorDao.findAll());
			return "consultaGeneral";
		}else if (tipo.equals("extintor")) {
			modelo.addAttribute("extintores", extintorDao.findAll());
			return "consultaExtintor";
		}else if (tipo.equals("botiquin")) {
			return "consultaBotiquin";
		}else{
			return "consultaCamilla";
		}
	}
	
}
