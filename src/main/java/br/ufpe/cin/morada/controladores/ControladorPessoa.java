package br.ufpe.cin.morada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.pessoa.IRepositorioPessoa;
import br.ufpe.cin.morada.pessoa.Pessoa;
import br.ufpe.cin.morada.pessoa.RepositorioPessoaImpl;
import br.ufpe.cin.morada.subsistemaGoogle.ISubsistemaGoogle;
import br.ufpe.cin.morada.util.Email;

@Component
public class ControladorPessoa {
	@Autowired
	private IRepositorioPessoa repositorioPessoa;
	@Autowired
	private ISubsistemaGoogle subsistemaGoogle;

	public Pessoa logar(String token) {
		Pessoa pessoa = subsistemaGoogle.getDadosFromToken(token);
		Pessoa pessoaDb = repositorioPessoa.getByEmail(pessoa.getEmail());

		if (pessoaDb != null) {
			pessoa.setCasa(pessoaDb.getCasa());
		}

		repositorioPessoa.salvar(pessoa);
		return pessoa;
	}

	public Pessoa buscar(Email email) {
		Pessoa pessoa = repositorioPessoa.getByEmail(email);
		if (pessoa == null) {
			throw new IllegalArgumentException("Não foi possível encontrar uma pessoa com o email " + email);
		}
		return pessoa;
	}
}
