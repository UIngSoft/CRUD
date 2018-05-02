package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.UsuarioDAO;
import com.cest.Models.Usuario;

/**
 * Controla el ingreso a sesiones 
 * @author Santiago granada aguirre
 */
@Controller
@RequestMapping
public class LoginController {

    /**
     * verifica que el usuario exista y ademas que coincida con la contraseña
     * ingresada
     *
     * @param user usuario con el cual se ingresa sesion
     * @param password contraseña correspondiente a este usuario
     * @return vista principal
     */
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@GetMapping(value = "/iniciarSesion")
	public String GET(Model modelo) {
		modelo.addAttribute("usuario",new Usuario());
		return "login";
	}
	
	@PostMapping(value = "/iniciarSesion")
	public ModelAndView POST(Model modelo,@ModelAttribute Usuario usuario) {
		ModelAndView modelandview = null;
		System.out.println("Find all: "+usuarioDao.findAll().toString());
		for (Usuario user : usuarioDao.findAll()) {
			System.out.println("Usuario: "+user.getUsuario()+ " Contraseña: " + user.getContrasena());
			if (usuario.getUsuario().equals(user.getUsuario()) && usuario.getContrasena().equals(user.getContrasena())) {
				modelandview = new ModelAndView("redirect:/home");
				System.out.println("Encontro");
			}else {
				System.out.println("No hay registros");
				modelandview = new ModelAndView("redirect:/iniciarSesion");
			}
		}
		return modelandview; 
	}

}
