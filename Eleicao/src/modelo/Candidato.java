package modelo;

import java.io.Serializable;

public abstract class Candidato implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7709677257150422287L;
	private int numeroCampanha;
	private String nomeCampanha;
	private int numeroVotos = 0;
	private Eleitor dadosPessoais;
	
	
	public Candidato(String nome, int numCampanha, Eleitor dadosPessoais) {
		// TODO Auto-generated constructor stub
		this.nomeCampanha = nome;
		this.dadosPessoais = dadosPessoais;
		this.numeroCampanha = numCampanha;
	}
	
	public Eleitor getDadosPessoais(){
		return this.dadosPessoais;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public void addNumeroVotos(int i) {
		this.numeroVotos = this.numeroVotos + i;
	}

	public int getNumeroCampanha() {
		return numeroCampanha;
	}

	public String getNomeCampanhaCandidato() {
		return this.nomeCampanha;
	}

	public String getNomeCandidato() {
		return this.dadosPessoais.getNome();
	}

}
