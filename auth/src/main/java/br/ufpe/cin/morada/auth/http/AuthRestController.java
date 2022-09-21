package br.ufpe.cin.morada.auth.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.cin.morada.auth.controladores.ControladorPessoa;
import br.ufpe.cin.morada.auth.entidades.Pessoa;
import br.ufpe.cin.morada.auth.util.Email;

@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:5000")
public class AuthRestController {
  @Autowired
  ControladorPessoa controladorPessoa;

  @PostMapping("/login")
  public Pessoa login(@RequestParam(name = "id_token") String token, HttpServletResponse response) {
    return controladorPessoa.logar(token);
  }

  @GetMapping("/users/me")
  public Pessoa me(@CookieValue(value = "email", required = true) Email email) {
    return controladorPessoa.buscar(email);
  }

  @GetMapping("/users/{email}")
  public Pessoa get(@PathVariable Email email) {
    return controladorPessoa.buscar(email);
  }
}
