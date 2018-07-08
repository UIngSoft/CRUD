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
import com.cest.Dao.CamillaDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Camilla;
import com.cest.Models.Extintor;
import com.cest.Models.Piso;

/**
 * 
 * @author Lorenzo Zuluaga Urrea
 * @author Santiago granada aguirre
 *
 */


final class Element{
	private String tipoelemento;
	private int id;
	private String ubicacion;
	private String tipo;
	private String fechavencimiento;
	
	public Element(String tipoelemento, int id, String ubicacion, String tipo, String fechavencimiento) {
		super();
		this.setTipoelemento(tipoelemento);
		this.setId(id);
		this.setUbicacion(ubicacion);
		this.setTipo(tipo);
		this.setFechavencimiento(fechavencimiento);
	}
	
	public String getTipoelemento() {
		return tipoelemento;
	}

	public void setTipoelemento(String tipoelemento) {
		this.tipoelemento = tipoelemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
}


/*
 * Controlador para el index
 */
@Controller
@RequestMapping
public class ConsultaController {

	@Autowired
	private ExtintorDAO extintorDao;
	@Autowired
	private CamillaDAO camillaDao;
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
			List<Element> elementos = new LinkedList<>();
			String tipoelemento;
			int id;
			String ubicacion;
			String tipoo;
			String fechavencimiento;
			for (Extintor extintor : extintorDao.findAll()) {
				tipoelemento = "Extintor";
				id = extintor.getIdelemento();
				ubicacion = extintor.getElemento().getPiso().getBloque().getSede().getNombre()
						+"->"+extintor.getElemento().getPiso().getPisoPk().getLetrabloque()
						+"->"+extintor.getElemento().getPiso().getPisoPk().getNumero();
				tipoo = extintor.getFichatecnica().getTipo();
				fechavencimiento = ""+extintor.getFechavencimiento();
				elementos.add(new Element(tipoelemento, id, ubicacion, tipoo, fechavencimiento));
			}
			for (Camilla camilla : camillaDao.findAll()) {
				tipoelemento = "Camilla";
				id = camilla.getIdElemento();
				ubicacion = camilla.getElemento().getPiso().getBloque().getSede().getNombre()
						+"->"+camilla.getElemento().getPiso().getPisoPk().getLetrabloque()
						+"->"+camilla.getElemento().getPiso().getPisoPk().getNumero();
				tipoo = camilla.getTipocamilla();
				fechavencimiento = "No aplica";
				elementos.add(new Element(tipoelemento, id, ubicacion, tipoo, fechavencimiento));
			}
			modelo.addAttribute("elementos", elementos);
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
