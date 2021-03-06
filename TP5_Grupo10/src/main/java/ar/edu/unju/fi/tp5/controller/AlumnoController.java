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

import ar.edu.unju.fi.tp5.model.Alumno;
import ar.edu.unju.fi.tp5.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	private ListaAlumnos listaAlumno = new ListaAlumnos();

	@GetMapping("/nuevo")
	public String getFormularioAlumnoNuevoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		logger.info(
				"Method: getFormularioAlumnoNuevoPage() - Information: Se envia un objeto Alumno a la pagina nuevo_alumno");
		return "nuevo_alumno";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}

		ModelAndView mav = new ModelAndView("lista_alumnos");
		if (this.listaAlumno.getAlumnos().add(alumno)) {
			logger.info("Method: getListaAlumnoPage() - Information: Se agregó un objeto al arrayList de alumno");
		}
		mav.addObject("alumnos", this.listaAlumno.getAlumnos());
		return mav;
	}

	@GetMapping("/listaAlumnos")
	public ModelAndView getListadoAlumnoPage() {
		logger.info("Method: getListadoAlumnoPage() - Information: Se visualiza los alumnos registrados");
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("alumnos", this.listaAlumno.getAlumnos());
		return mav;
	}

}
