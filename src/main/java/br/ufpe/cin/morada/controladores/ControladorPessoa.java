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
	private IRepositorioPessoa repositorioPessoa = RepositorioPessoaImpl.getInstance();
	@Autowired
	private ISubsistemaGoogle subsistemaGoogle;

	public Pessoa logar(String token) {
		Pessoa pessoa = subsistemaGoogle.getDadosFromToken(token);
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
