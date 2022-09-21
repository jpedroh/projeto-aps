package br.ufpe.cin.morada.casa.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.util.Email;

public interface CasaDAO extends CrudRepository<Casa, String> {
  @Query("SELECT distinct c from Casa c JOIN FETCH c.membros m where m.email = ?1")
  Optional<Casa> findByEmail(Email email);
}
