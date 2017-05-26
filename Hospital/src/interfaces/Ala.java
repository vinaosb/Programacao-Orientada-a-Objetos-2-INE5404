package interfaces;

import java.io.Serializable;

import modelo.Quarto;

public interface Ala extends Serializable, Comparable<modelo.Ala> {

	public String getNomeAla();

	public int getNumeroQuartosEmUso();

	public int getNumeroQuartosVagos();

	public Quarto ocuparQuarto();

}
