package modelo;

import interfaces.EstadosUrna;

public class UrnaFechada implements EstadosUrna {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8081865095671289153L;

	public UrnaFechada(Urna urna) {
		// TODO Auto-generated constructor stub
		urna.setEstado(this);
	}
	
	public String estadoToString(){
		return "Urna Fechada";
	}
	
	public void abreUrna(Urna urna){
		EstadosUrna aberto = new UrnaAberta(urna);
		urna.setEstado(aberto);
		zeraVotos(urna);
	}

	public int getNumeroVotosPrefeito(Prefeito prefeito, Urna urna){
		return urna.getNumeroVotosPrefeito(prefeito);
	}

	
	public int getNumeroVotosVereador(Vereador vereador, Urna urna){
		return urna.getNumeroVotosVereador(vereador);
	}
	
	private void zeraVotos(Urna urna){
		urna.zeraVotos();
	}

	public void fechaUrna(Urna urna) throws Exception {
		throw new Exception("Urna fechada nao pode ser fechada");
		
	}

}
