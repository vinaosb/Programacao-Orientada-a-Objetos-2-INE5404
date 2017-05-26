package interfaces;


import java.io.Serializable;

import modelo.Urna;

public interface EstadosUrna extends Serializable {

	public void abreUrna(Urna urna) throws Exception;
	public void fechaUrna(Urna urna) throws Exception;
	public String estadoToString();

}
