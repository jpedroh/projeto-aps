package br.ufpe.cin.morada.casa;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCasaImpl implements IRepositorioCasa {
	private static RepositorioCasaImpl instance;
	private Map<String, Casa> casas = new HashMap<>();

	public static RepositorioCasaImpl getInstance() {
		if (instance == null) {
			instance = new RepositorioCasaImpl();
		}
		return instance;
	}

	public Casa buscar(String codigo) {
		return this.casas.get(codigo);
	}

	public void salvar(Casa casa) {
		this.casas.put(casa.getCodigo(), casa);
	}
}
