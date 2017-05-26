package modelo;

import java.util.ArrayList;

import interfaces.EstadosUrna;


public class Urna implements EstadosUrna{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7793184905016296692L;
	private ArrayList<Votos> votos;
	private SecaoEleitoral secao;
	private ZonaEleitoral zona;
	private EstadosUrna Estado;

	public Urna(SecaoEleitoral secao, ZonaEleitoral zona) {
		// TODO Auto-generated constructor stub
		this.secao = secao;
		this.zona = zona;
		this.votos = new ArrayList<Votos>();
		EstadosUrna Cadastrada = new UrnaCadastrada(this);
		Estado = Cadastrada;
	}
	
	public void addVoto(Prefeito prefeito, Vereador vereador,Eleitor eleitor) throws Exception{
		Votos votoEleitor = getVotoOuJustificativaEleitor(eleitor.getTitulo());
		if(votoEleitor == null)
			if((eleitor.getSecao().getNumeroSecao() == this.secao.getNumeroSecao()))
				if(eleitor.getZona().getNumeroZona() == this.zona.getNumeroZona()){
					Votos votoNovo = new Votos(prefeito.getNumeroCampanha(), vereador.getNumeroCampanha(), eleitor.getTitulo(), false);
					this.votos.add(votoNovo);
				}
	}
	
	public void addVotoSegundoTurno(Prefeito prefeito, Eleitor eleitor) throws Exception{
		Vereador vereador = new Vereador("Nulo", 0, null);
		addVoto(prefeito,vereador,eleitor);
	}
	
	public void addJustificativa(Eleitor eleitor) throws Exception{
		if(eleitor.getZona() != this.zona){
			try{
				@SuppressWarnings("unused")
				Votos votoEleitor = getVotoOuJustificativaEleitor(eleitor.getTitulo());
				throw new Exception("Eleitor ja justificou");
			} catch(Exception e1){
				if(e1.getMessage() != "Eleitor ja justificou"){
					Votos votoNovo = new Votos(00, 00000, eleitor.getTitulo(), true);
					votos.add(votoNovo);
				}
				else throw e1;
			}
		}
	}
	
	private Votos getVotoOuJustificativaEleitor(int numeroEleitor) throws Exception{
		for(Votos voto : this.votos){
			if(voto.getTituloEleitor() == numeroEleitor){
				return voto;
			}
		}
		return null;
	}
	
	public int getNumeroVotosPrefeito(Prefeito prefeito){
		int i = 0;
		for(Votos voto : this.votos){
			if(voto.getVotoPrefeito() == prefeito.getNumeroCampanha()){
				i++;
			}
		}
		return i;
	}
	
	public int getNumeroVotosVereador(Vereador vereador){
		int i = 0;
		for(Votos voto : this.votos){
			if(voto.getVotoVereador() == vereador.getNumeroCampanha()){
				i++;
			}
		}
		return i;
	}
	
	public void zeraVotos(){
			this.votos = new ArrayList<Votos>();
	}

	public EstadosUrna getEstado() {
		return this.Estado;
	}

	public void setEstado(EstadosUrna estado) {
		this.Estado = estado;
	}

	@Override
	public void abreUrna(Urna urna) throws Exception {
		// TODO Auto-generated method stub
		Estado.abreUrna(this);
	}

	@Override
	public void fechaUrna(Urna urna) throws Exception {
		// TODO Auto-generated method stub
		Estado.fechaUrna(this);
		
	}

	@Override
	public String estadoToString() {
		// TODO Auto-generated method stub
		return Estado.estadoToString();
	}

}
