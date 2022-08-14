package br.ufpe.cin.morada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.Email;

@Controller
public class TelaInicialController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/")
  public String home(@CookieValue(value = "email", required = false) String email, Model model) {
    if (email == null) {
      return "redirect:/login";
    }
    Pessoa pessoa = fachada.buscarPessoa(Email.from(email));
    model.addAttribute("pessoa", pessoa);
    return pessoa.hasCasa() ? "home" : "sem-casa";
  }
}
