package modelo;

import interfaces.ILetra;

public class Letras implements ILetra {

	private Character letra;
	private int valor;

	public Letras(Character letra, int valor) {
		// TODO Auto-generated constructor stub
		this.letra = letra;
		this.valor = valor;
	}

	@Override
	public Character getCaracter() {
		// TODO Auto-generated method stub
		return this.letra;
	}

	@Override
	public int getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}

}
