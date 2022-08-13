package br.ufpe.cin.morada.pessoa;

import java.util.Optional;

import br.ufpe.cin.morada.util.Email;

public interface IRepositorioPessoa {

	public boolean existe(Email email);

	public Optional<Pessoa> getByEmail(Email email);

	public void salvar(Pessoa pessoa);

}
