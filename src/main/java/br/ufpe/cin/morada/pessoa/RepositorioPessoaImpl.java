package br.ufpe.cin.morada.pessoa;

public class RepositorioPessoaImpl implements IRepositorioPessoa {

	private static RepositorioPessoaImpl instance;

	private Pessoa[] pessoa;

	public static RepositorioPessoaImpl getInstance() {
		return null;
	}

	public boolean existe(string email) {
		return false;
	}

	public Pessoa getByEmail(string email) {
		return null;
	}

	public void salvar(Pessoa pessoa) {

	}

}
