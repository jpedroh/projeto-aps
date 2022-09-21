package br.ufpe.cin.morada.casa.http;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.cin.morada.casa.controladores.ControladorCasa;
import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.entidades.Pessoa;
import br.ufpe.cin.morada.casa.util.Email;

@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:5000")
public class CasaRestController {
  @Autowired
  private ControladorCasa controladorCasa;

  @PostMapping("/casas")
  public Casa criarCasa(@RequestBody Map<String, String> payload,
      @CookieValue(name = "email", required = true) Email email) {
    Casa casa = new Casa(payload.get("nome"));
    controladorCasa.criarCasa(casa, email);
    return casa;
  }

  @PostMapping("/casas/{codigo}/entrar")
  public void entrarCasa(@PathVariable String codigo, @CookieValue(name = "email", required = true) Email email) {
    controladorCasa.entrarCasa(codigo, email);
  }

  @PostMapping("/casas/{codigo}/sair")
  public void sairCasa(@PathVariable String codigo, @CookieValue(name = "email", required = true) Email email) {
    controladorCasa.sairCasa(codigo, email);
  }

  @GetMapping("/casas/{codigo}")
  public Casa buscar(@PathVariable String codigo) {
    return controladorCasa.buscar(codigo);
  }

  @GetMapping("/pessoas/me/casa")
  public Casa buscarCasaPorEmail(@CookieValue(name = "email", required = true) Email email) {
    return controladorCasa.buscarCasaPorEmail(email);
  }
}
