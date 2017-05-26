package modelo;

import java.io.Serializable;

public class Eleitor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1818276834632171650L;
	@SuppressWarnings("unused")
	private int cpf;
	private String nome;
	private int titulo;
	private SecaoEleitoral secao;
	private ZonaEleitoral zona;
	private String endereco;
	private String municipio;

	public Eleitor(int cpf, String nome, int titulo) {
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.nome = nome;
		this.titulo = titulo;
	}

	public SecaoEleitoral getSecao() {
		return secao;
	}

	public void setSecao(SecaoEleitoral secao) {
		this.secao = secao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return nome;
	}

	public int getTitulo() {
		return titulo;
	}

	public ZonaEleitoral getZona() {
		return zona;
	}

	public void setZona(ZonaEleitoral zona) {
		this.zona = zona;
	}

}
