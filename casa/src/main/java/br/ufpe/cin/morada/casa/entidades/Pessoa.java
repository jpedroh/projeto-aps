package br.ufpe.cin.morada.casa.entidades;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufpe.cin.morada.casa.util.Email;

@Entity
@Table(name = "pessoas")
public class Pessoa {
  @Id
  @Embedded
  private Email email;

  @OneToOne
  @JoinColumn(name = "codigo_casa", nullable = true)
  private Casa casa;

  private Pessoa(Email email) {
    this.email = email;
  }

  public static Pessoa withEmail(Email email) {
    return new Pessoa(email);
  }

  private Pessoa() {
  }

  @Override
  public int hashCode() {
    return email.hashCode();
  }

  public void setCasa(Casa casa) {
    this.casa = casa;
  }

  public boolean hasCasa() {
    return casa != null;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pessoa other = (Pessoa) obj;
    return other.email.equals(email);
  }

  public Email getEmail() {
    return email;
  }
}
