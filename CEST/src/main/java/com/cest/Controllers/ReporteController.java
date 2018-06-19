package com.cest.Controllers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ReporteDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Reporte;

@Controller
@RequestMapping
public class ReporteController {
	@Autowired
	private SedeDAO sedeDao;
	
	@Autowired
	private ReporteDAO reporteDao;
	
	
	
	
	@GetMapping(value="/registrarReporte")
	public String getRegistrarReporte(Model modelo) {
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "reporte";
	}
	
	@PostMapping(value="/registrarReporte")
	public ModelAndView postRegistrarReporte(@RequestParam("tipoelemento") String tipoelemento
			,@RequestParam("sede") String sede
			,@RequestParam("bloque") String bloque
			,@RequestParam("piso") String piso
			,@RequestParam("descripcion") String descripcion) 
	{
		Reporte reporte = new Reporte();
		reporte.setTipoelemento(tipoelemento);
		Calendar fecha = new GregorianCalendar();
		reporte.setFechareporte(LocalDate.of(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH) + 1,fecha.get(Calendar.DAY_OF_MONTH)));
		reporte.setDescripcion(descripcion);
		reporte.setEstado("Pendiente");
		reporte.setUbicacion("Sede: "+sede+" Bloque: "+bloque+" Piso: "+piso);
		reporte.setLeido("No");
		reporte.setNotificado("No");
		reporteDao.save(reporte);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping(value="/cambiarNotificado")
	@ResponseBody
	public Reporte cambiarNotificado(@RequestParam int id)
	{
		System.out.println("Buscando a "+id);
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getId() == id) {
				reporte.setNotificado("Si");
				reporteDao.save(reporte);
				return reporte;
			}
		}
		return null;
	}

	@PostMapping(value = "/buscarCambioBD")
	@ResponseBody
	public List<Reporte> getCambio() {
		List<Reporte> reportes = new LinkedList<>();
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getLeido().equalsIgnoreCase("No")) {
				reportes.add(reporte);
			}
		}
		return reportes;
	}

	@GetMapping(value = "/consultarReporte")
	public List<Reporte> getConsultarReporte() {
		List<Reporte> reportes = new LinkedList<>();
		for (Reporte reporte : reporteDao.findAll()) {
			reportes.add(reporte);
		}
		return reportes;
	}
	
	
	@GetMapping(value = "/modificarReporte")
	public Reporte getModificarReporte(@RequestParam int id) {
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getId() == id) {
				return reporte;
			}
		}
		return null;
		
	}
	@PostMapping(value = "/modificarReporte")
	public ModelAndView postModificarReporte(@RequestParam("id") int id,
			@RequestParam("fecha") LocalDate  fecha,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("argumentacion") String argumentacion,
			@RequestParam("estado") String estado,
			@RequestParam("visibilidad") String visibilidad
			) {
		
		for (Reporte reporte1 : reporteDao.findAll()) {
			if (reporte1.getId() == id) {
				Reporte reporte = reporte1;
				reporte.setFechareporte(fecha);
				reporte.setDescripcion(descripcion);
				reporte.setArgumento(argumentacion);
				reporte.setEstado(estado);
				reporte.setLeido(visibilidad);
				reporteDao.save(reporte);
				
				return new ModelAndView("redirect:/consultarReporte");
			}
		}
		
		return null;
	}
	
}
