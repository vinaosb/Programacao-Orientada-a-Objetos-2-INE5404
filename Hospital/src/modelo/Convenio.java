package modelo;

public class Convenio implements interfaces.Convenio {
	
	private String nome;
	private int numero;

	public Convenio(String nome, int numero) {
		this.setNome(nome);
		this.setNumero(numero);
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

}
