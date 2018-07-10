package com.cest.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.FichatecnicaDAO;
import com.cest.Models.Fichatecnica;

@Controller
@RequestMapping
public class FichaTecnicaController {
	
	@Autowired
	private FichatecnicaDAO  fichatecnicaDao;

	
	@GetMapping(value = "/registrarFichaTecnica")
	public String getRegistrarFichaTecnica(Model modelo) {
		modelo.addAttribute("fichatecnica", new Fichatecnica());
		return "registrarFichaTecnica";
	}
	
	@GetMapping(value = "/consultarFichaTecnica")
	public String getConsultarFichasTecnicas(Model modelo) {
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "consultarFichaTecnica";
	}	
	
	@GetMapping(value = "/modificarFichaTecnica")
	public Fichatecnica getModificarFichaTecnica(@RequestParam String tipo) {
		for (Fichatecnica fichatecnica : fichatecnicaDao.findAll()) {
			if (fichatecnica.getTipo() == tipo) {			
				fichatecnicaDao.save(fichatecnica);
				return fichatecnica;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/modificarFichaTecnica")
	@ResponseBody
	public ModelAndView postModificarEmpresa(@RequestParam("tipo") String tipo,
			@RequestParam("componentes") String componentes,
			@RequestParam("descripcion") String descripcion
			
			) {
		
		for (Fichatecnica fichatecnica1 : fichatecnicaDao.findAll()) {
			if (fichatecnica1.getTipo() == tipo) {
				Fichatecnica fichatecnica = fichatecnica1;
				fichatecnica.setComponentes(componentes);
				fichatecnica.setDescripcion(descripcion);
				
				return new ModelAndView("redirect:/consultarFichaTecnica");
			}
		}
		
		return null;
	}
	
	
	@PostMapping(value="/registrarFichaTecnica")
	public ModelAndView postRegistrarFichaTecnica(@ModelAttribute("fichatecnica") Fichatecnica fichatecnica){
		fichatecnicaDao.save(fichatecnica);
		return new ModelAndView("redirect:/consultarFichaTecnica");
	}
	
	@GetMapping(value = "/crudFichaTecnicaE")
	public ModelAndView postEliminarFichaTecnica(@RequestParam("tipo") String tipo) {
		
		for (Fichatecnica fichatecnica : fichatecnicaDao.findAll()) {
			if (fichatecnica.getTipo() == tipo) {
				fichatecnicaDao.delete(fichatecnica);
				return new ModelAndView("redirect:/crudEmpresa");
			}
		}
		
		return null;
	}
	 
	

}
