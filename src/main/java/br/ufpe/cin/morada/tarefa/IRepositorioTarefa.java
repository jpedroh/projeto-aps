package br.ufpe.cin.morada.tarefa;

import morada.casa.Casa;

public interface IRepositorioTarefa {

	public Tarefa[] buscarTodos(Casa casa);

	public Tarefa buscar(long id);

	public void salvar(Tarefa tarefa);

	public void excluir(Tarefa tarefa);

}
