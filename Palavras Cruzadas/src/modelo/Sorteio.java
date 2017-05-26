package modelo;

import java.util.ArrayList;
import java.util.List;

import interfaces.ILetra;
import interfaces.SorteioLetras;

public abstract class Sorteio implements SorteioLetras {

	protected List<ILetra> vogais;
	protected List<ILetra> consoantes;
	protected List<ILetra> todasAsLetras;

	protected Sorteio() {
		// TODO Auto-generated constructor stub
		vogais = new ArrayList<ILetra>();
		consoantes = new ArrayList<ILetra>();
		todasAsLetras = new ArrayList<ILetra>();
		inicializaVogais();
		inicializaConsoantes();
		inicializaTodas();
	}

	@Override
	public List<ILetra> sorteioLetras() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void inicializaVogais() {
		char[] v = { 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < v.length; i++) {
			vogais.add(new Letras(v[i], 1));
		}
	}

	protected void inicializaConsoantes() {
		char[] c = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z' };
		for (int i = 0; i < c.length; i++) {
			consoantes.add(new Letras(c[i], 2));
		}
	}

	protected void inicializaTodas() {
		this.inicializa0Ponto();
		this.inicializa1Ponto();
		this.inicializa2Ponto();
		this.inicializa3Ponto();
		this.inicializa4a8Ponto();
	}

	private void inicializaLetra(char c, int valor, int numeroDeLetrasParaRepetir) {
		for (int count = 0; count < numeroDeLetrasParaRepetir; count++)
			todasAsLetras.add(new Letras(c, valor));
	}

	private void inicializa0Ponto() {
		inicializaLetra('Y', 0, 3);
	}

	private void inicializa1Ponto() {
		inicializaLetra('A', 1, 14);
		inicializaLetra('E', 1, 11);
		inicializaLetra('I', 1, 10);
		inicializaLetra('O', 1, 10);
		inicializaLetra('S', 1, 8);
		inicializaLetra('U', 1, 7);
		inicializaLetra('M', 1, 6);
		inicializaLetra('R', 1, 6);
		inicializaLetra('T', 1, 5);
	}

	private void inicializa2Ponto() {
		inicializaLetra('L', 2, 5);
		inicializaLetra('D', 2, 5);
		inicializaLetra('P', 2, 4);
		inicializaLetra('C', 2, 4);
	}

	private void inicializa3Ponto() {
		inicializaLetra('N', 3, 4);
		inicializaLetra('B', 3, 3);
		inicializaLetra('C', 3, 2);
	}

	private void inicializa4a8Ponto() {
		inicializaLetra('F', 4, 2);
		inicializaLetra('G', 4, 2);
		inicializaLetra('H', 4, 2);
		inicializaLetra('V', 4, 2);
		inicializaLetra('J', 5, 2);
		inicializaLetra('Q', 6, 1);
		inicializaLetra('X', 8, 1);
		inicializaLetra('Z', 8, 1);
	}

}
