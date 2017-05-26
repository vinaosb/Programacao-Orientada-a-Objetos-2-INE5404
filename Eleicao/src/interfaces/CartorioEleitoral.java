package interfaces;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Partido;
import modelo.SecaoEleitoral;
import modelo.ZonaEleitoral;

public interface CartorioEleitoral extends Serializable {
	
	public void cadastraZonaEleitoral(int numero, String localizacao) throws Exception;

	public ZonaEleitoral getZona(int numero) throws Exception;

	public int getNumeroZonas();

	public void cadastraPartido(String sigla, String nome) throws Exception;

	public Partido getPartido(int numeroPartido) throws Exception;

	public int getNumeroPartidos();

	public int getQtdSecao(int numeroZona);

	public void addSecao(int numeroZona) throws Exception;
	
	public ArrayList<SecaoEleitoral> getSecoesDeUmaZona (int numeroZonaEleitoral) throws Exception;

}
