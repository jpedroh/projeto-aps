package br.ufpe.cin.morada.casa.subsistemaPessoa;

import java.util.Optional;

import br.ufpe.cin.morada.casa.entidades.Pessoa;
import br.ufpe.cin.morada.casa.util.Email;

public interface ISubsistemaPessoa {
  Optional<Pessoa> getPessoaByEmail(Email email);
}
