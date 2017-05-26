package modelo;

import interfaces.ILetra;
import interfaces.ITabuleiroLetras;

public class TabuleiroJogo implements ITabuleiroLetras {

	private Grade tabuleiro;

	public TabuleiroJogo(int numeroLinha, int numeroColuna) {
		// TODO Auto-generated constructor stub
		tabuleiro = new Grade(numeroLinha, numeroColuna);
	}

	@Override
	public ILetra retornaLetraNaPosicao(int linha, int coluna) {
		// TODO Auto-generated method stub
		return tabuleiro.retornaLetraNaPosicao(linha, coluna);
	}

	public void adicionaLetraNaPosicao(int linha, int coluna, ILetra iLetra) {
		this.tabuleiro.adicionaLetraNaPosicao(linha, coluna, iLetra);
	}

	@Override
	public int numeroLinhas() {
		// TODO Auto-generated method stub
		return this.tabuleiro.numeroLinhas();
	}

	@Override
	public int numeroColunas() {
		// TODO Auto-generated method stub
		return this.tabuleiro.numeroColunas();
	}

	@Override
	public String toString() {
		return this.tabuleiro.toString();
	}

	public ILetra[][] retornaGrade() {
		return tabuleiro.retornaGrade();
	}

}
