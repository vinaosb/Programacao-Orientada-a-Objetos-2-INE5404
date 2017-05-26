package modelo.sorteio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.ILetra;
import modelo.Sorteio;

public class SorteioFacil extends Sorteio {

	@Override
	public List<ILetra> sorteioLetras() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int numeroLetras = random.nextInt(20) + 20;
		ArrayList<ILetra> letras = new ArrayList<ILetra>();
		for (int i = 0; i <= numeroLetras; i++) {
			int vogOuCons = random.nextInt(todasAsLetras.size());
			letras.add(todasAsLetras.remove(vogOuCons));
		}
		return letras;
	}

}
