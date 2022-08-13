package br.ufpe.cin.morada.controladores;

import br.ufpe.cin.morada.tarefa.Tarefa;
import br.ufpe.cin.morada.util.Email;

import java.util.List;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.pessoa.Pessoa;

public class Fachada {
	private ControladorPessoa controladorPessoa;
	private ControladorTarefa controladorTarefa;
	private ControladorCasa controladorCasa;

	public void cadastrar(String token) {

	}

	public Pessoa logar(String token) {
		return controladorPessoa.logar(token);
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

	public Casa criarCasa(Casa casa, Email email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.criarCasa(casa, membro);
		return casa;
	}

	public void entrarCasa(String codigo, Email email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.entrarCasa(codigo, membro);
	}

	public void sairCasa(String codigo, Email email) {
		Pessoa membro = controladorPessoa.buscar(email);
		controladorCasa.sairCasa(codigo, membro);
	}
}
