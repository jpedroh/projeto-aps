package br.ufpe.cin.morada.auth.dados;

import java.util.Optional;

import br.ufpe.cin.morada.auth.entidades.Pessoa;
import br.ufpe.cin.morada.auth.util.Email;

public interface IRepositorioPessoa {
	public boolean existe(Email email);

	public Optional<Pessoa> getByEmail(Email email);

	public void salvar(Pessoa pessoa);
}
