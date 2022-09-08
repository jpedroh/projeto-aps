package br.ufpe.cin.morada.casa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufpe.cin.morada.pessoa.Pessoa;

@Entity
@Table(name = "casas")
public class Casa {
	@Id
	private String codigo;
	private String nome;

	@OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
	private List<Pessoa> membros;

	private Casa() {

	}

	public Casa(String nome) {
		this.codigo = gerarCodigo();
		this.nome = nome;
		this.membros = new ArrayList<>();
	}

	private String gerarCodigo() {
		return UUID.randomUUID().toString().substring(0, 7);
	}

	public void adicionarMembro(Pessoa pessoa) {
		if (membros.contains(pessoa)) {
			throw new RuntimeException(pessoa.getNome() + " já está cadastrada nesta casa.");
		}
		membros.add(pessoa);
		pessoa.setCasa(this);
	}

	public void removerMembro(Pessoa pessoa) {
		if (!membros.contains(pessoa)) {
			throw new RuntimeException(pessoa.getNome() + " não está cadastrada nesta casa.");
		}
		membros.remove(pessoa);
		pessoa.setCasa(null);
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public List<Pessoa> getMembros() {
		return membros;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Casa)) {
			return false;
		}
		return codigo.equals(((Casa) obj).getCodigo());
	}

	@Override
	public int hashCode() {
		return codigo.hashCode();
	}
}
