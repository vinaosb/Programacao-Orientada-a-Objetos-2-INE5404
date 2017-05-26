package modelo;

import interfaces.EstadosUrna;

public class UrnaAberta implements EstadosUrna {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8081865095671289153L;

	public UrnaAberta(Urna urna) {
		// TODO Auto-generated constructor stub
		urna.setEstado(this);
	}
	
	public String estadoToString(){
		return "Urna Aberta";
	}
	
	public void fechaUrna(Urna urna){
		EstadosUrna fechada = new UrnaFechada(urna);
		urna.setEstado(fechada);
	}
	
	public void addVoto(Prefeito prefeito, Vereador vereador,Eleitor eleitor, Urna urna) throws Exception{
		urna.addVoto(prefeito, vereador, eleitor);
	}
	
	public void addJustificativa(Eleitor eleitor, Urna urna) throws Exception{
		urna.addJustificativa(eleitor);
	}

	public void abreUrna(Urna urna) throws Exception {
		throw new Exception("Urna aberta nao pode ser aberta");
		
	}

}
