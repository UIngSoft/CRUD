package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cest.Dao.ContratoDAO;

@Controller
@RequestMapping
public class ContratoController {
	@Autowired
	private ContratoDAO contratoDao;
	
	@GetMapping(value="/registrarContrato")
	public String getRegistrarContrato() {
		return "registrarContrato";
	}

}
