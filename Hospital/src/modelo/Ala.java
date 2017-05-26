package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ala implements interfaces.Ala {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7397722594811157926L;
	private List<Quarto> quartos;
	private String nomeAla;

	public Ala(String nome, int numeroDeQuartos) {
		quartos = new ArrayList<Quarto>();
		for (int i = 0; i < numeroDeQuartos; i++)
			quartos.add(new Quarto(i + 10));
		setNomeAla(nome);
	}

	public Ala getAla() {
		return this;
	}

	public String getNomeAla() {
		return nomeAla;
	}

	@Override
	public int getNumeroQuartosEmUso() {
		int soma = 0;
		for (Quarto quar : quartos)
			if (!quar.getSeQuartoEstaVago())
				soma += 1;
		return soma;
	}

	@Override
	public int getNumeroQuartosVagos() {
		int soma = 0;
		for (Quarto quar : quartos)
			if (quar.getSeQuartoEstaVago())
				soma += 1;
		return soma;
	}

	@Override
	public Quarto ocuparQuarto() {
		Quarto temp = null;
		for (Quarto quar : quartos)
			if (quar.getSeQuartoEstaVago()) {
				quar.ocupaQuarto(quar);
				temp = quar;
				break;
			}
		return temp;
	}

	private void setNomeAla(String nomeAla) {
		this.nomeAla = nomeAla;
	}

	public int compareTo(Ala outra) {
		return this.getNomeAla().compareTo(outra.getNomeAla());
	}

}
