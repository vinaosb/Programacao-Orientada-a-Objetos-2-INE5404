package testes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

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
public class MainComJunit {
	
	private FachadaCartorioEleitoral cartorio;
	LoadStore load = new LoadStore();
	boolean cadastrou;

	@Before
	public void setUp() throws Exception {
			cartorio = new FachadaCartorioEleitoral();
			
		
	}

	@Test ()
	public void test() {
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			cartorio.cadastraZonaEleitoral(102, "Biba");
			assertEquals(2,cartorio.getNumeroZonas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail();
		}
		
		try{
			cartorio.addSecao(101);
			cartorio.addSecao(101);
			cartorio.addSecao(101);
			cartorio.addSecao(101);
			cartorio.addSecao(101);
			cartorio.addSecao(101);
		} catch(Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		try{
			Eleitor eleitor = new Eleitor(123123123, "Jorge", 123456);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
			eleitor = new Eleitor(123123456, "Marcos", 123451);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
			eleitor = new Eleitor(123123345, "Joao", 123452);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
			eleitor = new Eleitor(123123234, "Vinicius", 123453);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
			eleitor = new Eleitor(123123543, "Victor", 123454);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
			eleitor = new Eleitor(123123543, "Ana", 123455);
			cartorio.getZona(101).getSecao(1).addEleitor(eleitor);
		} catch(Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		try{
			cartorio.cadastraPartido("abc", "alfabeto");
			cartorio.cadastraPartido("zxc", "alfabeto1");
			cartorio.cadastraPartido("abb", "alfabeto2");
		} catch(Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		try{
			Prefeito candidatoPrefeito = new Prefeito("Jorginho", cartorio.getPartido(1).getNumeroPartido(), cartorio.getZona(101).getSecao(1).getEleitor(123456));
			cartorio.getPartido(1).setCandidatoPrefeito(candidatoPrefeito);
			Vereador candidatoVereador = new Vereador("Marquinhos",cartorio.getPartido(1).getNumeroPartido()*100, cartorio.getZona(101).getSecao(1).getEleitor(123451));
			cartorio.getPartido(1).addCandidatosVereador(candidatoVereador);
			candidatoPrefeito = new Prefeito("Joaozinho", cartorio.getPartido(2).getNumeroPartido(), cartorio.getZona(101).getSecao(1).getEleitor(123452));
			cartorio.getPartido(2).setCandidatoPrefeito(candidatoPrefeito);
			candidatoVereador = new Vereador("Vini",cartorio.getPartido(2).getNumeroPartido()*100, cartorio.getZona(101).getSecao(1).getEleitor(123453));
			cartorio.getPartido(2).addCandidatosVereador(candidatoVereador);
			candidatoPrefeito = new Prefeito("Vick", cartorio.getPartido(3).getNumeroPartido(), cartorio.getZona(101).getSecao(1).getEleitor(123454));
			cartorio.getPartido(3).setCandidatoPrefeito(candidatoPrefeito);
			candidatoVereador = new Vereador("Ana",cartorio.getPartido(3).getNumeroPartido()*100, cartorio.getZona(101).getSecao(1).getEleitor(123455));
			cartorio.getPartido(3).addCandidatosVereador(candidatoVereador);
		} catch(Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		try{
			cartorio.AbrirUrnas();
			Urna urna = cartorio.getZona(101).getSecao(1).getUrna();
			urna.addVoto(cartorio.getPartido(1).getCandidatoPrefeito(), cartorio.getPartido(1).getCandidatVereador(cartorio.getPartido(1).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123456));
			urna.addVoto(cartorio.getPartido(2).getCandidatoPrefeito(), cartorio.getPartido(2).getCandidatVereador(cartorio.getPartido(2).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123451));
			urna.addVoto(cartorio.getPartido(2).getCandidatoPrefeito(), cartorio.getPartido(3).getCandidatVereador(cartorio.getPartido(3).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123452));
			urna.addVoto(cartorio.getPartido(2).getCandidatoPrefeito(), cartorio.getPartido(1).getCandidatVereador(cartorio.getPartido(1).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123453));
			urna.addVoto(cartorio.getPartido(2).getCandidatoPrefeito(), cartorio.getPartido(1).getCandidatVereador(cartorio.getPartido(1).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123454));
			urna.addVoto(cartorio.getPartido(3).getCandidatoPrefeito(), cartorio.getPartido(1).getCandidatVereador(cartorio.getPartido(1).getNumeroPartido()*100), cartorio.getZona(101).getSecao(1).getEleitor(123455));
		} catch(Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		ArrayList<Prefeito> eleito = new ArrayList<Prefeito>();
		Prefeito eleitoFinal = null;
		ArrayList<Vereador> vereadorEleito = new ArrayList<Vereador>() ;
		try{
			cartorio.FecharUrnas(); 
			eleito = cartorio.ApuracaoPrefeito();
			eleitoFinal = eleito.get(0);
			vereadorEleito = cartorio.ApuracaoVereador();
		} catch(Exception e2){
			System.out.println(e2.getMessage());
			e2.printStackTrace();
		}
		if(eleito.size() == 2){
			try{
				cartorio.AbrirUrnas();
				Urna urna = cartorio.getZona(101).getSecao(1).getUrna();
				urna.addVotoSegundoTurno(eleito.get(0), cartorio.getZona(101).getSecao(1).getEleitor(123456));
				urna.addVotoSegundoTurno(eleito.get(1), cartorio.getZona(101).getSecao(1).getEleitor(123451));
				urna.addVotoSegundoTurno(eleito.get(1), cartorio.getZona(101).getSecao(1).getEleitor(123452));
				urna.addVotoSegundoTurno(eleito.get(1), cartorio.getZona(101).getSecao(1).getEleitor(123453));
				urna.addVotoSegundoTurno(eleito.get(1), cartorio.getZona(101).getSecao(1).getEleitor(123454));
				urna.addVotoSegundoTurno(eleito.get(0), cartorio.getZona(101).getSecao(1).getEleitor(123455));
				cartorio.FecharUrnas();
				eleitoFinal = cartorio.apuracaoSegundoTurno(eleito);
			} catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("Vereadores eleitos: \n" + vereadorEleito.get(0).getNomeCampanhaCandidato() + " , " + vereadorEleito.get(1).getNomeCampanhaCandidato().toString()+ "\nPrefeito eleito:\n" + eleitoFinal.getNomeCampanhaCandidato());
	}
	
	@After
	public void saveFile() throws IOException{
	}

}
