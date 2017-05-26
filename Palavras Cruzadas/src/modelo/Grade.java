package modelo;

import interfaces.ILetra;

public class Grade {

	private ILetra[][] grade;

	public Grade(int numeroLinha, int numeroColuna) {
		// TODO Auto-generated constructor stub
		grade = new ILetra[numeroLinha][numeroColuna];
		inicializaGrade();
	}

	private void inicializaGrade() {
		for(int i = 0; i < numeroLinhas(); i++)
			for(int j = 0; j < numeroColunas(); j++)
				adicionaLetraNaPosicao(i,j,new Letras(' ',0));
	}

	public ILetra retornaLetraNaPosicao(int linha, int coluna) {
		// TODO Auto-generated method stub
		return grade[linha][coluna];
	}

	public void adicionaLetraNaPosicao(int linha, int coluna, ILetra iLetra) {
		this.grade[linha][coluna] = iLetra;
	}

	public int numeroLinhas() {
		// TODO Auto-generated method stub
		return this.grade.length;
	}

	public int numeroColunas() {
		// TODO Auto-generated method stub
		return this.grade[0].length;
	}

	@Override
	public String toString() {
		String resultado = "";
		for (int i = 1; i <= this.numeroLinhas(); i++) {
			for (int j = 1; j <= this.numeroColunas(); j++) {
				resultado = resultado + "(" + i + "," + j + ")" + ":" + this.grade[i - 1][j - 1] + "\n";
			}
		}
		return resultado;
	}

	public ILetra[][] retornaGrade() {
		return grade;
	}

}
