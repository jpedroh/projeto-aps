package br.ufpe.cin.morada.util;

public final class Email {
  private String valor;

  private Email(String valor) {
    this.valor = valor;
  }

  public static Email from(String valor) {
    if (valor == null) {
      throw new IllegalArgumentException();
    }
    return new Email(valor);
  }

  public String getValor() {
    return this.valor;
  }
}
