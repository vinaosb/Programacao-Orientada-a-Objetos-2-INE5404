package modelo;

import java.util.List;

public class FabricaDePontos {

	public Ponto baterPonto(boolean estaTrabalhando, List<Ponto> pontos) {
		if (estaTrabalhando)
			return new PontoDeSaida();
		else
			return new PontoDeEntrada();
	}

}