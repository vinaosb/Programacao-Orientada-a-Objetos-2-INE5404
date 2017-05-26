package testes;

import static org.junit.Assert.*;
import modelo.LoadStore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoes.ZonaEleitoralExistente;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.LoadStore;
import modelo.Prefeito;
import modelo.Urna;
import modelo.Vereador;

@SuppressWarnings("unused")
public class JUnitComIU {

	private FachadaCartorioEleitoral cartorio;
	LoadStore load = new LoadStore();
	boolean cadastrou;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();

	}

	@Test()
	public void test() {
		LoadStore SalvaCarrega = new LoadStore();

		try {
			int teste = 0;
			do {
				switch (Integer.parseInt(JOptionPane.showInputDialog(
						"Digite 1 para adicionar uma Zona Eleitoral\nDigite 2 para adicionar uma Secao Eleitoral para uma Zona"
								+ "\nDigite 3 para adicionar um Eleitor\nDigite 4 para adicionar um Partido\nDigite 5 para Setar o Candidato a Prefeito"
								+ "\nDigite 6 para adicionar Candidatos a Vereador\nDigite 7 para abrir as urnas e adicionar Votos\nDigite 8 para apurar o 1 turno"
								+ "\nDigite 9 para Salvar" + "\nDigite 10 para Carregar"))) {
				case 1:
					cartorio.adicionarZonaEleitoral();
					break;
				case 2:
					cartorio.adicionaSecaoEleitoral();
					break;
				case 3:
					cartorio.adicionaEleitor();
					break;
				case 4:
					cartorio.adicionaPartido();
					break;
				case 5:
					int i2 = Integer.parseInt(JOptionPane
							.showInputDialog("Digite o numero do Partido para setar o candidato a Prefeito"));
					cartorio.adicionaPrefeito(i2);
					break;
				case 6:
					int i1 = Integer.parseInt(JOptionPane
							.showInputDialog("Digite o numero do Partido para adicionar um cadidato a Vereador"));
					cartorio.adicionaVereador(i1);
					break;
				case 7:
					cartorio.adicionarVotos();
					break;
				case 8:
					cartorio.apuracaoGeral();
					teste = 1;
					break;
				case 9:
					SalvaCarrega.StoreFachada(cartorio, "resources" + File.separator + "teste.txt");
					break;
				case 10:
					cartorio = SalvaCarrega.LoadFachada("resources" + File.separator + "teste.txt");
					break;
				default:
					break;
				}
			} while (teste == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail();
		}

	}

	@After
	public void saveFile() throws IOException {
	}

}
