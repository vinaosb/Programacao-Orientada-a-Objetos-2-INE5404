package modelo;

import java.util.*;

import interfaces.ISecao;

public class SecaoEleitoral implements ISecao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4012041561842490688L;
	private int numero;
	private ZonaEleitoral zona;
	private ArrayList<Eleitor> eleitores;
	private Urna urna;
	
	
	
	public SecaoEleitoral(int numero, ZonaEleitoral zona) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		this.eleitores = new ArrayList<Eleitor>();
		setZona(zona);
		this.setUrna(new Urna(this,zona));
	}

	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}

	public void addEleitor(Eleitor eleitor) {
		Eleitor eleitorParaAdd = eleitor;
		eleitorParaAdd.setSecao(this);
		eleitorParaAdd.setZona(getZona());
		if(!this.eleitores.contains(eleitorParaAdd))
			this.eleitores.add(eleitorParaAdd);
	}

	public int getNumeroSecao() {
		return numero;
	}

	
	public Eleitor getEleitor(int titulo) throws Exception{
		for(Eleitor eleitor : this.eleitores){
			if(eleitor.getTitulo() == titulo){
				return eleitor;
			}
		}
		throw new Exception("Eleitor Nao Existente");
	}

	public ZonaEleitoral getZona() {
		return zona;
	}

	private void setZona(ZonaEleitoral zona) {
		this.zona = zona;
	}

	public Urna getUrna() {
		return urna;
	}

	private void setUrna(Urna urna) {
		this.urna = urna;
	}

}
