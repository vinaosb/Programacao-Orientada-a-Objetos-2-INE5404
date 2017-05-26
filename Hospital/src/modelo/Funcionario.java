package modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Funcionario extends Pessoa implements interfaces.Funcionario {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2668642641259443003L;
	private int salario;
	private int codigoDeFuncionario;
	private ArrayList<Ponto> pontos;
	private boolean estaTrabalhando;

	public Funcionario(String nome, String endereco, int cpf, int salario) {
		super(nome, endereco, cpf);
		this.setSalario(salario);
		estaTrabalhando = false;
		pontos = new ArrayList<Ponto>();
		codigoDeFuncionario = cpf;
	}

	@Override
	public void baterPonto() {
		FabricaDePontos fab = new FabricaDePontos();
		pontos.add(fab.baterPonto(estaTrabalhando(), pontos));
		setEstaTrabalhando();
	}
	
	@Override
	public boolean estaTrabalhando() {
		return this.estaTrabalhando;
	}

	@Override
	public int getCodigoFunc() {
		return codigoDeFuncionario;
	}

	@Override
	public int getCpf() {
		return super.getCpf();
	}

	@Override
	public String getEndereco() {
		return super.getEndereco();
	}

	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public int getSalario() {
		return this.salario;
	}

	@Override
	public int horasTrabalhadas() {
		int horasTrabalhadas = 0;
		long temp = (long) 0.0;
		for (int i = 0; i < pontos.size() - 1; i = i + 2)
			temp += pontos.get(i + 1).getData().getTime().getTime() - pontos.get(i).getData().getTime().getTime();
		horasTrabalhadas = (int) temp / (1000 * 3600);
		return horasTrabalhadas;
	}

	@Override
	public long pagarSalario() {
		long temp = salario / (20 * 8) * horasTrabalhadas();
		NumberFormat.getCurrencyInstance().format(temp);
		return temp;
	}

	private void setEstaTrabalhando() {
		this.estaTrabalhando = !this.estaTrabalhando;
	}

	protected void setSalario(int salario) {
		this.salario = salario;
	}
	
	public Calendar getEntradaOuSaida(){
		if(pontos.size() != 0)
			return this.pontos.get(pontos.size()-1).getData();
		else
			return null;
	}
	
	public void limparPontos(){
		pontos = new ArrayList<Ponto>();
	}

}
