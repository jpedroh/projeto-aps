package br.ufpe.cin.morada.pessoa;

import br.ufpe.cin.morada.util.Email;

public interface IRepositorioPessoa {

	public boolean existe(Email email);

	public Pessoa getByEmail(Email email);

	public void salvar(Pessoa pessoa);

}
