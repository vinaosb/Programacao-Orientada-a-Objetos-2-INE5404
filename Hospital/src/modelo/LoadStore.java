package modelo;

import static java.lang.String.format;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadStore {

	private static final String RESOURCES_TESTE_TXT = format("resources%steste.txt", File.separator);

	public LoadStore() {

	}

	public FachadaHospital LoadFachada() throws IOException, Exception {
		FileInputStream arquivo = new FileInputStream(RESOURCES_TESTE_TXT);
		ObjectInputStream stream = new ObjectInputStream(arquivo);
		FachadaHospital fachada = (FachadaHospital) stream.readObject();
		stream.close();
		return fachada;
	}

	public void StoreFachada(FachadaHospital fachada) throws IOException {
		FileOutputStream arquivo = new FileOutputStream(RESOURCES_TESTE_TXT);
		ObjectOutputStream stream = new ObjectOutputStream(arquivo);
		stream.writeObject(fachada);
		stream.close();
	}

}
