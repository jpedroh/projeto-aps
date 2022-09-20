package br.ufpe.cin.morada.casa.dados;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufpe.cin.morada.casa.entidades.Casa;
import br.ufpe.cin.morada.casa.util.Email;

@Component
public class RepositorioCasaImpl implements IRepositorioCasa {
	private static RepositorioCasaImpl instance;

	@Autowired
	private CasaDAO casaDAO;

	public static RepositorioCasaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioCasaImpl();
		}
		return instance;
	}

	public Optional<Casa> buscar(String codigo) {
		return this.casaDAO.findById(codigo);
	}

	public void salvar(Casa casa) {
		this.casaDAO.save(casa);
	}

	@Override
	public Optional<Casa> buscarCasaPorEmail(Email email) {
		return this.casaDAO.findByEmail(email);
	}
}
