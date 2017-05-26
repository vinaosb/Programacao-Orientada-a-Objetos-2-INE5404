package interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Eleitor;

public interface ISecao extends Serializable{

	public ArrayList<Eleitor> getEleitores();

	public void addEleitor(Eleitor eleitor);

	public int getNumeroSecao();

	public Eleitor getEleitor(int titulo) throws Exception;

}
		