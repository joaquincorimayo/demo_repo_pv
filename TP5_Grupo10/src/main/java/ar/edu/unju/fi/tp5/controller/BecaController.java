package ar.edu.unju.fi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Beca;
import ar.edu.unju.fi.tp5.util.ListaBecas;

@Controller
@RequestMapping("/beca")
public class BecaController {
	private ListaBecas listabeca = new ListaBecas();

	@GetMapping("/nuevo")
	public String getFormularioBecaNuevoPage(Model model) {
		model.addAttribute("beca", new Beca());
		return "nuevo_beca";
	}

	@PostMapping("/guardar")
	public ModelAndView getListaBecaPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult br) {
		if (br.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_beca");
			mav.addObject("beca", beca);
			return mav;
		}

		ModelAndView mav = new ModelAndView("lista_becas");
		listabeca.getBecas().add(beca);
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}

	@GetMapping("/listaBecas")
	public ModelAndView getListadoBecaPage() {
		ModelAndView mav = new ModelAndView("lista_becas");
		mav.addObject("becas", listabeca.getBecas());
		return mav;
	}

}