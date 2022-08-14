package br.ufpe.cin.morada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpe.cin.morada.controladores.Fachada;

@Controller
public class TelaVerTarefasController {
  @Autowired
  private Fachada fachada;

  @GetMapping("/ver-tarefas")
  public String entrarCasa(@RequestParam(name = "codigoCasa") String codigoCasa, Model model) {
    model.addAttribute("tarefas", fachada.buscarTarefas(codigoCasa));
    return "ver-tarefas";
  }
}
