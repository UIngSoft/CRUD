package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.CamillaDAO;
import com.cest.Models.Camilla;

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
	@ResponseBody
	public ModelAndView postModificarCamilla(@RequestParam("idelemento") int idelemento,
			@RequestParam("tipocamilla") String tipocamilla,
			@RequestParam("encargado") int encargado,
			@RequestParam("ubicacion") String ubicacion
			) {
		
		for (Camilla camilla1 : camillaDao.findAll()) {
			if (camilla1.getIdElemento() == idelemento) {
				Camilla camilla = camilla1;
				camilla.setEncargado(encargado);
				camilla.setTipocamilla(tipocamilla);
				camillaDao.save(camilla);
				
				return new ModelAndView("redirect:/consulta?tipo=camilla");
			}
		}
		
		return null;
	}

}
