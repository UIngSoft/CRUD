package com.cest.Controllers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value="/reportarElemento")
	public String getReporte(Model modelo) {
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "reporte";
	}
	
	@PostMapping(value="/reportarElemento")
	public ModelAndView postReporte(@RequestParam("tipoelemento") String tipoelemento
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
		reporteDao.save(reporte);
		return new ModelAndView("redirect:/");
	}

}
