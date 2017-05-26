package modelo;

import interfaces.EstadosQuarto;

public class QuartoOcupado implements EstadosQuarto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -979074689481108497L;

	public QuartoOcupado(Quarto quarto) {
		quarto.setEstado(this);
	}

	@Override
	public void desocupaQuarto(Quarto quarto) {
		quarto.setEstado(new QuartoVago(quarto));
	}

	@Override
	public boolean getSeQuartoEstaVago() {
		return false;
	}

	@Override
	public void ocupaQuarto(Quarto quarto) {
	}

}
