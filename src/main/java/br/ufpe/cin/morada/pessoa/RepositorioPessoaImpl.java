package br.ufpe.cin.morada.pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.ufpe.cin.morada.util.Email;

public class RepositorioPessoaImpl implements IRepositorioPessoa {
	private static RepositorioPessoaImpl instance;
	private final Map<Email, Pessoa> pessoas = new HashMap<>();

	public static RepositorioPessoaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioPessoaImpl();
		}
		return instance;
	}

	public boolean existe(Email email) {
		return this.pessoas.get(email) != null;
	}

	public Optional<Pessoa> getByEmail(Email email) {
		return Optional.ofNullable(this.pessoas.get(email));
	}

	public void salvar(Pessoa pessoa) {
		this.pessoas.put(pessoa.getEmail(), pessoa);
	}
}
