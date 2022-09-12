package br.ufpe.cin.morada.pessoa;

import org.springframework.data.repository.CrudRepository;

import br.ufpe.cin.morada.util.Email;

public interface PessoaDAO extends CrudRepository<Pessoa, Email> {

}
