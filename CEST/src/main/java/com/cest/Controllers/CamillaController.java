package com.cest.Controllers;

<<<<<<< HEAD
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> b92c74f89b12fb689f20ff50c3eec23e95eaa3dd
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import com.cest.Dao.BloqueDAO;
import com.cest.Dao.CamillaDAO;
import com.cest.Dao.ContratoDAO;
import com.cest.Dao.ElementoDAO;
import com.cest.Dao.EncargadoDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Camilla;
import com.cest.Models.Elemento;
import com.cest.Models.Encargado;
import com.cest.Models.Extintor;
import com.cest.Models.Fichatecnica;
=======
import com.cest.Dao.CamillaDAO;
import com.cest.Models.Camilla;
>>>>>>> b92c74f89b12fb689f20ff50c3eec23e95eaa3dd

@Controller
@RequestMapping
public class CamillaController {
	
	@Autowired
	private CamillaDAO camillaDao;
	
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
			if (camilla.getIdElemento() == idelemento) {			
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
			if (camilla.getIdElemento() == idelemento) {
				camilla.setEncargado(encargado);
				camilla.setTipocamilla(tipocamilla);
				camillaDao.save(camilla);
				break;				
			}
		}
		return new ModelAndView("redirect:/consulta?tipo=camilla");
	}

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

	@GetMapping(value = "/registrarCamilla")
	public String getRegistrarCamilla(Model modelo) {
		modelo.addAttribute("camilla", new Camilla());
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "registrarCamilla";
	}
	
	@PostMapping(value = "/registrarCamilla")
	public ModelAndView postRegistrarCamilla(Model modelo, 
			@ModelAttribute("camilla") Camilla camilla, 
			@RequestParam("cedulaencargado") String id, 
			@RequestParam ("tipo") String tipo, 
			@RequestParam("sede") String nombresede, 
			@RequestParam("bloque") String letrabloque,
			@RequestParam("piso") String numeropiso) {
		
		Elemento elemento = BuscarElemento(camilla.getCodigo());
		
		if (elemento != null) {
			extintor.setElemento(elemento);
		}else {
			elemento = registrarElemento(extintor.getIdelemento(), nombresede, letrabloque, numeropiso, cedulaencargado, numerocontrato);
			extintor.setElemento(elemento);
		}
		
		camilla.setTipocamilla(tipocamilla);
		
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
		
}
