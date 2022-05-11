package ar.edu.unju.fi.tp5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	Logger logger = LoggerFactory.getLogger(DocenteController.class);
	private ListaDocente listaDocente = new ListaDocente();
	
	@GetMapping("/nuevo")
	public String getFormularioDocenteNuevoPage(Model model) {
		model.addAttribute("docente", new Docente());
		logger.info(
				"Method: getFormularioDocenteNuevoPage() - Information: Se envia un objeto Docente a la pagina nuevo_docente");
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaDocentePage(@ModelAttribute("docente") Docente docente) {
		ModelAndView mav = new ModelAndView("lista_docentes");
		// recupero el arrayList y agrego un objeto docente a lista
		if (listaDocente.getDocentes().add(docente)) {
			logger.info("Method: getListaDocentePage() - Information: Se agregó un objeto al arrayList de docente");
		}
		// enviar el arrayList de docente a la página lista_docente
		mav.addObject("docentes", listaDocente.getDocentes());
		return mav;
	}
	
	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", listaDocente.getDocentes());
		return mav;
	}
	
}
