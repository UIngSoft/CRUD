package com.cest.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cest.Dao.BloqueDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.PisoDAO;
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
	private BloqueDAO bloqueDao;
	@Autowired
	private PisoDAO pisoDao;
	
	/*
	 * Visualiza pagina de consultas
	 */
	@GetMapping(value = "/consulta")
	public String getHome(Model modelo, @RequestParam String tipo) {
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
	
	@PostMapping(value = "/obtenerBloques")
	@ResponseBody
	public List<Character> getBloques(@RequestParam String sede) {
		List<Character> misBloques = new LinkedList<>();
		for (Bloque bloque : bloqueDao.findAll()) {
			if (bloque.getSede().getNombre().equals(sede)) {
				misBloques.add(bloque.getLetra());
			}
		}
		return misBloques;
	}
	
	@PostMapping(value = "/obtenerPisos")
	@ResponseBody
	public List<String> getPisos(@RequestParam String sede, @RequestParam Character bloque) {
		List<String> misPisos = new LinkedList<>();
		System.out.println("SOLICITO: Sede:"+sede+" Bloque:"+bloque);
		for (Piso piso : pisoDao.findAll()) {
			System.out.println("Piso:"+piso.getNumero() +"  Bloque: "+piso.getBloque().getLetra());
			if (String.valueOf(piso.getBloque().getLetra()).equals(String.valueOf(bloque))) {
				Bloque b= piso.getBloque();
				if (b.getSede().getNombre().equals(sede)) {
					misPisos.add(String.valueOf(piso.getNumero()));
				}
			}
		}
		return misPisos;
	}
	
}
