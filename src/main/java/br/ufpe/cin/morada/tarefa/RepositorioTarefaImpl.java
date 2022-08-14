package br.ufpe.cin.morada.tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufpe.cin.morada.casa.Casa;

public class RepositorioTarefaImpl implements IRepositorioTarefa {
	private long nextId = 1;
	private static RepositorioTarefaImpl instance;
	private List<Tarefa> tarefas = new ArrayList<>();

	public static RepositorioTarefaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioTarefaImpl();
		}
		return instance;
	}

	public List<Tarefa> buscarTodos(Casa casa) {
		return this.tarefas.stream().filter(t -> t.getCasa().equals(casa)).collect(Collectors.toList());
	}

	public void salvar(Tarefa tarefa) {
		tarefa.setId(nextId);
		nextId++;
		this.tarefas.add(tarefa);
	}

	public Tarefa buscar(long id) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				return tarefa;
			}
		}
		return null;
	}

	public void excluir(Tarefa tarefa) {
		tarefas.remove(tarefa);
	}
}
