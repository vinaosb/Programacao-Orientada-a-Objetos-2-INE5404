package modelo;

import interfaces.EstadosQuarto;

public class Quarto implements interfaces.EstadosQuarto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3969330270594536088L;
	private EstadosQuarto estado;
	private int numeroDoQuarto;

	public Quarto(int numeroDoQuarto) {
		setEstado(new QuartoVago(this));
		this.setNumeroDoQuarto(numeroDoQuarto);
	}

	@Override
	public void desocupaQuarto(Quarto quarto) {
		estado.desocupaQuarto(this);
	}

	public EstadosQuarto getEstado() {
		return estado;
	}

	public int getNumeroQuarto() {
		return numeroDoQuarto;
	}

	@Override
	public boolean getSeQuartoEstaVago() {
		return estado.getSeQuartoEstaVago();
	}

	@Override
	public void ocupaQuarto(Quarto quarto) {
		estado.ocupaQuarto(this);
	}

	protected void setEstado(EstadosQuarto estado) {
		this.estado = estado;
	}

	private void setNumeroDoQuarto(int numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

}
