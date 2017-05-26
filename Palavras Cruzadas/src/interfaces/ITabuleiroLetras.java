package interfaces;

public interface ITabuleiroLetras {

	public ILetra retornaLetraNaPosicao(int linha, int coluna);

	public int numeroLinhas();

	public int numeroColunas();

	public ILetra[][] retornaGrade();

	public void adicionaLetraNaPosicao(int linha, int coluna, ILetra iLetra);

}