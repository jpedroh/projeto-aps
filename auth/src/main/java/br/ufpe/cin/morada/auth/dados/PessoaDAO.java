package br.ufpe.cin.morada.auth.dados;

import org.springframework.data.repository.CrudRepository;

import br.ufpe.cin.morada.auth.entidades.Pessoa;
import br.ufpe.cin.morada.auth.util.Email;

public interface PessoaDAO extends CrudRepository<Pessoa, Email> {

}
