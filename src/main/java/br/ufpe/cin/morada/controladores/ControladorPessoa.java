package br.ufpe.cin.morada.controladores;

import br.ufpe.cin.morada.pessoa.IRepositorioPessoa;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.subsistemaGoogle.ISubsistemaGoogle;
import br.ufpe.cin.morada.util.Email;

public class ControladorPessoa {
	private IRepositorioPessoa repositorioPessoa;
	private ISubsistemaGoogle subsistemaGoogle;

	public Pessoa cadastrar(String token) {
		Pessoa pessoa = subsistemaGoogle.getDadosFromToken(token);
		if (repositorioPessoa.existe(pessoa.getEmail())) {
			throw new RuntimeException("A pessoa já está cadastrada no sistema");
		}
		repositorioPessoa.salvar(pessoa);
		return pessoa;
	}

	public Pessoa logar(String token) {
		Pessoa pessoa = subsistemaGoogle.getDadosFromToken(token);
		if (!repositorioPessoa.existe(pessoa.getEmail())) {
			throw new RuntimeException("A pessoa não está cadastrada no sistema");
		}
		return pessoa;
	}

	public Pessoa buscar(Email email) {
		return repositorioPessoa.getByEmail(email);
	}
}
