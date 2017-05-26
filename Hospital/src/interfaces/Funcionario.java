package interfaces;

import java.io.Serializable;

public interface Funcionario extends Serializable {

	void baterPonto();

	boolean estaTrabalhando();

	int getCodigoFunc();

	int getCpf();

	String getEndereco();

	String getNome();

	int getSalario();

	int horasTrabalhadas();

	long pagarSalario();

}