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
import com.cest.Models.Extintor;
import com.cest.Dao.ContratoDAO;
import com.cest.Dao.ReporteDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Contrato;
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
	@Autowired
	private ContratoDAO contratoDao;
	
	

	
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
	public String getHome(Model modelo, @RequestParam String tipo, @RequestParam String nombresede, @RequestParam String nombrebloque, @RequestParam String nombrepiso, @RequestParam String idelemento) {
		if (tipo.equals("general")) {
			modelo.addAttribute("elementos", extintorDao.findAll());
			return "consultaGeneral";
		}else if (tipo.equals("extintor")) {

			if(idelemento.equals("")) {				
				modelo.addAttribute("extintores", extintorDao.findAll());			
			}
			else if(!idelemento.equals("")) {				
					List<Extintor> extintores = new ArrayList<>();		
					for (Extintor extintor: extintorDao.findAll()) {
						if (extintor.getIdelemento() == Integer.parseInt(idelemento)) {
							extintores.add(extintor);
						}
					}
					modelo.addAttribute("extintores", extintores);			
			}
			if(idelemento.equals("")) {				
				modelo.addAttribute("extintores", extintorDao.findAll());			
			
			}
			if(!idelemento.equals("")) {				
					List<Extintor> extintores = new ArrayList<>();		
					for (Extintor extintor: extintorDao.findAll()) {
						if (extintor.getIdelemento() == Integer.parseInt(idelemento)) {
							extintores.add(extintor);
						}
					}
					modelo.addAttribute("extintores", extintores);			
				
			}
				
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
					if (extintor.getElemento().getPiso().equals(nombrepiso)) {
						Extintores.add(extintor);
					}
				}
				modelo.addAttribute("extintores", Extintores);
				modelo.addAttribute("sedes", sedeDao.findAll());
			}
			

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

	@PostMapping(value = "/obtenerEmpresa")
	@ResponseBody
	public String getEmpresa(@RequestParam String numerocontrato) {
		String nombreempresa = null;
		for (Contrato contrato : contratoDao.findAll()) {
			if (contrato.getNumero() == Integer.valueOf(numerocontrato)) {
				nombreempresa = contrato.getEmpresa().getNombre();
			}
		}
		return nombreempresa;
	}
	

}
