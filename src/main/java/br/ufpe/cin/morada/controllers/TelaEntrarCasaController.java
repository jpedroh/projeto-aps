package br.ufpe.cin.morada.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.util.Email;

@Controller()
public class TelaEntrarCasaController {

	private Fachada fachada;

	@GetMapping("/entrar-casa")
	public String entrarCasa(@CookieValue(value = "email") String email, String codigo) {
		fachada.entrarCasa(codigo, Email.from(email));
		return "/casa";
	}
}
