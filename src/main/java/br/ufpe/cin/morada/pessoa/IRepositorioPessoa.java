package br.ufpe.cin.morada.pessoa;

public interface IRepositorioPessoa {

	public boolean existe(String email);

	public Pessoa getByEmail(String email);

	public void salvar(Pessoa pessoa);

}
