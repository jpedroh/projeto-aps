package br.ufpe.cin.morada.casa.dados;

import java.util.Optional;

import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.util.Email;

public interface IRepositorioCasa {
	public Optional<Casa> buscar(String codigo);

	public void salvar(Casa casa);

	public Optional<Casa> buscarCasaPorEmail(Email email);
}
