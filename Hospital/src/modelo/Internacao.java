package modelo;

import java.io.Serializable;
import java.util.Calendar;

public class Internacao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8022090768875649105L;
	private String diagnostico;
	private String queixa;
	private String medicoResponsavel;
	private Calendar dataDeEntrada;
	private Calendar dataDeSaida;
	private Quarto quartoAlocado;

	public Internacao(String queixa) {
		this.setQueixa(queixa);
		this.setDataDeEntrada(Calendar.getInstance());
		Calendar temp = Calendar.getInstance();
		temp.set(1990, 1, 1, 0, 0, 1);
		this.setDataDeSaida(temp);
		this.setMedicoResponsavel("Sem Medico Responsavel");
		this.setDiagnostico("Sem Diagnostico");
		this.setQuartoAlocado(new Quarto(0));
	}

	public Calendar getDataDeEntrada() {
		return dataDeEntrada;
	}

	public Calendar getDataDeSaida() {
		return dataDeSaida;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public String getMedicoResponsavel() {
		return medicoResponsavel;
	}

	public Quarto getQuartoAlocado() {
		return quartoAlocado;
	}

	public String getQueixa() {
		return queixa;
	}

	private void setDataDeEntrada(Calendar dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public void setDataDeSaida(Calendar dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setMedicoResponsavel(String medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}

	public void setQuartoAlocado(Quarto quartoAlocado) {
		this.quartoAlocado = quartoAlocado;
	}

	private void setQueixa(String queixa) {
		this.queixa = queixa;
	}

}
