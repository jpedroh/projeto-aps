package br.ufpe.cin.morada.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.pessoa.Pessoa;

public class TelaLoginUsuarioController {
  private Fachada fachada;

  public TelaLoginUsuarioController(Fachada fachada) {
    this.fachada = fachada;
  }

  @GetMapping("/login")
  public String logarUsuario(String token, HttpServletResponse response, Model model) {
    Pessoa pessoa = fachada.logar(token);
    response.addCookie(new Cookie("email", pessoa.getEmail().getValor()));
    return "/";
  }
}
