package br.ufpe.cin.morada.tarefa;

import java.util.Set;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.util.DateTime;

public abstract class Tarefa {
	private long id;

	private String nome;

	private Casa casa;

	private DateTime dateTime;

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

	public DateTime getDateTime() {
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
