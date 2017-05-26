package modelo;

import interfaces.ILetra;
import interfaces.ITabuleiroLetras;
import interfaces.JogoPalavrasCruzadas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JogoDePalavrasCruzadas implements JogoPalavrasCruzadas {
	private TabuleiroJogo tabuleiro;
	private Dicionario dicionario;
	private List<ILetra> letrasDisponiveis;
	public int pontuacaoFinal;

	public JogoDePalavrasCruzadas() throws IOException {
		dicionario = new Dicionario();
		tabuleiro = new TabuleiroJogo(7, 7);
	}

	@Override
	public void adicionaPalavra(List<ILetra> listaLetras, int linhaInicial,
			int colunaInicial, Direcao direcao) throws Exception {
		int tam = listaLetras.size();
		if (direcao == Direcao.HORIZONTAL & tam < tabuleiro.numeroColunas()) {
			for (int i = colunaInicial, j = 0; j < tam; i++, j++) {
				tabuleiro.adicionaLetraNaPosicao(linhaInicial, i,
						listaLetras.get(j));
			}
		} else if (tam < tabuleiro.numeroLinhas())
			for (int i = colunaInicial, j = 0; j < tam; i++, j++) {
				tabuleiro.adicionaLetraNaPosicao(i, colunaInicial,
						listaLetras.get(j));
			}
		else
			throw new Exception(
					"Nao pode adicionar palavra pois excede tamanho");
	}

	@Override
	public List<ILetra> letrasDisponiveis() {
		// TODO Auto-generated method stub
		return letrasDisponiveis;
	}

	@Override
	public int pontuacao() {
		// TODO Auto-generated method stub
		int pontos = 0;
		for (int i = 0; i < tabuleiro.numeroColunas(); i++) {
			ArrayList<ILetra> letrasHorizontal = new ArrayList<ILetra>();
			ArrayList<ILetra> letrasVertical = new ArrayList<ILetra>();
			for (int j = 0; j < tabuleiro.numeroLinhas(); j++) {
				if(tabuleiro.retornaLetraNaPosicao(i, j) != null)
					letrasHorizontal.add(tabuleiro.retornaLetraNaPosicao(i, j));
				if(tabuleiro.retornaLetraNaPosicao(j,i) != null)
					letrasVertical.add(tabuleiro.retornaLetraNaPosicao(j, i));
			}
			pontos = this.adicionaPontosDaLetra(pontos, letrasHorizontal);
			pontos = this.adicionaPontosDaLetra(pontos, letrasVertical);
		}
		return pontos;
	}

	private int adicionaPontosDaLetra(int pontos, List<ILetra> palavra) {
		if (dicionario.getDicionario().contains(palavra)) {
			for (int k = 0; k < palavra.size(); k++) {
				pontos = pontos - palavra.get(k).getValor();
			}
		} else {
			for (int k = 0; k < palavra.size(); k++) {
				pontos = pontos + palavra.get(k).getValor();
			}
		}
		return pontos;
	}

	@Override
	public void encerra() {
		// TODO Auto-generated method stub
		pontuacaoFinal = pontuacao();
		letrasDisponiveis = new ArrayList<ILetra>();

	}

	@Override
	public boolean terminou() {
		// TODO Auto-generated method stub
		if (letrasDisponiveis.size() > 0)
			return false;
		else {
			encerra();
			return true;
		}
	}

	@Override
	public ITabuleiroLetras retornaTabuleiro() {
		// TODO Auto-generated method stub
		return tabuleiro;
	}

	public List<ILetra> sorteioLetrasDisponiveis(List<ILetra> list) {
		List<ILetra> sorteio = list;
		return sorteio;
	}

	public void setLetrasDisponiveis(List<ILetra> letrasDisponiveis) {
		this.letrasDisponiveis = letrasDisponiveis;
	}

	public void adicionaLetraNaPosicao(int linha, int coluna, ILetra iLetra) {
		this.tabuleiro.adicionaLetraNaPosicao(linha, coluna, iLetra);
		this.letrasDisponiveis.remove(iLetra);
	}

}
