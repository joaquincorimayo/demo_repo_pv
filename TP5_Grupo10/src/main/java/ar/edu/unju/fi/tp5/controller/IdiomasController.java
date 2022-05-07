package ar.edu.unju.fi.tp5.controller;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.model.Docente;

@Controller
public class IdiomasController {
	@GetMapping("/idiomas")
	public String getIndex(Model model) {
		// Creacion de objeto (Curso) para visualizar en el contexto de la pagina web.
		// Se creara un arraylist para agruparlos
		LocalDate fechaInicio = LocalDate.of(1980, 4, 9);;
		LocalDate fechaFin = LocalDate.of(1980, 4, 9);;
		Docente docente1 = new Docente(1234, "Joaquin", "Corimayo", "algun_correo@gmail.com", 38835331);
		Curso primero = new Curso(1, "Frances basico", "idiomas", fechaFin, fechaInicio, 4, "Virtual", docente1);
		model.addAttribute("primerIdioma", primero);
		return "idiomas";
	}
}
