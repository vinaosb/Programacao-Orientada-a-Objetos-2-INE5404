package visao.AbasHospital.AbasPaciente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.Convenio;
import modelo.FachadaHospital;

public class PacientesAdicionar {

	private static JTextField txtCpf;
	private static JComboBox cmbConvenios;

	public static JPanel adicionaPaciente(FachadaHospital fachada) {
		JPanel AdicionarPaciente = new JPanel();
		GridBagLayout gbl_AdicionarPaciente = new GridBagLayout();
		gbl_AdicionarPaciente.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_AdicionarPaciente.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_AdicionarPaciente.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_AdicionarPaciente.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		AdicionarPaciente.setLayout(gbl_AdicionarPaciente);

		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		GridBagConstraints gbc_lblNomePaciente = new GridBagConstraints();
		gbc_lblNomePaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomePaciente.gridx = 1;
		gbc_lblNomePaciente.gridy = 1;
		AdicionarPaciente.add(lblNomePaciente, gbc_lblNomePaciente);

		JTextArea txtrNomeDoPaciente = new JTextArea();
		txtrNomeDoPaciente.setText("Nome do Paciente");
		GridBagConstraints gbc_txtrNomeDoPaciente = new GridBagConstraints();
		gbc_txtrNomeDoPaciente.insets = new Insets(0, 0, 5, 0);
		gbc_txtrNomeDoPaciente.fill = GridBagConstraints.BOTH;
		gbc_txtrNomeDoPaciente.gridx = 2;
		gbc_txtrNomeDoPaciente.gridy = 1;
		AdicionarPaciente.add(txtrNomeDoPaciente, gbc_txtrNomeDoPaciente);

		JLabel lblEnderecoDoPaciente_1 = new JLabel("Endereco do Paciente");
		GridBagConstraints gbc_lblEnderecoDoPaciente_1 = new GridBagConstraints();
		gbc_lblEnderecoDoPaciente_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnderecoDoPaciente_1.gridx = 1;
		gbc_lblEnderecoDoPaciente_1.gridy = 2;
		AdicionarPaciente.add(lblEnderecoDoPaciente_1, gbc_lblEnderecoDoPaciente_1);

		JTextArea txtrEnderecoDoPaciente = new JTextArea();
		txtrEnderecoDoPaciente.setText("Endereco do Paciente");
		GridBagConstraints gbc_txtrEnderecoDoPaciente = new GridBagConstraints();
		gbc_txtrEnderecoDoPaciente.insets = new Insets(0, 0, 5, 0);
		gbc_txtrEnderecoDoPaciente.fill = GridBagConstraints.BOTH;
		gbc_txtrEnderecoDoPaciente.gridx = 2;
		gbc_txtrEnderecoDoPaciente.gridy = 2;
		AdicionarPaciente.add(txtrEnderecoDoPaciente, gbc_txtrEnderecoDoPaciente);

		JLabel lblCpf = new JLabel("CPF");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 1;
		gbc_lblCpf.gridy = 3;
		AdicionarPaciente.add(lblCpf, gbc_lblCpf);

		txtCpf = new JTextField();
		txtCpf.setText("cpf");
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.insets = new Insets(0, 0, 5, 0);
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.gridx = 2;
		gbc_txtCpf.gridy = 3;
		AdicionarPaciente.add(txtCpf, gbc_txtCpf);
		txtCpf.setColumns(10);

		JLabel lblQueixaDoPaciente = new JLabel("Queixa do Paciente");
		GridBagConstraints gbc_lblQueixaDoPaciente = new GridBagConstraints();
		gbc_lblQueixaDoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblQueixaDoPaciente.gridx = 1;
		gbc_lblQueixaDoPaciente.gridy = 4;
		AdicionarPaciente.add(lblQueixaDoPaciente, gbc_lblQueixaDoPaciente);

		JTextArea txtrQueixaDoPaciente_1 = new JTextArea();
		txtrQueixaDoPaciente_1.setText("Queixa do Paciente");
		GridBagConstraints gbc_txtrQueixaDoPaciente_1 = new GridBagConstraints();
		gbc_txtrQueixaDoPaciente_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtrQueixaDoPaciente_1.fill = GridBagConstraints.BOTH;
		gbc_txtrQueixaDoPaciente_1.gridx = 2;
		gbc_txtrQueixaDoPaciente_1.gridy = 4;
		AdicionarPaciente.add(txtrQueixaDoPaciente_1, gbc_txtrQueixaDoPaciente_1);

		JLabel lblConvenio = new JLabel("Convenio");
		GridBagConstraints gbc_lblConvenio = new GridBagConstraints();
		gbc_lblConvenio.anchor = GridBagConstraints.EAST;
		gbc_lblConvenio.insets = new Insets(0, 0, 5, 5);
		gbc_lblConvenio.gridx = 1;
		gbc_lblConvenio.gridy = 5;
		AdicionarPaciente.add(lblConvenio, gbc_lblConvenio);

		cmbConvenios = new JComboBox();
		cmbConvenios.setModel(new DefaultComboBoxModel(new String[] { "Convenios" }));
		GridBagConstraints gbc_cmbConvenios = new GridBagConstraints();
		gbc_cmbConvenios.insets = new Insets(0, 0, 5, 0);
		gbc_cmbConvenios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbConvenios.gridx = 2;
		gbc_cmbConvenios.gridy = 5;
		AdicionarPaciente.add(cmbConvenios, gbc_cmbConvenios);
		cmbConvenios.removeAllItems();
		for (Convenio conv : fachada.getListaConvenios())
			cmbConvenios.addItem(conv.getNome());

		JButton btnAdicionarPaciente = new JButton("Adicionar Paciente");
		btnAdicionarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					fachada.addPaciente(txtrNomeDoPaciente.getText(), txtrEnderecoDoPaciente.getText(),
							txtrQueixaDoPaciente_1.getText(), Integer.parseInt(txtCpf.getText()),
							fachada.getListaConvenios().get(cmbConvenios.getSelectedIndex()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				;
			}
		});
		GridBagConstraints gbc_btnAdicionarPaciente = new GridBagConstraints();
		gbc_btnAdicionarPaciente.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarPaciente.gridx = 2;
		gbc_btnAdicionarPaciente.gridy = 7;
		AdicionarPaciente.add(btnAdicionarPaciente, gbc_btnAdicionarPaciente);
		return AdicionarPaciente;
	}
}
