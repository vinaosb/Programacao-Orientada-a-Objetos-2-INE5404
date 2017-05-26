package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import interfaces.Convenio;

public class Paciente extends Pessoa implements interfaces.Paciente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958704002600923789L;
	private List<Internacao> internacoes;
	private Convenio convenio;

	public Paciente(String nome, String endereco, int cpf, String queixa, Convenio convenio) {
		super(nome, endereco, cpf);
		internacoes = new ArrayList<Internacao>();
		internacoes.add(new Internacao(queixa));
		this.convenio = convenio;
	}


	@Override
	public Convenio getConvenio() {
		return this.convenio;
	}

	@Override
	public int getCpf() {
		return super.getCpf();
	}

	@Override
	public String getEndereco() {
		return super.getEndereco();
	}

	public List<Internacao> getInternacoes() {
		return internacoes;
	}

	public Internacao getLastInternacao() {
		return internacoes.get(internacoes.size() - 1);
	}

	@Override
	public String getNome() {
		return super.getNome();
	}

	public void setLastInternacao(String diagnostico, String medicoResponsavel, Calendar dataDeSaida,
			Quarto quartoAlocado) {
		if (dataDeSaida != null)
			getLastInternacao().setDataDeSaida(dataDeSaida);
		if (diagnostico != null)
			getLastInternacao().setDiagnostico(diagnostico);
		if (medicoResponsavel != null)
			getLastInternacao().setMedicoResponsavel(medicoResponsavel);
		if (quartoAlocado != null)
			getLastInternacao().setQuartoAlocado(quartoAlocado);
	}

}
