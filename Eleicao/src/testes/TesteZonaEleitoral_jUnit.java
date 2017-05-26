package testes;

import java.util.List;

import interfaces.CartorioEleitoral;
import interfaces.IZona;

import org.junit.*;


import static org.junit.Assert.*;


import modelo.FachadaCartorioEleitoral;
import modelo.SecaoEleitoral;



public class TesteZonaEleitoral_jUnit {

	private CartorioEleitoral cartorio;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
	}
	
	
	@Test
	public void cadastraZona101DuasVezes() throws Exception{
		try{	
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals (1,cartorio.getNumeroZonas());	
		cartorio.cadastraZonaEleitoral(101, "Estreito");	
		fail();
		}	
		catch(Exception excecao){
			assertEquals (1, cartorio.getNumeroZonas());	
		}
	}

	@Test
	public void cadastraZona101e102() throws Exception{
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		assertEquals (2,cartorio.getNumeroZonas());
		IZona zona = cartorio.getZona(101);
		assertEquals (101, zona.getNumeroZona());
		IZona zona102 = cartorio.getZona(102);
		assertEquals (102, zona102.getNumeroZona());
	}

	@Test
	public void cadastraZona101eDuasSecoes() throws Exception{
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals (1,cartorio.getNumeroZonas());
		IZona zona = cartorio.getZona(101);
		assertEquals (101, zona.getNumeroZona());
		cartorio.addSecao(101);
		cartorio.addSecao(101);
		int numeroSecoes = cartorio.getQtdSecao(101);
		assertEquals (2, numeroSecoes);
		List<SecaoEleitoral> secoes = cartorio.getSecoesDeUmaZona(101);
		assertEquals(1, secoes.get(0).getNumeroSecao());
		assertEquals(2, secoes.get(1).getNumeroSecao());
	}

	
		
		
	}