package com.cest.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.FichatecnicaDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Extintor;
import com.cest.Models.Fichatecnica;
import com.cest.Services.ExtintorService;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {
	
	@Autowired
	private FichatecnicaDAO fichatecnicaDao;
	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private ExtintorDAO extintorDao;
	@Autowired
	private ExtintorService extintorService;
	


	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrar(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		modelo.addAttribute("sedes", sedeDao.findAll());
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "registrarExtintor";
	}
	
	@GetMapping(value = "/actualizarExtintor")
	public String getActualizar(Model modelo, @RequestParam String id) {
		for (Extintor extintor : extintorDao.findAll()) {
			if (extintor.getIdelemento() == Integer.valueOf(id)) {
				modelo.addAttribute("sedes", sedeDao.findAll());
				modelo.addAttribute("extintor", extintor);
				List<Fichatecnica> fichas = new LinkedList<>();
				for (Fichatecnica fichatecnica : fichatecnicaDao.findAll()) {
					if (!fichatecnica.equals(extintor.getFichatecnica())) {
						fichas.add(fichatecnica);
					}
				}
				modelo.addAttribute("fichastecnicas", fichas);
			}
		}		
		return "actualizarExtintor";
	}
	
	@PostMapping(value = "/actualizarExtintor")
	public ModelAndView postActualizar(@ModelAttribute Extintor extintor) {
		extintorService.update(extintor);
		return new ModelAndView("redirect:/consultaExtintor");
	}
	
}