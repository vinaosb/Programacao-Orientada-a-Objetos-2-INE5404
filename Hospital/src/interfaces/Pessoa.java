package interfaces;

import java.io.Serializable;

public abstract interface Pessoa extends Serializable, Comparable<modelo.Pessoa>{

	public int getCpf();

	public String getEndereco();

	public String getNome();

}
