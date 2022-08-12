package br.ufpe.cin.morada.controladores;

import br.ufpe.cin.morada.tarefa.Tarefa;

import java.util.List;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;

public class Fachada {
	private ControladorPessoa controladorPessoa;
	private ControladorTarefa controladorTarefa;
	private ControladorCasa controladorCasa;

	public void cadastrar(String token) {

	}

	public void logar(String token) {

	}

	public void inserirTarefa(Tarefa tarefa) {

	}

	public void concluirTarefa(long id) {
		controladorTarefa.concluirTarefa(id);
	}

	public void excluirTarefa(long id) {
		controladorTarefa.excluirTarefa(id);
	}

	public List<Tarefa> buscarTarefas(String codigoCasa) {
		Casa casa = controladorCasa.buscar(codigoCasa);
		return controladorTarefa.buscarTarefas(casa);
	}

	public void criarCasa(Casa casa, String email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.criarCasa(casa, membro);
	}

	public void entrarCasa(String codigo, String email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.entrarCasa(codigo, membro);
	}

	public void sairCasa(String codigo, String email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.sairCasa(codigo, membro);
	}
}
