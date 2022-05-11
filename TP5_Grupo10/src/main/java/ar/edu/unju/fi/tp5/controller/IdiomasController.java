package ar.edu.unju.fi.tp5.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tp5.model.Curso;
import ar.edu.unju.fi.tp5.model.Docente;

@Controller
public class IdiomasController {
	@GetMapping("/idiomas")
	public String getIndex(Model model) {
		
		/* 
		 * _> Se crea un arraylist con 5 objetos de tipo cursos. 
		 * -> Se utilizan datos aleatorios.
		 * -> En vista (idiomas.html) 
		 * 	-> Se recorre el arraylist cargado mediante un each. 
		 * 	-> Se encuentra un error al establecer duracion entre semanas.
		 * @jc
		 *  */
		
		LocalDate fechaInicio, fechaFin;
		Docente docente;
		Curso curso;
		ArrayList<Curso> cursosDisponibles = new ArrayList<Curso>();
		// Primer objeto
		fechaInicio = LocalDate.of(2022, 2, 14);
		fechaFin = LocalDate.of(2022, 2, 21);
		docente = new Docente(1522156, "Len", "Severiano", "algun_correo@gmail.com", "1060444526");
		curso = new Curso(1, "Alemán", "Diploma Ciclo Básico", fechaFin, fechaInicio, 4, "Virtual", docente);
		cursosDisponibles.add(curso);
		// Segundo objeto
		fechaInicio = LocalDate.of(2022, 3, 5);
		fechaFin = LocalDate.of(2022, 3, 17);
		docente = new Docente(1522156, "Romilda", "Zosimo", "algun_correo@gmail.com", "451690179");
		curso = new Curso(1, "Árabe", "Diploma Ciclo de Perfeccionamiento", fechaFin, fechaInicio, 5, "Presencial", docente);
		cursosDisponibles.add(curso);
		// Tercer objeto
		fechaInicio = LocalDate.of(2022, 6, 14);
		fechaFin = LocalDate.of(2022, 6, 21);
		docente = new Docente(1522156, "Winema", "Whitney", "algun_correo@gmail.com", "667897057");
		curso = new Curso(1, "Chino", "Diploma Ciclo Superior", fechaFin, fechaInicio, 4, "Presencial", docente);
		cursosDisponibles.add(curso);
		// Cuarto objeto
		fechaInicio = LocalDate.of(2022, 8, 5);
		fechaFin = LocalDate.of(2022, 8, 17);
		docente = new Docente(1522156, "Neil", "Lewa", "algun_correo@gmail.com", "561725305");
		curso = new Curso(1, "Coreano", "Diploma Ciclo Básico", fechaFin, fechaInicio, 2, "Presencial", docente);
		cursosDisponibles.add(curso);
		// Quinto objeto
		fechaInicio = LocalDate.of(2022, 11, 10);
		fechaFin = LocalDate.of(2022, 11, 24);
		docente = new Docente(1522156, "Wiñay", "Mangena", "algun_correo@gmail.com", "660527966");
		curso = new Curso(1, "Hindi", "Diploma Ciclo Superior", fechaFin, fechaInicio, 6, "Virtual", docente);
		cursosDisponibles.add(curso);
		
		model.addAttribute("cursos", cursosDisponibles);
		return "idiomas";
	}
	
}
