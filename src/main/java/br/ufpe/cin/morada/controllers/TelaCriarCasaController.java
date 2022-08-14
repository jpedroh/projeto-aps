package br.ufpe.cin.morada.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.util.Email;

@Controller
public class TelaCriarCasaController {
	@Autowired
	private Fachada fachada;

	@PostMapping("/criar-casa")
	public String criarCasa(@CookieValue(value = "email") String email, @RequestParam Map<String, String> params, Model model) {
		Casa casa = new Casa(params.get("nome"));
		fachada.criarCasa(casa, Email.from(email));
		model.addAttribute("casa", casa);
		return "casa-criada";
	}
}
