package modelo.sorteio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.ILetra;
import modelo.Sorteio;

public class SorteioDificil extends Sorteio {

	@Override
	public List<ILetra> sorteioLetras() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int numeroLetras = random.nextInt(20) + 20;
		ArrayList<ILetra> letras = new ArrayList<ILetra>();
		for (int i = 0; i <= numeroLetras; i++) {
			double vogOuCons = random.nextDouble();
			if (vogOuCons < 0.35) {
				int vog = random.nextInt(vogais.size());
				letras.add(vogais.get(vog));
			} else {
				int cons = random.nextInt(consoantes.size());
				letras.add(consoantes.get(cons));
			}
		}
		return letras;
	}

}
