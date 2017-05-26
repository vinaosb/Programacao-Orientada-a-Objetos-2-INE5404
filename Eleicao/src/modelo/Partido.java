package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Partido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3451889808905715694L;
	private String sigla;
	private String nome;
	private ArrayList<Vereador> candidatosVereador;
	private Prefeito candidatoPrefeito;
	private int NumeroPartido;

	public Partido(String sigla, String nome, int numero) {
		// TODO Auto-generated constructor stub
		this.sigla = sigla;
		this.nome = nome;
		this.candidatosVereador = new ArrayList<Vereador>();
		this.setCandidatoPrefeito(new Prefeito("Nulo", 0, null));
		this.NumeroPartido = numero;
	}

	public Vereador getCandidatVereador(int Num) throws Exception {
		for(Vereador candidato : this.candidatosVereador){
			if(candidato.getNumeroCampanha() == Num){
				return candidato;
			}
		}
		throw new Exception("Candidato Nao Existente");
	}

	public void addCandidatosVereador(Vereador candidato) throws Exception {
		if(!this.candidatosVereador.contains(candidato)){
			for(Candidato candidatoNovo : this.candidatosVereador){
				if(candidatoNovo.getNumeroCampanha() == candidato.getNumeroCampanha()){
					throw new Exception("Numero de campanha já usado");
				}
			}
			this.candidatosVereador.add(candidato);
		}
		else
			throw new Exception("Candidato ja existente");
	}

	public Prefeito getCandidatoPrefeito() {
		return candidatoPrefeito;
	}

	public void setCandidatoPrefeito(Prefeito candidatoPrefeito) {
		this.candidatoPrefeito = candidatoPrefeito;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroPartido() {
		return NumeroPartido;
	}
	
	public ArrayList<Vereador> getCandidatosVereador(){
		return this.candidatosVereador;
	}

}
