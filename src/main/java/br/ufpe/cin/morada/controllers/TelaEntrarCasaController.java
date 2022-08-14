package br.ufpe.cin.morada.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.util.Email;

@Controller()
public class TelaEntrarCasaController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/entrar-casa")
	public String entrarCasa(@CookieValue(value = "email") String email, @RequestParam Map<String, String> params, Model model) {
		fachada.entrarCasa(params.get("codigo"), Email.from(email));
		return "redirect:/";
	}
}
