package interfaces;

import java.util.List;

public interface JogoPalavrasCruzadas {
	
	public enum Direcao {HORIZONTAL, VERTICAL}
	
	public void adicionaPalavra (List<ILetra> listaLetras, int linhaInicial, int colunaInicial,
            Direcao direcao) throws Exception;
	public List<ILetra> letrasDisponiveis();
	public int pontuacao();
	public void encerra();
	public boolean terminou();
	public ITabuleiroLetras retornaTabuleiro();
}