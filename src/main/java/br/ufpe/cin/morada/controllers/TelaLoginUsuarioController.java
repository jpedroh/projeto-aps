package br.ufpe.cin.morada.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.pessoa.Pessoa;

@Controller
public class TelaLoginUsuarioController {
  private Fachada fachada;

  public TelaLoginUsuarioController(Fachada fachada) {
    this.fachada = fachada;
  }

  @GetMapping("/login")
  public String view() {
    return "login";
  }

  @PostMapping("/login")
  public String logarUsuario(@RequestBody String token, HttpServletResponse response, Model model) {
    Pessoa pessoa = fachada.logar(token.substring("id_token=".length()));
    response.addCookie(new Cookie("email", pessoa.getEmail().getValor()));
    return "redirect:/";
  }
}
