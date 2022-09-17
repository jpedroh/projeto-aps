package br.ufpe.cin.morada.auth.dados;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.auth.entidades.Pessoa;
import br.ufpe.cin.morada.auth.util.Email;

@Component
public class RepositorioPessoaImpl implements IRepositorioPessoa {
	@Autowired
	private PessoaDAO pessoaDAO;

	private RepositorioPessoaImpl() {
	}

	public boolean existe(Email email) {
		return pessoaDAO.existsById(email);
	}

	public Optional<Pessoa> getByEmail(Email email) {
		return pessoaDAO.findById(email);
	}

	public void salvar(Pessoa pessoa) {
		pessoaDAO.save(pessoa);
	}
}
