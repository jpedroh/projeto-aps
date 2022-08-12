package br.ufpe.cin.morada.casa;

public interface IRepositorioCasa {

	public Casa buscar(String codigo);

	public void salvar(Casa casa);

}
