package br.ufpe.cin.morada.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.util.Email;

@Component
public class RepositorioPessoaImpl implements IRepositorioPessoa {
	private static RepositorioPessoaImpl instance;

	@Autowired
	private PessoaDAO pessoaDAO;

	private RepositorioPessoaImpl() {
	}

	public RepositorioPessoaImpl(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public static RepositorioPessoaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioPessoaImpl();
		}
		return instance;
	}

	public boolean existe(Email email) {
		return pessoaDAO.existsById(email);
	}

	public Pessoa getByEmail(Email email) {
		return pessoaDAO.findById(email).get();
	}

	public void salvar(Pessoa pessoa) {
		pessoaDAO.save(pessoa);
	}
}
