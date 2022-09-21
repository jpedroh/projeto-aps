package br.ufpe.cin.morada.casa.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CasaNaoEncontradaException extends RuntimeException {
  public CasaNaoEncontradaException() {
    super("Não foi possível encontrar uma casa");
  }

  public CasaNaoEncontradaException(String codigoCasa) {
    super("Não foi possível encontrar uma pessoa com o codigo " + codigoCasa);
  }
}
