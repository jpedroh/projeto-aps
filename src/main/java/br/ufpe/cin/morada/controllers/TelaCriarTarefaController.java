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
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.tarefa.Tarefa;
import br.ufpe.cin.morada.tarefa.TarefaSimples;
import br.ufpe.cin.morada.util.DateTime;
import br.ufpe.cin.morada.util.Email;

@Controller
public class TelaCriarTarefaController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/nova-tarefa")
  public String novaTarefa(@CookieValue(value = "email", required = false) String email, Model model) {
    if (email == null) {
      return "redirect:/login";
    }

    Pessoa pessoa = fachada.buscarPessoa(Email.from(email));
    model.addAttribute("casa", pessoa.getCasa());

    return "nova-tarefa";
  }

  @PostMapping("/nova-tarefa")
  public String novaTarefa(@CookieValue(value = "email") String email, @RequestParam Map<String, String> params) {
    if (email == null) {
      return "redirect:/login";
    }

    Pessoa responsavel = fachada.buscarPessoa(Email.from(params.get("responsavel")));
    Casa casa = fachada.buscarCasa(params.get("casa"));
    DateTime dataHora = new DateTime(params.get("data"), params.get("hora"));
    Tarefa tarefa = new TarefaSimples(params.get("nome"), casa, dataHora, responsavel);

    fachada.inserirTarefa(tarefa);

    return "redirect:/";
  }
}
