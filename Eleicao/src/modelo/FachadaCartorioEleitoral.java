package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoes.ZonaEleitoralExistente;
import interfaces.CartorioEleitoral;

public class FachadaCartorioEleitoral implements CartorioEleitoral {

	private static final long serialVersionUID = 1540603268723125146L;

	private ArrayList<ZonaEleitoral> zonas;
	private ArrayList<Partido> partidos;
	private ArrayList<Eleitor> eleitores = new ArrayList<Eleitor>();
	private ArrayList<Vereador> vereadores = new ArrayList<Vereador>();

	public FachadaCartorioEleitoral() throws Exception {
		// TODO Auto-generated constructor stub
		this.zonas = new ArrayList<ZonaEleitoral>();
		this.partidos = new ArrayList<Partido>();
		Partido partidoNulo = new Partido("Null", "Nulo", 0);
		partidoNulo.addCandidatosVereador(new Vereador("Nulo", 0, null));
		partidoNulo.setCandidatoPrefeito(new Prefeito("Nulo", 0, null));
		Eleitor eleitorNulo = new Eleitor(0, "0", 0);
		this.partidos.add(partidoNulo);
		for(int inicializador = 0; inicializador <100000; inicializador++)
			eleitores.add(eleitorNulo);
		Vereador vereadorNulo = new Vereador("0", 0, eleitorNulo);
		for(int inicializador = 0; inicializador <100000; inicializador++)
			vereadores.add(vereadorNulo);
	}

	public void cadastraZonaEleitoral(int numero, String localizacao) throws Exception {
		if (this.zonas.isEmpty()) {
			addZona(numero, localizacao);
		} else if (this.zonas.get(0).getTodasSecoes().isEmpty())
			addZona(numero, localizacao);
		else if (this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().getClass() == UrnaCadastrada.class)
			addZona(numero, localizacao);
		else
			throw new Exception("Urnas estão abertas");
	}

	private void addZona(int numero, String localizacao) throws Exception {
		ZonaEleitoral zonaExistente = null;
		try {
			zonaExistente = getZona(numero);
		} catch (Exception e1) {
			ZonaEleitoral zonaNova = new ZonaEleitoral(numero, localizacao);
			this.zonas.add(zonaNova);
		}
		if (zonaExistente != null) {
			throw new ZonaEleitoralExistente("Zona Eleitoral " + numero + " Existente");
		}
	}

	public ZonaEleitoral getZona(int numero) throws Exception {
		for (ZonaEleitoral zona : this.zonas) {
			if (zona.getNumeroZona() == numero) {
				return zona;
			}
		}
		throw new Exception("Zona Nao Cadastrada");
	}

	public int getNumeroZonas() {
		return this.zonas.size();
	}

	public void cadastraPartido(String sigla, String nome) throws Exception {
		if (this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().getClass() == UrnaCadastrada.class) {
			Partido partidoNovo = new Partido(sigla, nome, partidos.size() + 10);
			this.partidos.add(partidoNovo);
		} else
			throw new Exception("Urnas estão abertas");
	}

	public Partido getPartido(int numeroPartido) throws Exception {
		for (Partido partido : this.partidos) {
			if (partido.getNumeroPartido() == numeroPartido + 10) {
				return partido;
			}
		}
		throw new Exception("Partido Nao Existente");
	}

	public int getNumeroPartidos() {
		return this.partidos.size();
	}

	public int getQtdSecao(int numeroZona) {
		try {
			return this.getZona(numeroZona).getQtdSecao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public void addSecao(int numeroZona) throws Exception {
		if (this.getZona(numeroZona).getTodasSecoes().isEmpty()) {
			try {
				this.getZona(numeroZona).addSecao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} else if (this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().getClass() == UrnaCadastrada.class)
			try {
				this.getZona(numeroZona).addSecao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		else
			throw new Exception("Urnas estão abertas");
	}

	public ArrayList<SecaoEleitoral> getSecoesDeUmaZona(int numeroZonaEleitoral) throws Exception {
		return this.getZona(numeroZonaEleitoral).getTodasSecoes();
	}

	private int somaVotosPrefeito() {
		int numeroVotosTotal = 0;
		for (Partido partido : partidos) {
			for (ZonaEleitoral zona : zonas) {
				for (SecaoEleitoral secao : zona.getTodasSecoes()) {
					partido.getCandidatoPrefeito()
							.addNumeroVotos(secao.getUrna().getNumeroVotosPrefeito(partido.getCandidatoPrefeito()));
					numeroVotosTotal = numeroVotosTotal
							+ secao.getUrna().getNumeroVotosPrefeito(partido.getCandidatoPrefeito());
				}
			}
		}
		return numeroVotosTotal;
	}

	private void somaVotosVereadores() {
		for (Partido partido : partidos) {
			for (ZonaEleitoral zona : zonas) {
				for (SecaoEleitoral secao : zona.getTodasSecoes()) {
					for (Vereador vere : partido.getCandidatosVereador())
						vere.addNumeroVotos(secao.getUrna().getNumeroVotosVereador(vere));
				}
			}
		}
	}

	private ArrayList<Prefeito> prefeitoMaisVotado() {
		ArrayList<Prefeito> prefeitos = new ArrayList<Prefeito>();
		for (Partido partido : partidos) {
			prefeitos.add(partido.getCandidatoPrefeito());
		}
		Prefeito prefeitoMaisVotado = new Prefeito(null, 0, null);
		Prefeito segundoPrefeito = new Prefeito(null, 0, null);
		for (Prefeito pref : prefeitos) {
			if (prefeitoMaisVotado.getNumeroVotos() < segundoPrefeito.getNumeroVotos()) {
				Prefeito temp = prefeitoMaisVotado;
				prefeitoMaisVotado = segundoPrefeito;
				segundoPrefeito = temp;
			}
			if (pref.getNumeroVotos() >= segundoPrefeito.getNumeroVotos()) {
				segundoPrefeito = pref;
			}
		}
		ArrayList<Prefeito> votados = new ArrayList<Prefeito>();
		votados.add(prefeitoMaisVotado);
		votados.add(segundoPrefeito);
		votados.add(prefeitos.get(0));
		return votados;
	}

	public ArrayList<Prefeito> ApuracaoPrefeito() throws Exception {
		if (this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().getClass() == UrnaFechada.class) {
			int numeroVotosTotal = somaVotosPrefeito();
			ArrayList<Prefeito> prefeitos = prefeitoMaisVotado();

			int votosNulos = prefeitos.get(2).getNumeroVotos();

			ArrayList<Prefeito> Eleito = new ArrayList<Prefeito>();
			prefeitos.get(0).addNumeroVotos(votosNulos);
			if (prefeitos.get(0).getNumeroVotos() > numeroVotosTotal / 2)
				Eleito.add(prefeitos.get(0));
			else {
				Eleito.add(prefeitos.get(0));
				Eleito.add(prefeitos.get(1));
			}
			return Eleito;
		} else
			throw new Exception("Urnas estão abertas");
	}

	public Prefeito apuracaoSegundoTurno(ArrayList<Prefeito> seg) {
		if (seg.get(0).getNumeroVotos() >= seg.get(1).getNumeroVotos())
			return seg.get(0);
		else
			return seg.get(1);
	}

	public ArrayList<Vereador> ApuracaoVereador() throws Exception {
		somaVotosVereadores();
		if (this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().getClass() == UrnaFechada.class) {
			ArrayList<Vereador> vereadores = new ArrayList<Vereador>();
			for (Partido partido : partidos) {
				vereadores.addAll(partido.getCandidatosVereador());
			}
			Vereador vereadorMaisVotado = new Vereador(null, 0, null);
			Vereador segundoVereador = new Vereador(null, 0, null);
			for (Vereador pref : vereadores) {
				if (vereadorMaisVotado.getNumeroVotos() < segundoVereador.getNumeroVotos()) {
					Vereador temp = vereadorMaisVotado;
					vereadorMaisVotado = segundoVereador;
					segundoVereador = temp;
				}
				if (pref.getNumeroVotos() >= segundoVereador.getNumeroVotos()) {
					segundoVereador = pref;
				}
			}
			ArrayList<Vereador> votados = new ArrayList<Vereador>();
			votados.add(vereadorMaisVotado);
			votados.add(segundoVereador);
			return votados;
		} else
			throw new Exception("Urnas estão abertas");
	}

	public void FecharUrnas() throws Exception {
		for (ZonaEleitoral zona : zonas) {
			for (SecaoEleitoral secao : zona.getTodasSecoes()) {
				secao.getUrna().fechaUrna(secao.getUrna());
			}
		}
	}

	public void AbrirUrnas() throws Exception {
		for (ZonaEleitoral zona : zonas) {
			for (SecaoEleitoral secao : zona.getTodasSecoes()) {
				secao.getUrna().abreUrna(secao.getUrna());
			}
		}
		for (Partido partido : this.partidos)
			partido.setCandidatoPrefeito(new Prefeito(partido.getCandidatoPrefeito().getNomeCampanhaCandidato(),
					partido.getCandidatoPrefeito().getNumeroCampanha(),
					partido.getCandidatoPrefeito().getDadosPessoais()));
	}

	public String getEstadoUrna() {
		return this.zonas.get(0).getTodasSecoes().get(0).getUrna().getEstado().estadoToString();
	}

	public void adicionarZonaEleitoral() throws Exception {
		int teste = 0;
		do {
			int numeroCart;
			String lugarCart;
			numeroCart = Integer.parseInt(JOptionPane.showInputDialog("Digite o  numero da Zona Eleitoral"));
			lugarCart = JOptionPane.showInputDialog("Digite o lugar da Zona Eleitoral");
			cadastraZonaEleitoral(numeroCart, lugarCart);
			teste = JOptionPane.showConfirmDialog(null, "Quer adicionar mais Zonas Eleitorais?", "Adicionar Zonas", 0);
			;
		} while (teste == 0);
	}

	public void adicionaSecaoEleitoral() throws Exception {
		int teste = 0;
		do {
			int numeroZona;
			numeroZona = Integer.parseInt(
					JOptionPane.showInputDialog("Digite o numero da Zona Eleitoral que sera acrescida de uma seção"));
			addSecao(numeroZona);
			teste = JOptionPane.showConfirmDialog(null, "Quer adicionar mais Seções Eleitorais?", "Adicionar Seção", 0);
			;
		} while (teste == 0);
	}

	public void adicionaEleitor() throws Exception {
		int teste = 0;
		do {
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o Cpf do Eleitor"));
			String nome = JOptionPane.showInputDialog("Digite o nome do Eleitor");
			int titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o Titulo do Eleitor"));
			;
			Eleitor eleitor = new Eleitor(cpf, nome, titulo);
			int numeroZona = Integer.parseInt(
					JOptionPane.showInputDialog("Digite o numero da Zona Eleitoral para adicionar o Eleitor"));
			int numeroSecao = Integer.parseInt(
					JOptionPane.showInputDialog("Digite o numero da Seção Eleitoral para adicionar o Eleitor"));
			eleitor.setZona(this.getZona(numeroZona));
			eleitor.setSecao(eleitor.getZona().getSecao(numeroSecao));
			getZona(numeroZona).getSecao(numeroSecao).addEleitor(eleitor);
			eleitores.set(titulo, eleitor);
			teste = JOptionPane.showConfirmDialog(null, "Quer adicionar mais Eleitores?", "Adicionar Eleitor", 0);
			;
		} while (teste == 0);
	}

	public void adicionaPartido() throws Exception {
		int teste = 0;
		do {
			String sigla = JOptionPane.showInputDialog("Digite a sigla do Partido");
			String nome = JOptionPane.showInputDialog("Digite o nome do Partido");
			cadastraPartido(sigla, nome);
			teste = JOptionPane.showConfirmDialog(null, "Quer adicionar mais Partidos?", "Adicionar Partido", 0);
			;
		} while (teste == 0);
	}

	public void adicionaPrefeito(int i) throws Exception {
		// TODO Auto-generated method stub
		String nomeCampanha = JOptionPane.showInputDialog("Digite o nome de Campanha do Candidato");
		int tituloEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite o titulo de eleitor do candidato"));
		int zonaEleitor = eleitores.get(tituloEleitor).getZona().getNumeroZona();
		int secaoEleitor = eleitores.get(tituloEleitor).getSecao().getNumeroSecao();
		Prefeito candidato = new Prefeito(nomeCampanha, getPartido(i).getNumeroPartido(),
				getZona(zonaEleitor).getSecao(secaoEleitor).getEleitor(tituloEleitor));
		getPartido(i).setCandidatoPrefeito(candidato);
	}

	public void adicionaVereador(int i) throws Exception {
		int teste = 0;
		do {
			String nomeCampanha = JOptionPane.showInputDialog("Digite o nome de Campanha do Candidato");
			int numeroCampanha = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de Campanha"));
			int tituloEleitor = Integer
					.parseInt(JOptionPane.showInputDialog("Digite o titulo de eleitor do candidato"));
			int zonaEleitor = eleitores.get(tituloEleitor).getZona().getNumeroZona();
			int secaoEleitor = eleitores.get(tituloEleitor).getSecao().getNumeroSecao();

			Vereador candidato = new Vereador(nomeCampanha, numeroCampanha,
					getZona(zonaEleitor).getSecao(secaoEleitor).getEleitor(tituloEleitor));

			getPartido(i).addCandidatosVereador(candidato);
			vereadores.set(numeroCampanha, candidato);

			teste = JOptionPane.showConfirmDialog(null,
					"Quer adicionar mais Candidatos a Vereador para o partido: " + getPartido(i).getNome() + " ?",
					"Adicionar Candidato a Vereador", 0);
		} while (teste == 0);
	}

	public void adicionarVotos() throws Exception {
		if(this.getEstadoUrna() != "Urna Aberta")
			AbrirUrnas();
		int teste1 = 0;
		do {
			JOptionPane.showMessageDialog(null, "A Seguir iremos adicionar os Votos");

			int zonaEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite a zona eleitoral do eleitor"));
			int secaoEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite a secao eleitoral do eleitor"));
			Urna urna = getZona(zonaEleitor).getSecao(secaoEleitor).getUrna();

			int teste2 = 0;
			do {
				int titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o titulo do eleitor"));
				int numeroPrefeito = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite o numero de campanha do Candidato a Prefeito, e igual ao numero do partido"));
				int numeroVereador = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o numero de campanha do Candidato a Vereador"));

				Vereador vereador = vereadores.get(numeroVereador);
				urna.addVoto(getPartido(numeroPrefeito).getCandidatoPrefeito(), vereador,
						getZona(zonaEleitor).getSecao(secaoEleitor).getEleitor(titulo));

				teste2 = JOptionPane.showConfirmDialog(null, "Quer adicionar mais votos nessa urna?",
						"Adicionar Votos na Urna", 0);
				;
			} while (teste2 == 0);
			teste1 = JOptionPane.showConfirmDialog(null, "Quer adicionar mais votos?", "Adicionar Votos", 0);
		} while (teste1 == 0);
	}

	public void apuracaoGeral()
			throws Exception {
		ArrayList<Prefeito> eleito = new ArrayList<Prefeito>();
		Prefeito eleitoFinal = null;
		ArrayList<Vereador> vereadorEleito = new ArrayList<Vereador>();
		FecharUrnas();
		eleito = ApuracaoPrefeito();
		eleitoFinal = eleito.get(0);
		vereadorEleito = ApuracaoVereador();
		if (eleito.size() == 2) {
			try {
				AbrirUrnas();
				adicionaVoto2Turno(eleito);
				FecharUrnas();
				eleitoFinal = apuracaoSegundoTurno(eleito);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		System.out.println("Vereadores eleitos: \n" + vereadorEleito.get(0).getNomeCampanhaCandidato() + " , "
				+ vereadorEleito.get(1).getNomeCampanhaCandidato().toString() + "\nPrefeito eleito:\n"
				+ eleitoFinal.getNomeCampanhaCandidato());
	}

	public void adicionaVoto2Turno(ArrayList<Prefeito> eleito) throws Exception {
		int teste1 = 0;
		JOptionPane.showMessageDialog(null,
				"Foi necessario um segundo turno para essa votação, favor seguir as instruções");
		JOptionPane.showMessageDialog(null, "A Seguir iremos adicionar os Votos para segundo turno");
		JOptionPane.showMessageDialog(null,
				"Os Prefeitos concorrendo sao: \n" + eleito.get(0).getNomeCampanhaCandidato()
						+ eleito.get(0).getNumeroCampanha() + "\n" + eleito.get(1).getNomeCampanhaCandidato()
						+ eleito.get(1).getNumeroCampanha());
		do {
			int zonaEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite a zona eleitoral do eleitor"));
			int secaoEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite a secao eleitoral do eleitor"));
			Urna urna = getZona(zonaEleitor).getSecao(secaoEleitor).getUrna();
			int teste2 = 0;
			do {
				int titulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o titulo do eleitor"));
				int numeroPrefeito = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o numero de campanha do Candidato a Prefeito"));
				urna.addVotoSegundoTurno(getPartido(numeroPrefeito).getCandidatoPrefeito(),
						getZona(zonaEleitor).getSecao(secaoEleitor).getEleitor(titulo));
				teste2 = JOptionPane.showConfirmDialog(null, "Quer adicionar mais votos nessa urna?",
						"Adicionar Votos na Urna", 0);
				;
			} while (teste2 == 0);
			teste1 = JOptionPane.showConfirmDialog(null, "Quer adicionar mais votos?", "Adicionar Votos", 0);
			;
		} while (teste1 == 0);
	}
}
