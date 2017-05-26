package modelo;

import java.util.*;

import interfaces.IZona;

public class ZonaEleitoral implements IZona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 174168288149310684L;
	private int numero;
	private ArrayList<SecaoEleitoral> secoes;
	@SuppressWarnings("unused")
	private String localizacao = "";

	public ZonaEleitoral(int numero, String localizacao) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		this.localizacao = localizacao;
		this.secoes = new ArrayList<SecaoEleitoral>();
	}

	public int getQtdSecao() {
		return secoes.size();
	}

	public void addSecao() {
		SecaoEleitoral secao = new SecaoEleitoral(this.secoes.size()+1, this);
		this.secoes.add(secao);
	}
	
	public int getNumeroZona(){
		return this.numero;
	}
	
	public SecaoEleitoral getSecao(int numero) throws Exception{
		for(SecaoEleitoral secao : this.secoes){
			if(secao.getNumeroSecao() == numero){
				return secao;
			}
		}
		throw new Exception("Zona Nao Cadastrada");
	}
	
	public ArrayList<SecaoEleitoral> getTodasSecoes(){
		return this.secoes;
	}

}
