package testes;

import excecoes.ZonaEleitoralExistente;
import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.SecaoEleitoral;
import modelo.ZonaEleitoral;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FachadaCartorioEleitoral cartorio = new FachadaCartorioEleitoral();
		
		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			System.out.println("Numero de Zonas Cadastradas: " + cartorio.getNumeroZonas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

		try {
			cartorio.cadastraZonaEleitoral(101, "Estreito");
			System.out.println("Numero de Zonas Cadastradas: " + cartorio.getNumeroZonas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			cartorio.cadastraZonaEleitoral(102, "SJ");
			System.out.println("Numero de Zonas Cadastradas: " + cartorio.getNumeroZonas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		ZonaEleitoral zona;
		try {
			zona = cartorio.getZona(102);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			zona = null;
		}
		if(zona != null){
			cartorio.addSecao(102);
			cartorio.addSecao(102);
			cartorio.addSecao(102);
			System.out.println("Secoes cadastradas: " + cartorio.getQtdSecao(102));
			
			Eleitor eleitor = new Eleitor(123456, "Brincando", 123);
			SecaoEleitoral secao;
			try {
				secao = zona.getSecao(2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				secao = null;
			}
			secao.addEleitor(eleitor);
			Eleitor eleitor2;
			try {
				eleitor2 = secao.getEleitor(123);
				String nom = eleitor2.getNome();
				System.out.println("Nome Eleitor: " + nom);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		else{
			try {
				throw new Exception("Zona nao registrada nao pode receber parametros");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}

}
