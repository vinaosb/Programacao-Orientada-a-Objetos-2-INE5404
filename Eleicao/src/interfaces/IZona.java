package interfaces;

import java.io.Serializable;

import modelo.SecaoEleitoral;

public interface IZona extends Serializable{

	public int getQtdSecao();

	public void addSecao();

	public int getNumeroZona();

	public SecaoEleitoral getSecao(int numero) throws Exception;

}
