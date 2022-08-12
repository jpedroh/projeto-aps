package br.ufpe.cin.morada.tarefa;

import java.util.HashSet;
import java.util.Set;

import br.ufpe.cin.morada.pessoa.Pessoa;

public class TarefaSimples extends Tarefa {
  private Pessoa responsavel;
  private boolean concluido;

  @Override
  public void concluir() {
    this.concluido = true;
  }

  @Override
  public boolean isConcluido() {
    return this.concluido;
  }

  @Override
  public Set<Pessoa> getResponsaveis() {
    final Set<Pessoa> responsaveis = new HashSet<>();
    responsaveis.add(this.responsavel);
    return responsaveis;
  }
}
