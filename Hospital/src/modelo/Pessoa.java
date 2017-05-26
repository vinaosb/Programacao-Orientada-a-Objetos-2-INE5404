package modelo;

public class Pessoa implements interfaces.Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9005821146507515368L;
	private String nome;
	private String endereco;
	private int cpf;

	public Pessoa(String nome, String endereco, int cpf) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}

	@Override
	public int getCpf() {
		return cpf;
	}

	@Override
	public String getEndereco() {
		return endereco;
	}

	@Override
	public String getNome() {
		return nome;
	}

	protected void setCpf(int cpf) {
		this.cpf = cpf;
	}

	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Pessoa outro) {
		return this.getNome().compareTo(outro.getNome());
	}


}
