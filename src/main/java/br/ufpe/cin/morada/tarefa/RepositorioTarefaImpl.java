package br.ufpe.cin.morada.tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.casa.Casa;

@Component
public class RepositorioTarefaImpl implements IRepositorioTarefa {
	private static RepositorioTarefaImpl instance;

	@Autowired
	private TarefaDAO tarefasDAO;

	public static RepositorioTarefaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioTarefaImpl();
		}
		return instance;
	}

	public List<Tarefa> buscarTodos(Casa casa) {
		return this.tarefasDAO.findAllByCasa(casa);
	}

	public void salvar(Tarefa tarefa) {
		tarefasDAO.save(tarefa);
	}

	public Tarefa buscar(long id) {
		return tarefasDAO.findById(id).get();
	}

	public void excluir(Tarefa tarefa) {
		tarefasDAO.delete(tarefa);
	}
}
