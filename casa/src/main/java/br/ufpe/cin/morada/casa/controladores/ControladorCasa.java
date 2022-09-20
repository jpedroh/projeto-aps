package br.ufpe.cin.morada.casa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.casa.dados.IRepositorioCasa;
import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.entidades.Pessoa;
import br.ufpe.cin.morada.casa.subsistemaPessoa.ISubsistemaPessoa;
import br.ufpe.cin.morada.casa.util.Email;

@Component
public class ControladorCasa {
  @Autowired
  private IRepositorioCasa repositorioCasa;

  @Autowired
  private ISubsistemaPessoa subsistemaPessoa;

  public void criarCasa(Casa casa, Email email) {
    Pessoa pessoa = subsistemaPessoa.getPessoaByEmail(email)
        .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada."));
    casa.adicionarMembro(pessoa);
    repositorioCasa.salvar(casa);
  }

  public void entrarCasa(String codigo, Email email) {
    Pessoa pessoa = subsistemaPessoa.getPessoaByEmail(email)
        .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada."));
    Casa casa = repositorioCasa.buscar(codigo).orElseThrow(() -> new CasaNaoEncontradaException(codigo));
    casa.adicionarMembro(pessoa);
    repositorioCasa.salvar(casa);
  }

  public void sairCasa(String codigo, Email email) {
    Pessoa pessoa = subsistemaPessoa.getPessoaByEmail(email)
        .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada."));
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
