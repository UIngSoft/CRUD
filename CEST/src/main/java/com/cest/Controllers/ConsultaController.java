package com.cest.Controllers;

import java.util.ArrayList;

import java.util.Collections;

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


import com.cest.Dao.SedeDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.BloqueDAO;
import com.cest.Dao.PisoDAO;
<<<<<<< HEAD

import com.cest.Dao.ContratoDAO;



=======
>>>>>>> 5f342568f5a95c4a763fd7141c2900bff24c9cce
import com.cest.Models.Bloque;
import com.cest.Models.Piso;

/**
 * 
 * @author Lorenzo Zuluaga Urrea
 * @author Santiago granada aguirre
 *
 */

/*
 * Controlador para el index
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
	
	/**
	 * Recibe la vista y los atributos requeridos para las busquedas(ubicacion, id)
	 * 
	 * @param modelo
	 * @param tipo
	 * @param nombresede
	 * @param nombrebloque
	 * @param nombrepiso
	 * @param idelemento
	 * @return
	 */
	@GetMapping(value = "/consulta")
	public String getConsulta(Model modelo, @RequestParam String tipo) {
		if (tipo.equals("general")) {
			return "consultaGeneral";
		}else if (tipo.equals("extintor")) {
			modelo.addAttribute("extintores", extintorDao.findAll());
			modelo.addAttribute("sedes", sedeDao.findAll());
			return "consultaExtintor";
		}else if (tipo.equals("botiquin")) {
			return "consultaBotiquin";
		}else{
			return "consultaCamilla";
		}
	}
	
	@PostMapping(value = "/obtenerBloques")
	@ResponseBody
	public List<String> getBloques(@RequestParam String sede) {
		List<String> misBloques = new ArrayList<>();
		for (Bloque bloque : bloqueDao.findAll()) {
			if (bloque.getSede().getNombre().equals(sede)) {
				misBloques.add(bloque.bloquePk.getLetra());
			}
		}
		Collections.sort(misBloques);
		return misBloques;
	}
	
	@PostMapping(value = "/obtenerPisos")
	@ResponseBody
	public List<String> getPisos(@RequestParam String sede, @RequestParam String bloque) {
		List<String> misPisos = new LinkedList<>();
		for (Piso piso : pisoDao.findAll()) {
			if (piso.getPisoPk().getLetrabloque().equals(bloque)) {
				if (piso.getBloque().getSede().getNombre().equals(sede)) {
					misPisos.add(String.valueOf(piso.getPisoPk().getNumero()));
				}
			}
		}
		return misPisos;
	}

}
