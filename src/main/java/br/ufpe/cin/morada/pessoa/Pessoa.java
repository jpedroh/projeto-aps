package br.ufpe.cin.morada.pessoa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.util.Email;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	@Id
	@Embedded
	private Email email;

	@Column(name = "nome")
	private String nome;

	@OneToOne
	@JoinColumn(name = "codigo_casa", nullable = true)
	private Casa casa;

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

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Casa getCasa() {
		return casa;
	}

	public boolean hasCasa() {
		return casa != null;
	}
}
