package modelo;

import interfaces.EstadosQuarto;

public class QuartoVago implements EstadosQuarto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7860769624710199027L;

	public QuartoVago(Quarto quarto) {
		quarto.setEstado(this);
	}

	@Override
	public void desocupaQuarto(Quarto quarto) {
	}

	@Override
	public boolean getSeQuartoEstaVago() {
		return true;
	}

	@Override
	public void ocupaQuarto(Quarto quarto) {
		quarto.setEstado(new QuartoOcupado(quarto));
	}

}
