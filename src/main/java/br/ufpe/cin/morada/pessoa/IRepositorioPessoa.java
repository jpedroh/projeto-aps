package br.ufpe.cin.morada.pessoa;

public interface IRepositorioPessoa {

	public boolean existe(string email);

	public Pessoa getByEmail(string email);

	public void salvar(Pessoa pessoa);

}
