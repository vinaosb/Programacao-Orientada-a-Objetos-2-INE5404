package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FachadaHospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5235754576716105942L;
	private List<Funcionario> funcionarios;
	private List<Ala> alas;
	private List<Paciente> pacientes;
	private Gerencia gerencia = Gerencia.getGerente();
	private List<Convenio> convenios;

	public FachadaHospital() {
		// TODO Auto-generated constructor stub
		inicializar();
	}

	public void addAla(Ala ala) {
		this.alas.add(ala);
	}

	public void addFuncionario(Funcionario func) {
		this.funcionarios.add(func);
	}

	public void addPaciente(String nome, String endereco, String queixa, int cpf, Convenio convenio) throws Exception {
		if (getPacientePorCPF(cpf) == null) {
			Paciente paciente = new Paciente(nome, endereco, cpf, queixa, convenio);
			this.pacientes.add(paciente);
		} else
			throw new Exception();
	}

	public void alocarQuartoProPaciente(Paciente paciente, Ala ala) {
		paciente.setLastInternacao(null, null, null, ala.ocuparQuarto());
	}

	public void demiteFuncionario(Funcionario funcionario) {
		this.funcionarios.remove(funcionario);
	}

	public List<Paciente> getListaPacientes() {
		ordenarPorNome();
		return pacientes;
	}

	public List<Funcionario> getListaFuncionarios() {
		ordenarPorNome();
		return funcionarios;
	}

	private Paciente getPacientePorCPF(int cpf) {
		for (Paciente pac : pacientes)
			if (pac.getCpf() == cpf)
				return pac;
		return null;
	}

	public String getSenhaDoGerentePorCpf(int cpf) {
		if (gerencia.getCpf() == cpf)
			return gerencia.getSenha();
		return null;
	}

	private void inicializar() {
		funcionarios = new ArrayList<Funcionario>();
		alas = new ArrayList<Ala>();
		pacientes = new ArrayList<Paciente>();
		convenios = new ArrayList<Convenio>();
		addAla(new Ala("Ala 1",10));
		addAla(new Ala("Ala 2",9));
		addAla(new Ala("Ala 3",8));
		this.convenios.add(new Convenio("abc",convenios.size()));
		try {
			this.addPaciente("nome", "end", "q", 123, convenios.get(0));
			this.addPaciente("nome2", "end", "q", 1234, convenios.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		funcionarios.add(new Funcionario("a", "b", 123, 123));
	}

	private void ordenarPorNome() {
		//pacientes.sort(null);
		//funcionarios.sort(null);
		//alas.sort(null);
	}

	public void saidaDePaciente(Paciente paciente) {
		paciente.getLastInternacao().getQuartoAlocado().desocupaQuarto(paciente.getLastInternacao().getQuartoAlocado());
		paciente.setLastInternacao(null, null, Calendar.getInstance(), null);
	}
	
	public Funcionario getFuncionarioPorCodigo(int cod){
		Funcionario temp = new Funcionario(null, null, 0, 0);
		for(Funcionario func:funcionarios)
			if(func.getCodigoFunc() == cod)
				temp = func;
		return temp;
	}
	
	public List<Ala> getAlas(){
		ordenarPorNome();
		return alas;
	}
	
	public List<Convenio> getListaConvenios(){
		return this.convenios;
	}

}
