package modelo;

import static java.lang.String.format;
import interfaces.ILetra;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Dicionario {

	private static final String RESOURCES_DICIONARIO_TXT = format(
			"resources%sdicionario.txt", File.separator);
	
	private List<ArrayList<ILetra>> dicionario;

	public Dicionario() throws IOException {
		this.dicionario = new ArrayList<ArrayList<ILetra>>();
		this.inicializaDicionarioCompleto();
	}

	public void addPalavraDicionario(ArrayList<ILetra> palavra) {
		dicionario.add(palavra);
	}

	public List<ArrayList<ILetra>> getDicionario() {
		return dicionario;
	}

	private void inicializaDicionarioCompleto() throws IOException {
		List<String> dicionarioCompleto = new ArrayList<String>();
		dicionarioCompleto = CompiladorDeDicionario.readFile(
				RESOURCES_DICIONARIO_TXT, Charset.defaultCharset());
		for (String dicio : dicionarioCompleto) {
			ArrayList<ILetra> palavra = new ArrayList<ILetra>();
			for (char dic : dicio.toCharArray()) {
				palavra.add(new Letras(dic, 0));
			}
			this.addPalavraDicionario(palavra);
		}
	}

}
