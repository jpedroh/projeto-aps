package br.ufpe.cin.morada.tarefa;

import br.ufpe.cin.morada.casa.Casa;

import java.util.List;

public class RepositorioTarefaImpl implements IRepositorioTarefa {

	private static RepositorioTarefaImpl instance;

	private Tarefa[] tarefa;

	public static RepositorioTarefaImpl getInstance() {
		return null;
	}

	public List<Tarefa> buscarTodos(Casa casa) {
		return null;
	}

	public void salvar(Tarefa tarefa) {

	}

	public Tarefa buscar(long id) {
		return null;
	}

	public void excluir(Tarefa tarefa) {

	}

}
