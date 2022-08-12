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
}
