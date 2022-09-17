package br.ufpe.cin.morada.auth.subsistemaGoogle;

import br.ufpe.cin.morada.auth.entidades.Pessoa;

public interface ISubsistemaGoogle {

	public Pessoa getDadosFromToken(String token);

}
