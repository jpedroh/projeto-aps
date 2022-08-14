package br.ufpe.cin.morada.tarefa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.DateTime;

public class TarefaComplexa extends Tarefa {
  List<Tarefa> subTarefas;

  public TarefaComplexa(String nome, Casa casa, DateTime dateTime) {
    super(nome, casa, dateTime);
  }

  @Override
  public void concluir() {
    this.subTarefas.forEach(Tarefa::concluir);
  }

  @Override
  public boolean isConcluido() {
    return this.subTarefas.stream().allMatch(Tarefa::isConcluido);
  }

  @Override
  public Set<Pessoa> getResponsaveis() {
    final Set<Pessoa> responsaveis = new HashSet<>();

    this.subTarefas.forEach(subTarefa -> {
      responsaveis.addAll(subTarefa.getResponsaveis());
    });

    return responsaveis;
  }

}
