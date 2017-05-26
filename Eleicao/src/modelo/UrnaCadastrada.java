package modelo;

import interfaces.EstadosUrna;

public class UrnaCadastrada extends EstadosDaUrna implements EstadosUrna {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8081865095671289153L;

	public UrnaCadastrada(Urna urna) {
		// TODO Auto-generated constructor stub
		urna.setEstado(this);
	}
	
	public String estadoToString(){
		return "Urna Cadastrada";
	}
	
	public void abreUrna(Urna urna){
		EstadosUrna aberto = new UrnaAberta(urna);
		urna.setEstado(aberto);
	}

	@Override
	public void fechaUrna(Urna urna) throws Exception {
		throw new Exception("Urna cadastrada nao pode ser fechada");
		
	}

}
