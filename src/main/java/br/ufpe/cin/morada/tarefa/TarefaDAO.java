
package br.ufpe.cin.morada.tarefa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufpe.cin.morada.casa.Casa;

public interface TarefaDAO extends CrudRepository<Tarefa, Long> {
  List<Tarefa> findAllByCasa(Casa casa);
}
