package br.ufpe.cin.morada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.util.Email;

@Controller
public class TelaInicialController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/")
  public String home(@CookieValue(value = "email") String email, Model model) {
    if (email == null) {
      return "redirect:/login";
    }
    model.addAttribute("pessoa", fachada.buscarPessoa(Email.from(email)));
    return "sem-casa";
  }
}
