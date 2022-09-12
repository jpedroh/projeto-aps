package br.ufpe.cin.morada.tarefa;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;

@Entity
@Table(name = "tarefas")
@DiscriminatorValue("null")
public class TarefaComplexa extends Tarefa {
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "parent_id")
  List<Tarefa> subTarefas;

  private TarefaComplexa() {
    super();
  }

  public TarefaComplexa(String nome, Casa casa, LocalDateTime dateTime) {
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
