package br.ufpe.cin.morada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.tarefa.IRepositorioTarefa;
import br.ufpe.cin.morada.tarefa.Tarefa;

@Component
public class ControladorTarefa {
	@Autowired
	private IRepositorioTarefa repositorioTarefa;

	public void inserirTarefa(Tarefa tarefa) {
		repositorioTarefa.salvar(tarefa);
	}

	public void concluirTarefa(long id) {
		Tarefa tarefa = repositorioTarefa.buscar(id);
		tarefa.concluir();
		repositorioTarefa.salvar(tarefa);
	}

	public void excluirTarefa(long id) {
		Tarefa tarefa = repositorioTarefa.buscar(id);
		repositorioTarefa.excluir(tarefa);
	}

	public List<Tarefa> buscarTarefas(Casa casa) {
		return repositorioTarefa.buscarTodos(casa);
	}

	public void agruparTarefas(long parent, long child) {
		// TODO
	}
}
