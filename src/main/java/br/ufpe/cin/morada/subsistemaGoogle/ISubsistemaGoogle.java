package br.ufpe.cin.morada.subsistemaGoogle;

import br.ufpe.cin.morada.pessoa.Pessoa;

public interface ISubsistemaGoogle {

	public Pessoa getDadosFromToken(String token);

}
