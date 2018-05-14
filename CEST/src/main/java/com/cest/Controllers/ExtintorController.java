package com.cest.Controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.BloqueDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.FichatecnicaDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Extintor;
import com.cest.Services.ExtintorService;
import com.cest.Services.ExtintorServiceImpl;



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
				modelo.addAttribute("extintor", extintor);
			}
			
		}
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "actualizarExtintor";
	}
	
	@PostMapping(value = "/actualizarExtintor")
	public ModelAndView postActualizar(@ModelAttribute Extintor extintor) {
		extintorService.update(extintor);
		return new ModelAndView("redirect:/home");
	}
	
}