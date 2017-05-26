package modelo;

import java.io.Serializable;

public class Votos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -480917857116205574L;
	private int votoPrefeito;
	private int votoVereador;
	private int tituloEleitor;
	private boolean Justificativa;

	public Votos(int Prefeito, int Vereador, int Eleitor, boolean Justificativa) {
		// TODO Auto-generated constructor stub
		this.setVotoPrefeito(Prefeito);
		this.setVotoVereador(Vereador);
		this.setTituloEleitor(Eleitor);
		this.setJustificativa(Justificativa);
	}

	public int getVotoPrefeito() {
		return votoPrefeito;
	}

	private void setVotoPrefeito(int numeroPrefeito) {
		this.votoPrefeito = numeroPrefeito;
	}

	public int getVotoVereador() {
		return votoVereador;
	}

	private void setVotoVereador(int numeroVereador) {
		this.votoVereador = numeroVereador;
	}

	public int getTituloEleitor() {
		return tituloEleitor;
	}

	private void setTituloEleitor(int tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public boolean isJustificativa() {
		return Justificativa;
	}

	private void setJustificativa(boolean justificativa) {
		Justificativa = justificativa;
	}

}
