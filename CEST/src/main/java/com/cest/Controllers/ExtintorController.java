package com.cest.Controllers;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.BloqueDAO;
import com.cest.Dao.ContratoDAO;
import com.cest.Dao.ElementoDAO;
import com.cest.Dao.EncargadoDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.FichatecnicaDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Contrato;
import com.cest.Models.Elemento;
import com.cest.Models.Encargado;
import com.cest.Models.Extintor;
import com.cest.Models.Fichatecnica;
import com.cest.Models.Piso;
import com.cest.Models.Sede;
import com.cest.Services.ExtintorService;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {
	
	@Autowired
	private FichatecnicaDAO fichatecnicaDao;
	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private ExtintorDAO extintorDao;
	@Autowired
	private ExtintorService extintorService;
	@Autowired
	private EncargadoDAO encargadoDao;
	@Autowired
	private ContratoDAO contratoDao;
	@Autowired
	private ElementoDAO elementoDao;
	@Autowired
	private BloqueDAO bloqueDao;
	@Autowired 
	private PisoDAO pisoDao;
	


	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrarExtintor(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		modelo.addAttribute("sedes", sedeDao.findAll());
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "registrarExtintor";
	}
	
	@PostMapping(value = "/registrarExtintor")
	public ModelAndView postRegistrarExtintor(Model modelo, @ModelAttribute("extintor") Extintor extintor, BindingResult rsult
			, @RequestParam("cedulaencargado") String cedulaencargado
			, @RequestParam("numerocontrato") String numerocontrato
			, @RequestParam("sede") String nombresede
			, @RequestParam("bloque") String letrabloque
			, @RequestParam("piso") String numeropiso
			, @RequestParam("fichatecnica") String tipo
			, @RequestParam("fechaultimarecarga") String fecharecarga)
	{
		Elemento elemento = BuscarElemento(extintor.getIdelemento());
		if (elemento != null) {
			extintor.setElemento(elemento);
		}else {
			elemento = registrarElemento(extintor.getIdelemento(), nombresede, letrabloque, numeropiso, cedulaencargado, numerocontrato);
			extintor.setElemento(elemento);
		}
		String[] fechaRecarga = fecharecarga.split("-");
		Fichatecnica fichatecnica = BuscarFichatecnica(tipo);
		extintor.setFichatecnica(fichatecnica);	
		extintor.setFechaultimarecarga(LocalDate.of(Integer.valueOf(fechaRecarga[0])
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		extintor.setFechavencimiento(LocalDate.of(Integer.valueOf(fechaRecarga[0])+Integer.valueOf(extintor.getCaducidadanios())
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		extintorDao.save(extintor);
		return new ModelAndView("redirect:/consulta?tipo=extintor");
	}

	public Elemento BuscarElemento(int idelemento) {
		Elemento elemento = null;
		for (Elemento e : elementoDao.findAll()) {
			if (e.getId() == idelemento) {
				elemento = e;
			}
		}
		return elemento;
	}
	
	public Fichatecnica BuscarFichatecnica(String tipo) {
		Fichatecnica fichatecnica = null;
		for (Fichatecnica f : fichatecnicaDao.findAll()) {
			if (f.getTipo().equals(tipo)) {
				fichatecnica = f;
			}
		}
		return fichatecnica;
	}
	
	@GetMapping(value = "/actualizarExtintor")
	public String getActualizar() {
		return "actualizarExtintor2";
	}
	
	@PostMapping(value = "/obtenerExtintor")
	@ResponseBody
	public Extintor getExtintor(@RequestParam String id) {
		for (Extintor extintor : extintorDao.findAll()) {
			if (extintor.getIdelemento() == Integer.valueOf(id)) {
				return  extintor;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/actualizarExtintor")
	public ModelAndView postActualizar(@RequestParam("id") String id
			, @RequestParam("cedulaencargado") String cedulaencargado
			, @RequestParam("numerocontrato") String numerocontrato
			, @RequestParam("sede") String nombresede
			, @RequestParam("bloque") String letrabloque
			, @RequestParam("piso") String numeropiso
			, @RequestParam("fichatecnica") String tipo
			, @RequestParam("estado") String estado
			, @RequestParam("fechaultimarecarga") String fecharecarga)
	{
		for (Extintor extintor : extintorDao.findAll()) {
			if (extintor.getIdelemento() == Integer.valueOf(id)) {
				System.out.println("ENCONTRADO PARA ACTUALIZAR!!");
				//extintor.setEstado(estado);
			}
		}
		return new ModelAndView("redirect:/consulta?tipo=extintor");
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
		for (Contrato c : contratoDao.findAll()) {
			if (c.getNumero() == Integer.valueOf(numerocontrato)) {
				contrato = c;
			}
		}
		Sede sede = null;
		for (Sede s : sedeDao.findAll()) {
			if (s.getNombre().equals(nombresede)) {
				sede = s;
			}
		}
		Bloque bloque = null;
		for (Bloque b : bloqueDao.findAll()) {
			if (b.getBloquePk().getLetra().equals(letrabloque) && b.getSede()==sede) {
				bloque = b;
			}
		}
		Piso piso = null;
		for (Piso p : pisoDao.findAll()) {
			if (p.getPisoPk().getNumero() == Integer.valueOf(numeropiso) && p.getBloque() == bloque) {
				piso = p;
			}
		}
		Elemento elemento = null;
		if (encargado != null) {
			if (contrato != null) {
				elemento = new Elemento();
				elemento.setId(id);
				elemento.setContrato(contrato);
				elemento.setEncargado(encargado);
				elemento.setPiso(piso);
				elementoDao.save(elemento);
			}
		}
		return elemento;
	}
	
}