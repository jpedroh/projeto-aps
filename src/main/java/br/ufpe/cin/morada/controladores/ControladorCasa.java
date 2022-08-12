package br.ufpe.cin.morada.controladores;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.casa.IRepositorioCasa;
import br.ufpe.cin.morada.pessoa.Pessoa;

public class ControladorCasa {
	private IRepositorioCasa repositorioCasa;

	public void criarCasa(Casa casa, Pessoa pessoa) {
		casa.adicionarMembro(pessoa);
		repositorioCasa.salvar(casa);
	}

	public void entrarCasa(String codigo, Pessoa pessoa) {
		Casa casa = repositorioCasa.buscar(codigo);
		casa.adicionarMembro(pessoa);
		repositorioCasa.salvar(casa);
	}

	public void sairCasa(String codigo, Pessoa pessoa) {
		Casa casa = repositorioCasa.buscar(codigo);
		casa.removerMembro(pessoa);
		repositorioCasa.salvar(casa);
	}

  public Casa buscar(String codigoCasa) {
    return null;
  }
}
