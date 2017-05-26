package modelo;

public class Gerencia extends Funcionario implements interfaces.Gerente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2642702926534926189L;
	private static Gerencia gerencia;

	public static Gerencia getGerente() {
		if (gerencia == null)
			gerencia = new Gerencia("FuncionarioGerente", "Endereco", 999, 7500, "admin");
		return gerencia;
	}

	private String senha;

	private Gerencia(String nome, String endereco, int cpf, int salario, String senha) {
		super(nome, endereco, cpf, salario);
		this.setSenha(senha);
	}

	public void changeGerente(Funcionario func, String senha) {
		this.setSenha(senha);
		super.setCpf(func.getCpf());
		super.setEndereco(func.getEndereco());
		super.setNome(func.getNome());
		super.setSalario(func.getSalario());

	}

	@Override
	public String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

}
