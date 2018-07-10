package com.cest.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.BloqueDAO;
import com.cest.Dao.CamillaDAO;
import com.cest.Dao.ElementoDAO;
import com.cest.Dao.EncargadoDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Camilla;
import com.cest.Models.Contrato;
import com.cest.Models.Elemento;
import com.cest.Models.Encargado;
import com.cest.Models.Piso;
import com.cest.Models.Sede;

@Controller
@RequestMapping
public class CamillaController {
	
	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private BloqueDAO bloqueDao;
	@Autowired 
	private PisoDAO pisoDao;
	@Autowired
	private ElementoDAO elementoDao;
	@Autowired
	private CamillaDAO camillaDao;
	@Autowired
	private EncargadoDAO encargadoDao;
	
	/**	
	 * @author Lorenzo Zuluaga Urrea
	 * @version 6/7/2018
	 * 
	 * @param idelemento
	 * @return
	 */
	@GetMapping(value = "/modificarCamilla")
	public Camilla getModificarEmpresa(@RequestParam int idelemento) {
		for (Camilla camilla : camillaDao.findAll()) {
			if (camilla.getIdelemento() == idelemento) {			
				camillaDao.save(camilla);
				return camilla;
			}
		}
		return null;
	}

	/**	
	 * @author Lorenzo Zuluaga Urrea
	 * @version 6/7/2018
	 * 
	 * @param idelemento
	 * @param tipocamilla
	 * @param encargado
	 * @param ubicacion
	 * @return
	 */
	@PostMapping(value = "/modificarCamilla")
	public ModelAndView postModificarCamilla(@RequestParam("idelemento") int idelemento,
			@RequestParam("tipocamilla") String tipocamilla,
			@RequestParam("encargado") int encargado,
			@RequestParam("ubicacion") String ubicacion
			) {
		
		for (Camilla camilla : camillaDao.findAll()) {
			if (camilla.getIdelemento() == idelemento) {
				camilla.setEncargado(encargado);
				camilla.setTipocamilla(tipocamilla);
				camillaDao.save(camilla);
				break;				
			}
		}
		return new ModelAndView("redirect:/consulta?tipo=camilla");
	}
@GetMapping(value = "/consultarCamilla")
	public String getHome(Model modelo) {
		modelo.addAttribute("camillas", camillaDao.findAll());
		return "consultaCamilla";
	}

	@GetMapping(value = "/registrarCamilla")
	public String getRegistrarCamilla(Model modelo) {
		modelo.addAttribute("camilla", new Camilla());
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "registrarCamilla";
	}
	
	@PostMapping(value = "/registrarCamilla")
	public ModelAndView postRegistrarCamilla(Model modelo, 
			@ModelAttribute("camilla") Camilla camilla, 
			@RequestParam("cedulaencargado") String cedulaencargado, 
			@RequestParam("sede") String nombresede, 
			@RequestParam("bloque") String letrabloque,
			@RequestParam("piso") String numeropiso) {
		
		Elemento elemento = BuscarElemento(camilla.getIdelemento());
		
		if (elemento != null) {
			camilla.setElemento(elemento);
		}else {
			elemento = registrarElemento(camilla.getIdelemento(), nombresede, letrabloque, numeropiso, cedulaencargado, "0");
			camilla.setElemento(elemento);
		}
		
		camillaDao.save(camilla);
		
		return new ModelAndView("redirect:/registrarCamilla");
	}
	
	public Elemento BuscarElemento(int codigo) {
		Elemento elemento = null;
		for (Elemento e : elementoDao.findAll()) {
			if (e.getId() == codigo) {
				elemento = e;
			}
		}
		return elemento;
	}
	
	/*
	 * Registra un elemento en la base de datos
	 */
	public Elemento registrarElemento(int id, String nombresede
			, String letrabloque, String numeropiso
			, String cedulaencargado, String numerocontrato)
	{
		Encargado encargado = null;
		for (Encargado e : encargadoDao.findAll()) {
			if (e.getCedula() == Integer.valueOf(cedulaencargado)) {
				encargado = e;
			}
		}
		Contrato contrato = null;
		Sede sede = null;
		for (Sede s : sedeDao.findAll()) {
			if (s.getNombre().equals(nombresede)) {
				sede = s;
			}
		}
		Bloque bloque = null;
		for (Bloque b : bloqueDao.findAll()) {
			if (b.getBloquePk().getLetra().equals(letrabloque) && b.getSede().equals(sede)) {
				bloque = b;
			}
		}
		Piso piso = null;
		for (Piso p : pisoDao.findAll()) {
			if (p.getPisoPk().getNumero() == Integer.valueOf(numeropiso) && p.getBloque().equals(bloque)) {
				piso = p;
			}
		}
		Elemento elemento = null;
		if (encargado != null) {
				elemento = new Elemento();
				elemento.setId(id);
				elemento.setContrato(contrato);
				elemento.setEncargado(encargado);
				elemento.setPiso(piso);
				elementoDao.save(elemento);
			
		}
		return elemento;
	}
		
}
