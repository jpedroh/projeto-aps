package br.ufpe.cin.morada.pessoa;

import br.ufpe.cin.morada.casa.Casa;
import br.ufpe.cin.morada.util.Email;

public class Pessoa {
	private String nome;

	private Email email;

	private Casa casa;

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
