package br.ufpe.cin.morada.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.pessoa.Pessoa;

@Controller
public class TelaLoginController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/login")
  public String view() {
    return "login";
  }

  @PostMapping("/login")
  public String logarUsuario(@RequestParam(name = "id_token") String token, HttpServletResponse response, Model model) {
    Pessoa pessoa = fachada.logar(token);
    response.addCookie(new Cookie("email", pessoa.getEmail().getValor()));
    return "redirect:/";
  }
}
