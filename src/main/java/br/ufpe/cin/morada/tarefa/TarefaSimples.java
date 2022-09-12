package br.ufpe.cin.morada.tarefa;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;

@Entity
@Table(name = "tarefas")
@DiscriminatorValue("not null")
public class TarefaSimples extends Tarefa {
  @OneToOne
  @JoinColumn(name = "responsavel_email")
  private Pessoa responsavel;
  private boolean concluido;

  private TarefaSimples() {
    super();
  }

  public TarefaSimples(String nome, Casa casa, LocalDateTime dateTime, Pessoa responsavel) {
    super(nome, casa, dateTime);
    this.responsavel = responsavel;
    this.concluido = false;
  }

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
