package br.ufpe.cin.morada.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.controladores.Fachada;

@Controller()
public class TelaEntrarCasaController {

	private Fachada fachada;

	@GetMapping("/")
	public String entrarCasa(String codigo) {
		return "index";
	}
}
