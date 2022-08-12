package br.ufpe.cin.morada.tarefa;

import java.util.List;

import br.ufpe.cin.morada.casa.Casa;

public interface IRepositorioTarefa {

	public List<Tarefa> buscarTodos(Casa casa);

	public Tarefa buscar(long id);

	public void salvar(Tarefa tarefa);

	public void excluir(Tarefa tarefa);

}
