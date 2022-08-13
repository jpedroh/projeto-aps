package br.ufpe.cin.morada.controllers;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.util.Email;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.casa.Casa;

public class TelaCriarCasaController {

	private Fachada fachada;

	@GetMapping("/criar-casa")
	public String criarCasa(@CookieValue(value = "email") String email, String nome, Model model) {
		Casa casa = fachada.criarCasa(new Casa("nome"), Email.from(email));
		model.addAttribute("casa", casa);
		return "/casa";
	}
}
