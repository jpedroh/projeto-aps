package br.ufpe.cin.morada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpe.cin.morada.controladores.Fachada;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.Email;

@Controller
public class TelaVerTarefasController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/ver-tarefas")
  public String verTarefas(@CookieValue(value = "email") String email, Model model) {
    Pessoa pessoa = fachada.buscarPessoa(Email.from(email));
    model.addAttribute("tarefas", fachada.buscarTarefas(pessoa.getCasa().getCodigo()));
    return "ver-tarefas";
  }

  @PostMapping("/concluir-tarefa")
  public String concluirTarefa(@RequestParam(name = "id") long idTarefa) {
    fachada.concluirTarefa(idTarefa);
    return "ver-tarefas";
  }
}
