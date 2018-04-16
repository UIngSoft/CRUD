package com.crudcontrato.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import com.crudcontrato.models.Contrato;
import com.crudcontrato.dao.ContratoDao;

/*
 * Controlador de contrato.
 * Gestiona las solicitudes GET y POST
 * @author Luis Trejos
 * @version 1.0
 */

@Controller
@RequestMapping
public class ContratoController {
	
	
	@Autowired
	ContratoDao dao = new ContratoDao();

	/*
	 * Gestiona la solicitud GET del servidor
	 * Crea un nuevo contrato con datos vacíos
	 * @param modelo La vista html
	 * @return registrarDatos Pagina para registrar un contrato
	 */
	@GetMapping(value = "/captura")
	public String Get(Model modelo) {
		modelo.addAttribute("contrato", new Contrato());		
		dao.read();
		modelo.addAttribute("contratos", dao.getContratos());
		return "registrarDatos";
	}
	
	/*
	 * Gestiona la solicitud POST del servidor.
	 * @param modelo La vista html
	 * @param contrato El contrato que será Resgistrado, Buscado, Actualizado o Eliminado
	 * @param request Provee información sobre la pagina html
	 * @return modelandview Devuelve una nueva vista con solicitud GET
	 */
	@PostMapping(value = "/captura")
	public ModelAndView Post(Model modelo,@ModelAttribute("formulario") Contrato contrato,  HttpServletRequest request) {	
		String mensaje = "";
		if (WebUtils.hasSubmitParameter(request, "registrar")) {
			dao.create(contrato);
		} else if(WebUtils.hasSubmitParameter(request, "buscar")){
			mensaje = dao.readId(contrato.getId());
		}else if(WebUtils.hasSubmitParameter(request, "actualizar")){
			dao.update(contrato);
		}else {
			dao.delete(contrato.getId());
		}
		ModelAndView modelandview = new ModelAndView("redirect:/captura");
		if (!mensaje.equals("")) {
			System.out.println(mensaje);
			modelandview.addObject("mensaje",mensaje);
		}
		return modelandview; 
	}
	
}
