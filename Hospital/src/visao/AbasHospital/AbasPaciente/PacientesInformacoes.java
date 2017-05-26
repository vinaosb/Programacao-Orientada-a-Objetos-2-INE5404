package visao.AbasHospital.AbasPaciente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.FachadaHospital;
import modelo.Paciente;

public class PacientesInformacoes {

	private static JComboBox cmbNomeDosPacientes;
	private static JTextArea txtrDiagnostico;
	private static JTextArea txtrMedicoResponsavel;
	private static JTextArea txtrDataDeEntrada;
	private static JTextArea txtrEndereco;
	private static JTextArea txtrDataDeSaida;
	private static JTextArea txtrQuartoDoPaciente;
	private static JTextArea txtrQueixaDoPaciente;

	public static JPanel informacoesPacientes(FachadaHospital fachada) {
		JPanel InformacoesPaciente = new JPanel();
		GridBagLayout gbl_InformacoesPaciente = new GridBagLayout();
		gbl_InformacoesPaciente.columnWidths = new int[] { 1, 50, 50, 50, 50, 50, 0, 0, 96, 50, 50, 50, 0 };
		gbl_InformacoesPaciente.rowHeights = new int[] { 50, 50, 50, 50, 50, 50, 0, 0 };
		gbl_InformacoesPaciente.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_InformacoesPaciente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		InformacoesPaciente.setLayout(gbl_InformacoesPaciente);

		JButton btnCarregarPacientes = new JButton("Carregar Pacientes");
		btnCarregarPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmbNomeDosPacientes.removeAllItems();
				for (Paciente pac : fachada.getListaPacientes())
					cmbNomeDosPacientes.addItem(pac.getNome());
			}
		});
		GridBagConstraints gbc_btnCarregarPacientes = new GridBagConstraints();
		gbc_btnCarregarPacientes.insets = new Insets(0, 0, 5, 5);
		gbc_btnCarregarPacientes.gridx = 1;
		gbc_btnCarregarPacientes.gridy = 0;
		InformacoesPaciente.add(btnCarregarPacientes, gbc_btnCarregarPacientes);

		JButton btnSalvarPaciente = new JButton("Salvar Paciente");
		btnSalvarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = cmbNomeDosPacientes.getSelectedIndex();
				Paciente pac = fachada.getListaPacientes().get(index);
				pac.setLastInternacao(txtrDiagnostico.getText(), txtrMedicoResponsavel.getText(), null, null);
			}
		});
		GridBagConstraints gbc_btnSalvarPaciente = new GridBagConstraints();
		gbc_btnSalvarPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvarPaciente.gridx = 2;
		gbc_btnSalvarPaciente.gridy = 0;
		InformacoesPaciente.add(btnSalvarPaciente, gbc_btnSalvarPaciente);

		JLabel lblNomeDoPaciente = new JLabel("Nome do Paciente");
		GridBagConstraints gbc_lblNomeDoPaciente = new GridBagConstraints();
		gbc_lblNomeDoPaciente.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDoPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblNomeDoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoPaciente.gridx = 1;
		gbc_lblNomeDoPaciente.gridy = 1;
		InformacoesPaciente.add(lblNomeDoPaciente, gbc_lblNomeDoPaciente);

		cmbNomeDosPacientes = new JComboBox();
		cmbNomeDosPacientes.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int index = cmbNomeDosPacientes.getSelectedIndex();
				if (index != -1) {
					Paciente pac = fachada.getListaPacientes().get(index);
					txtrDataDeEntrada.setText(pac.getLastInternacao().getDataDeEntrada().getTime().toString());
					txtrEndereco.setText(pac.getEndereco());
					if (pac.getLastInternacao().getDataDeSaida() != null)
						txtrDataDeSaida.setText(pac.getLastInternacao().getDataDeSaida().getTime().toString());
					txtrMedicoResponsavel.setText(pac.getLastInternacao().getMedicoResponsavel());
					txtrQuartoDoPaciente
							.setText(Integer.toString(pac.getLastInternacao().getQuartoAlocado().getNumeroQuarto()));
					txtrQueixaDoPaciente.setText(pac.getLastInternacao().getQueixa());
				}
			}
		});
		cmbNomeDosPacientes.setModel(new DefaultComboBoxModel(new String[] { "Nome dos Pacientes" }));
		GridBagConstraints gbc_cmbNomeDosPacientes = new GridBagConstraints();
		gbc_cmbNomeDosPacientes.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNomeDosPacientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbNomeDosPacientes.gridx = 2;
		gbc_cmbNomeDosPacientes.gridy = 1;
		InformacoesPaciente.add(cmbNomeDosPacientes, gbc_cmbNomeDosPacientes);

		JLabel lblDataDeEntrada = new JLabel("Data de Entrada");
		GridBagConstraints gbc_lblDataDeEntrada = new GridBagConstraints();
		gbc_lblDataDeEntrada.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataDeEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDeEntrada.gridx = 4;
		gbc_lblDataDeEntrada.gridy = 1;
		InformacoesPaciente.add(lblDataDeEntrada, gbc_lblDataDeEntrada);

		txtrDataDeEntrada = new JTextArea();
		txtrDataDeEntrada.setEnabled(false);
		txtrDataDeEntrada.setEditable(false);
		txtrDataDeEntrada.setText("Data de Entrada");
		GridBagConstraints gbc_txtrDataDeEntrada = new GridBagConstraints();
		gbc_txtrDataDeEntrada.fill = GridBagConstraints.BOTH;
		gbc_txtrDataDeEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_txtrDataDeEntrada.gridx = 5;
		gbc_txtrDataDeEntrada.gridy = 1;
		InformacoesPaciente.add(txtrDataDeEntrada, gbc_txtrDataDeEntrada);

		JLabel lblEnderecoDoPaciente = new JLabel("Endereco do Paciente");
		GridBagConstraints gbc_lblEnderecoDoPaciente = new GridBagConstraints();
		gbc_lblEnderecoDoPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblEnderecoDoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnderecoDoPaciente.gridx = 1;
		gbc_lblEnderecoDoPaciente.gridy = 2;
		InformacoesPaciente.add(lblEnderecoDoPaciente, gbc_lblEnderecoDoPaciente);

		txtrEndereco = new JTextArea();
		txtrEndereco.setEnabled(false);
		txtrEndereco.setEditable(false);
		txtrEndereco.setText("EnderecoDoPaciente");
		GridBagConstraints gbc_txtrEndereco = new GridBagConstraints();
		gbc_txtrEndereco.fill = GridBagConstraints.BOTH;
		gbc_txtrEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtrEndereco.gridx = 2;
		gbc_txtrEndereco.gridy = 2;
		InformacoesPaciente.add(txtrEndereco, gbc_txtrEndereco);

		JLabel lblDataDeSaida = new JLabel("Data de Saida");
		GridBagConstraints gbc_lblDataDeSaida = new GridBagConstraints();
		gbc_lblDataDeSaida.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataDeSaida.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDeSaida.gridx = 4;
		gbc_lblDataDeSaida.gridy = 2;
		InformacoesPaciente.add(lblDataDeSaida, gbc_lblDataDeSaida);

		txtrDataDeSaida = new JTextArea();
		txtrDataDeSaida.setEnabled(false);
		txtrDataDeSaida.setEditable(false);
		txtrDataDeSaida.setText("Data de Saida");
		GridBagConstraints gbc_txtrDataDeSaida = new GridBagConstraints();
		gbc_txtrDataDeSaida.insets = new Insets(0, 0, 5, 5);
		gbc_txtrDataDeSaida.fill = GridBagConstraints.BOTH;
		gbc_txtrDataDeSaida.gridx = 5;
		gbc_txtrDataDeSaida.gridy = 2;
		InformacoesPaciente.add(txtrDataDeSaida, gbc_txtrDataDeSaida);

		JLabel lblQuartoDoPaciente = new JLabel("Quarto do Paciente");
		GridBagConstraints gbc_lblQuartoDoPaciente = new GridBagConstraints();
		gbc_lblQuartoDoPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblQuartoDoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuartoDoPaciente.gridx = 1;
		gbc_lblQuartoDoPaciente.gridy = 3;
		InformacoesPaciente.add(lblQuartoDoPaciente, gbc_lblQuartoDoPaciente);

		txtrQuartoDoPaciente = new JTextArea();
		txtrQuartoDoPaciente.setText("Quarto Do Paciente");
		GridBagConstraints gbc_txtrQuartoDoPaciente = new GridBagConstraints();
		gbc_txtrQuartoDoPaciente.fill = GridBagConstraints.BOTH;
		gbc_txtrQuartoDoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_txtrQuartoDoPaciente.gridx = 2;
		gbc_txtrQuartoDoPaciente.gridy = 3;
		InformacoesPaciente.add(txtrQuartoDoPaciente, gbc_txtrQuartoDoPaciente);

		JLabel lblMedicoResponsavel = new JLabel("Medico Responsavel");
		GridBagConstraints gbc_lblMedicoResponsavel = new GridBagConstraints();
		gbc_lblMedicoResponsavel.fill = GridBagConstraints.VERTICAL;
		gbc_lblMedicoResponsavel.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedicoResponsavel.gridx = 4;
		gbc_lblMedicoResponsavel.gridy = 3;
		InformacoesPaciente.add(lblMedicoResponsavel, gbc_lblMedicoResponsavel);

		txtrMedicoResponsavel = new JTextArea();
		txtrMedicoResponsavel.setText("Medico Responsavel");
		GridBagConstraints gbc_txtrMedicoResponsavel = new GridBagConstraints();
		gbc_txtrMedicoResponsavel.gridwidth = 3;
		gbc_txtrMedicoResponsavel.fill = GridBagConstraints.BOTH;
		gbc_txtrMedicoResponsavel.insets = new Insets(0, 0, 5, 5);
		gbc_txtrMedicoResponsavel.gridx = 5;
		gbc_txtrMedicoResponsavel.gridy = 3;
		InformacoesPaciente.add(txtrMedicoResponsavel, gbc_txtrMedicoResponsavel);

		JLabel lblQueixa = new JLabel("Queixa");
		GridBagConstraints gbc_lblQueixa = new GridBagConstraints();
		gbc_lblQueixa.fill = GridBagConstraints.VERTICAL;
		gbc_lblQueixa.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueixa.gridx = 1;
		gbc_lblQueixa.gridy = 4;
		InformacoesPaciente.add(lblQueixa, gbc_lblQueixa);

		JLabel lblDiagnostico = new JLabel("Diagnostico");
		GridBagConstraints gbc_lblDiagnostico = new GridBagConstraints();
		gbc_lblDiagnostico.fill = GridBagConstraints.VERTICAL;
		gbc_lblDiagnostico.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnostico.gridx = 4;
		gbc_lblDiagnostico.gridy = 4;
		InformacoesPaciente.add(lblDiagnostico, gbc_lblDiagnostico);

		txtrDiagnostico = new JTextArea();
		txtrDiagnostico.setText("Diagnostico");
		GridBagConstraints gbc_txtrDiagnostico = new GridBagConstraints();
		gbc_txtrDiagnostico.gridwidth = 3;
		gbc_txtrDiagnostico.gridheight = 3;
		gbc_txtrDiagnostico.fill = GridBagConstraints.BOTH;
		gbc_txtrDiagnostico.insets = new Insets(0, 0, 0, 5);
		gbc_txtrDiagnostico.gridx = 5;
		gbc_txtrDiagnostico.gridy = 4;
		InformacoesPaciente.add(txtrDiagnostico, gbc_txtrDiagnostico);

		txtrQueixaDoPaciente = new JTextArea();
		txtrQueixaDoPaciente.setEditable(false);
		txtrQueixaDoPaciente.setEnabled(false);
		txtrQueixaDoPaciente.setText("Queixa do Paciente");
		GridBagConstraints gbc_txtrQueixaDoPaciente = new GridBagConstraints();
		gbc_txtrQueixaDoPaciente.gridheight = 3;
		gbc_txtrQueixaDoPaciente.fill = GridBagConstraints.BOTH;
		gbc_txtrQueixaDoPaciente.insets = new Insets(0, 0, 0, 5);
		gbc_txtrQueixaDoPaciente.gridx = 2;
		gbc_txtrQueixaDoPaciente.gridy = 4;
		InformacoesPaciente.add(txtrQueixaDoPaciente, gbc_txtrQueixaDoPaciente);
		return InformacoesPaciente;
	}

}
