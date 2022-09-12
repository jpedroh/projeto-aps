package br.ufpe.cin.morada.casa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public Casa buscar(String codigo) {
		return this.casaDAO.findById(codigo).get();
	}

	public void salvar(Casa casa) {
		this.casaDAO.save(casa);
	}
}
