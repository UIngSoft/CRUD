package com.cest.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cest.Dao.SedeDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.BloqueDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Models.Extintor;
import com.cest.Models.Bloque;
import com.cest.Models.Piso;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ConsultaController {

	@Autowired
	private ExtintorDAO extintorDao;
	
	@Autowired
	private SedeDAO sedeDao;
	
	@Autowired
	private BloqueDAO bloqueDao;
	
	@Autowired
	private PisoDAO pisoDao;
	
	/*
	 * Visualiza pagina de consultas
	 */
	@GetMapping(value = "/consulta")
	public String getHome(Model modelo, @RequestParam String tipo, @RequestParam String nombresede, @RequestParam String nombrebloque, @RequestParam String nombrepiso) {
		if (tipo.equals("general")) {
			modelo.addAttribute("elementos", extintorDao.findAll());
			return "consultaGeneral";
		}else if (tipo.equals("extintor")) {
			if(nombrepiso.equals("")) {
			modelo.addAttribute("extintores", extintorDao.findAll());
			modelo.addAttribute("sedes", sedeDao.findAll());
			List<Bloque> bloques = new ArrayList<>();
			List<Piso> pisos = new ArrayList<>();
			if(!nombresede.equals("")) {
				for (Bloque bloque: bloqueDao.findAll()) {
					if (bloque.getSede().getNombre().equals(nombresede)) {
						bloques.add(bloque);
						
					}
				}
				modelo.addAttribute("bloques", bloques);
			}
			if(!nombrebloque.equals("")) {
				for (Piso piso: pisoDao.findAll()) {
					if (piso.getBloque().getNombre().equals(nombrebloque)) {
						pisos.add(piso);
						
					}
				}
				modelo.addAttribute("pisos", pisos);
			}
			}else {
				List<Extintor> Extintores = new ArrayList<>();
				for (Extintor extintor: extintorDao.findAll()) {
					if (extintor.getElemento().getNumeropiso() == Integer.parseInt(nombrepiso)) {
						Extintores.add(extintor);
					}
				}
				modelo.addAttribute("extintores", Extintores);
				modelo.addAttribute("sedes", sedeDao.findAll());
			}
			
			return "consultaExtintor";
		}else if (tipo.equals("botiquin")) {
			return "consultaBotiquin";
		}else{
			return "consultaCamilla";
		}
	}
	
	
	

	
}
