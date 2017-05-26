package interfaces;

import java.io.Serializable;

import modelo.Quarto;

public interface EstadosQuarto extends Serializable {

	public void desocupaQuarto(Quarto quarto);

	public boolean getSeQuartoEstaVago();

	public void ocupaQuarto(Quarto quarto);
}
