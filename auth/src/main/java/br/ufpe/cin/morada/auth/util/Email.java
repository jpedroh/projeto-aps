package br.ufpe.cin.morada.auth.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Email implements Serializable {
  @Column(name = "email")
  private String valor;

  private Email() {
  }

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

  @Override
  public int hashCode() {
    return valor.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Email other = (Email) obj;
    if (valor == null) {
      if (other.valor != null)
        return false;
    } else if (!valor.equals(other.valor))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return valor;
  }
}
