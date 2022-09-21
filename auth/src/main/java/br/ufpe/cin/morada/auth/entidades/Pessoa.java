package br.ufpe.cin.morada.auth.entidades;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ufpe.cin.morada.auth.util.Email;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	@Id
	@Embedded
	private Email email;

	@Column(name = "nome")
	private String nome;

	private Pessoa() {
	}

	public Pessoa(String nome, Email email) {
		this.nome = nome;
		this.email = email;
	}

	public Email getEmail() {
		return email;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		return email.hashCode();
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
}
