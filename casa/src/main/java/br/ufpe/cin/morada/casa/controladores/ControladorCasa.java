package br.ufpe.cin.morada.casa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.casa.dados.IRepositorioCasa;
import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.entidades.Pessoa;
import br.ufpe.cin.morada.casa.util.Email;

@Component
public class ControladorCasa {
  @Autowired
  private IRepositorioCasa repositorioCasa;

  public void criarCasa(Casa casa, Pessoa pessoa) {
    casa.adicionarMembro(pessoa);
    repositorioCasa.salvar(casa);
  }

  public void entrarCasa(String codigo, Pessoa pessoa) {
    Casa casa = repositorioCasa.buscar(codigo).orElseThrow(() -> new CasaNaoEncontradaException(codigo));
    casa.adicionarMembro(pessoa);
    repositorioCasa.salvar(casa);
  }

  public void sairCasa(String codigo, Pessoa pessoa) {
    Casa casa = repositorioCasa.buscar(codigo).orElseThrow(() -> new CasaNaoEncontradaException(codigo));
    casa.removerMembro(pessoa);
    repositorioCasa.salvar(casa);
  }

  public Casa buscar(String codigo) {
    return repositorioCasa.buscar(codigo).orElseThrow(() -> new CasaNaoEncontradaException(codigo));
  }

  public Casa buscarCasaPorEmail(Email email) {
    return repositorioCasa.buscarCasaPorEmail(email).orElseThrow(() -> new CasaNaoEncontradaException());
  }
}
