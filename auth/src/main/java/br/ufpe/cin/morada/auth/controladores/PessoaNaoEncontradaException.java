package br.ufpe.cin.morada.auth.controladores;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import br.ufpe.cin.morada.auth.util.Email;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends RuntimeException {
  PessoaNaoEncontradaException(Email email) {
    super("Não foi possível encontrar uma pessoa com o email " + email);
  }
}
