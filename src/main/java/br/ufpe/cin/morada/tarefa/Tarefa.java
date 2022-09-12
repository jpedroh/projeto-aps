package br.ufpe.cin.morada.tarefa;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;

@Entity
@Table(name = "tarefas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "parent_id", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	@OneToOne
	private Casa casa;

	private LocalDateTime dateTime;

	protected Tarefa() {

	}

	public Tarefa(String nome, Casa casa, LocalDateTime dateTime) {
		this.nome = nome;
		this.casa = casa;
		this.dateTime = dateTime;
	}

	public abstract void concluir();

	public abstract boolean isConcluido();

	public abstract Set<Pessoa> getResponsaveis();

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Casa getCasa() {
		return casa;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return id != other.id;
	}
}
