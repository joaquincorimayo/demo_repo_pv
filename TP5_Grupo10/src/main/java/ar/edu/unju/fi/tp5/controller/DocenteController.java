package ar.edu.unju.fi.tp5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public ModelAndView getListaDocentePage(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_docentes");
		if (listaDocente.getDocentes().add(docente)) {
			logger.info("Method: getListaDocentePage() - Information: Se agregó un objeto al arrayList de docente");
		}
		mav.addObject("docentes", this.listaDocente.getDocentes());
		return mav;
	}

	@GetMapping("/listaDocentes")
	public ModelAndView getListadoDocentesPage() {
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("docentes", this.listaDocente.getDocentes());
		return mav;
	}

}
