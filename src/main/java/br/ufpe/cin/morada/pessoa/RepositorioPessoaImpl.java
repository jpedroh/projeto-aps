package br.ufpe.cin.morada.pessoa;

public class RepositorioPessoaImpl implements IRepositorioPessoa {

	private static RepositorioPessoaImpl instance;

	private Pessoa[] pessoa;

	public static RepositorioPessoaImpl getInstance() {
		return null;
	}

	public boolean existe(String email) {
		return false;
	}

	public Pessoa getByEmail(String email) {
		return null;
	}

	public void salvar(Pessoa pessoa) {

	}

}
