package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cest.Dao.SedeDAO;

@Controller
@RequestMapping
public class ReporteController {
	
	@Autowired
	private SedeDAO sedeDao;
	
	@GetMapping(value="/reportarElemento")
	public String getReporte(Model modelo) {
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "reporte";
	}

}
