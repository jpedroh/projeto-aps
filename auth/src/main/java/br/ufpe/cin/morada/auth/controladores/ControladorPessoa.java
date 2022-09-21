package br.ufpe.cin.morada.auth.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.auth.dados.IRepositorioPessoa;
import br.ufpe.cin.morada.auth.entidades.Pessoa;
import br.ufpe.cin.morada.auth.subsistemaGoogle.ISubsistemaGoogle;
import br.ufpe.cin.morada.auth.util.Email;

@Component
public class ControladorPessoa {
	@Autowired
	private IRepositorioPessoa repositorioPessoa;
	@Autowired
	private ISubsistemaGoogle subsistemaGoogle;

	public Pessoa logar(String token) {
		Pessoa pessoa = subsistemaGoogle.getDadosFromToken(token);
		repositorioPessoa.salvar(pessoa);
		return pessoa;
	}

	public Pessoa buscar(Email email) {
		return repositorioPessoa.getByEmail(email)
				.orElseThrow(() -> new PessoaNaoEncontradaException(email));
	}
}
