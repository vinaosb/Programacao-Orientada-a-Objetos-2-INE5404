package visao.AbasHospital;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import modelo.FachadaHospital;
import modelo.Funcionario;

public class Gerencia {

	private static JTextField txtCpf_1;
	private static JPasswordField pwdSenha;
	private static JTextField txtEntrada;
	private static JTextField txtNome;
	private static JTextField txtCpf_2;
	private static JTextField txtEndereo;
	private static JTextField txtSalario;
	private static JTextField txtSalario_1;
	private static JTextField txtHorasTrabalhadas;
	private static JTextField txtTotal;
	private static JComboBox cmbPeriodos;
	private static JTabbedPane ControleDeFuncionarios;
	private static JComboBox cmbFuncionarios;

	public static JTabbedPane Gerenciaa(FachadaHospital fachada) {

		JTabbedPane Gerencia = new JTabbedPane(SwingConstants.TOP);

		JPanel Acesso = new JPanel();
		Gerencia.addTab("Acesso", null, Acesso, null);
		SpringLayout sl_Acesso = new SpringLayout();
		Acesso.setLayout(sl_Acesso);

		txtCpf_1 = new JTextField();
		txtCpf_1.setText("CPF");
		sl_Acesso.putConstraint(SpringLayout.NORTH, txtCpf_1, 132, SpringLayout.NORTH, Acesso);
		sl_Acesso.putConstraint(SpringLayout.WEST, txtCpf_1, 185, SpringLayout.WEST, Acesso);
		Acesso.add(txtCpf_1);
		txtCpf_1.setColumns(10);

		pwdSenha = new JPasswordField();
		sl_Acesso.putConstraint(SpringLayout.NORTH, pwdSenha, 22, SpringLayout.SOUTH, txtCpf_1);
		sl_Acesso.putConstraint(SpringLayout.WEST, pwdSenha, 0, SpringLayout.WEST, txtCpf_1);
		sl_Acesso.putConstraint(SpringLayout.EAST, pwdSenha, -15, SpringLayout.EAST, txtCpf_1);
		pwdSenha.setText("Senha");
		Acesso.add(pwdSenha);

		JLabel lblCpf_1 = new JLabel("CPF");
		sl_Acesso.putConstraint(SpringLayout.NORTH, lblCpf_1, 3, SpringLayout.NORTH, txtCpf_1);
		sl_Acesso.putConstraint(SpringLayout.EAST, lblCpf_1, -20, SpringLayout.WEST, txtCpf_1);
		Acesso.add(lblCpf_1);

		JLabel lblSenha = new JLabel("Senha");
		sl_Acesso.putConstraint(SpringLayout.NORTH, lblSenha, 3, SpringLayout.NORTH, pwdSenha);
		sl_Acesso.putConstraint(SpringLayout.WEST, lblSenha, 0, SpringLayout.WEST, lblCpf_1);
		Acesso.add(lblSenha);

		JButton btnAcesar = new JButton("Acesar");
		btnAcesar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (fachada.getSenhaDoGerentePorCpf(Integer.parseInt(txtCpf_1.getText()))
						.equals(String.valueOf(pwdSenha.getPassword())))
					Gerencia.setEnabledAt(1, true);
				else
					JOptionPane.showMessageDialog(null, "Senha incorreta");
			}
		});
		sl_Acesso.putConstraint(SpringLayout.NORTH, btnAcesar, 48, SpringLayout.SOUTH, pwdSenha);
		sl_Acesso.putConstraint(SpringLayout.WEST, btnAcesar, 0, SpringLayout.WEST, txtCpf_1);
		Acesso.add(btnAcesar);

		ControleDeFuncionarios = new JTabbedPane(SwingConstants.TOP);
		Gerencia.addTab("Controle de Funcionarios", null, ControleDeFuncionarios, null);
		Gerencia.setEnabledAt(1, false);

		JPanel VerPontos = new JPanel();
		ControleDeFuncionarios.addTab("Ver Funcionarios Ativos", null, VerPontos, null);
		SpringLayout sl_VerPontos = new SpringLayout();
		VerPontos.setLayout(sl_VerPontos);

		JButton btnAtualizarFuncionarios = new JButton("Atualizar Funcionarios");
		btnAtualizarFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmbFuncionarios.removeAllItems();
				for (Funcionario func : fachada.getListaFuncionarios())
					cmbFuncionarios.addItem(func.getNome());
			}
		});
		sl_VerPontos.putConstraint(SpringLayout.NORTH, btnAtualizarFuncionarios, 56, SpringLayout.NORTH, VerPontos);
		sl_VerPontos.putConstraint(SpringLayout.WEST, btnAtualizarFuncionarios, 73, SpringLayout.WEST, VerPontos);
		VerPontos.add(btnAtualizarFuncionarios);

		cmbFuncionarios = new JComboBox();
		cmbFuncionarios.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int index = cmbFuncionarios.getSelectedIndex();
				if (index != -1) {
					int cod = fachada.getListaFuncionarios().get(index).getCodigoFunc();
					if (fachada.getFuncionarioPorCodigo(cod).getEntradaOuSaida() != null)
						txtEntrada.setText(fachada.getFuncionarioPorCodigo(cod).getEntradaOuSaida().toString());
				}
			}
		});
		sl_VerPontos.putConstraint(SpringLayout.NORTH, cmbFuncionarios, 20, SpringLayout.SOUTH,
				btnAtualizarFuncionarios);
		sl_VerPontos.putConstraint(SpringLayout.WEST, cmbFuncionarios, 0, SpringLayout.WEST, btnAtualizarFuncionarios);
		sl_VerPontos.putConstraint(SpringLayout.EAST, cmbFuncionarios, 0, SpringLayout.EAST, btnAtualizarFuncionarios);
		cmbFuncionarios.setModel(new DefaultComboBoxModel(new String[] { "Funcionarios" }));
		VerPontos.add(cmbFuncionarios);

		txtEntrada = new JTextField();
		txtEntrada.setText("Entrada");
		sl_VerPontos.putConstraint(SpringLayout.NORTH, txtEntrada, 27, SpringLayout.SOUTH, cmbFuncionarios);
		sl_VerPontos.putConstraint(SpringLayout.WEST, txtEntrada, 0, SpringLayout.WEST, btnAtualizarFuncionarios);
		VerPontos.add(txtEntrada);
		txtEntrada.setColumns(10);

		JPanel DemitirOuSalario = new JPanel();
		ControleDeFuncionarios.addTab("Demitir ou ver Salario", null, DemitirOuSalario, null);
		SpringLayout sl_DemitirOuSalario = new SpringLayout();
		DemitirOuSalario.setLayout(sl_DemitirOuSalario);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int index = comboBox.getSelectedIndex();
				if (index != -1) {
					Funcionario func = fachada.getListaFuncionarios().get(index);
					txtSalario_1.setText(String.valueOf(func.getSalario()));
					txtHorasTrabalhadas.setText(String.valueOf(func.horasTrabalhadas()));
					txtTotal.setText(Long.toString(func.pagarSalario()));
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Funcionarios" }));
		DemitirOuSalario.add(comboBox);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = comboBox.getSelectedIndex();
				fachada.getListaFuncionarios().get(index).limparPontos();
			}
		});

		DemitirOuSalario.add(btnAtualizar);

		JLabel lblQuantoPagar = new JLabel("Quanto pagar /h");
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, lblQuantoPagar, 50, SpringLayout.WEST, DemitirOuSalario);
		sl_DemitirOuSalario.putConstraint(SpringLayout.SOUTH, lblQuantoPagar, -251, SpringLayout.SOUTH,
				DemitirOuSalario);
		DemitirOuSalario.add(lblQuantoPagar);

		txtSalario_1 = new JTextField();
		sl_DemitirOuSalario.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, txtSalario_1);
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, txtSalario_1, -3, SpringLayout.NORTH, lblQuantoPagar);
		txtSalario_1.setEditable(false);
		txtSalario_1.setEnabled(false);
		txtSalario_1.setText("Salario/hora");
		DemitirOuSalario.add(txtSalario_1);
		txtSalario_1.setColumns(10);

		JButton btnDemitir = new JButton("Demitir");
		btnDemitir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = comboBox.getSelectedIndex();
				comboBox.remove(index);
				fachada.getListaFuncionarios().remove(index);
			}
		});
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, btnAtualizar, 0, SpringLayout.NORTH, btnDemitir);
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, btnAtualizar, 19, SpringLayout.EAST, btnDemitir);
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, btnDemitir, 130, SpringLayout.WEST, DemitirOuSalario);
		sl_DemitirOuSalario.putConstraint(SpringLayout.SOUTH, btnDemitir, -91, SpringLayout.SOUTH, DemitirOuSalario);
		DemitirOuSalario.add(btnDemitir);

		JLabel lblHorasTrabalhadas = new JLabel("Horas Trabalhadas");
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, lblHorasTrabalhadas, 167, SpringLayout.NORTH,
				DemitirOuSalario);
		sl_DemitirOuSalario.putConstraint(SpringLayout.EAST, lblHorasTrabalhadas, 0, SpringLayout.EAST, lblQuantoPagar);
		DemitirOuSalario.add(lblHorasTrabalhadas);

		txtHorasTrabalhadas = new JTextField();
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, txtHorasTrabalhadas, -3, SpringLayout.NORTH,
				lblHorasTrabalhadas);
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, txtHorasTrabalhadas, 26, SpringLayout.EAST,
				lblHorasTrabalhadas);
		sl_DemitirOuSalario.putConstraint(SpringLayout.EAST, txtHorasTrabalhadas, -530, SpringLayout.EAST,
				DemitirOuSalario);
		txtHorasTrabalhadas.setEditable(false);
		txtHorasTrabalhadas.setEnabled(false);
		txtHorasTrabalhadas.setText("Horas Trabalhadas");
		DemitirOuSalario.add(txtHorasTrabalhadas);
		txtHorasTrabalhadas.setColumns(10);

		JButton btnCarregarFuncionario = new JButton("Carregar Funcionario");
		btnCarregarFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				for (Funcionario func : fachada.getListaFuncionarios())
					comboBox.addItem(func.getNome());
			}
		});
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, btnCarregarFuncionario, 156, SpringLayout.WEST,
				DemitirOuSalario);
		sl_DemitirOuSalario.putConstraint(SpringLayout.SOUTH, btnCarregarFuncionario, -19, SpringLayout.NORTH,
				txtSalario_1);
		sl_DemitirOuSalario.putConstraint(SpringLayout.SOUTH, comboBox, -20, SpringLayout.NORTH,
				btnCarregarFuncionario);
		sl_DemitirOuSalario.putConstraint(SpringLayout.WEST, txtSalario_1, 0, SpringLayout.WEST,
				btnCarregarFuncionario);
		DemitirOuSalario.add(btnCarregarFuncionario);

		JLabel lblTotal = new JLabel("Total");
		DemitirOuSalario.add(lblTotal);

		txtTotal = new JTextField();
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, txtTotal, 44, SpringLayout.SOUTH, txtHorasTrabalhadas);
		sl_DemitirOuSalario.putConstraint(SpringLayout.NORTH, lblTotal, 3, SpringLayout.NORTH, txtTotal);
		sl_DemitirOuSalario.putConstraint(SpringLayout.EAST, lblTotal, -32, SpringLayout.WEST, txtTotal);
		sl_DemitirOuSalario.putConstraint(SpringLayout.EAST, txtTotal, 0, SpringLayout.EAST, txtSalario_1);
		txtTotal.setEditable(false);
		txtTotal.setEnabled(false);
		txtTotal.setText("Total");
		DemitirOuSalario.add(txtTotal);
		txtTotal.setColumns(10);

		JPanel Contratar = new JPanel();
		ControleDeFuncionarios.addTab("Contratar Funcionario", null, Contratar, null);
		SpringLayout sl_Contratar = new SpringLayout();
		Contratar.setLayout(sl_Contratar);

		JLabel lblNome = new JLabel("Nome");
		sl_Contratar.putConstraint(SpringLayout.NORTH, lblNome, 95, SpringLayout.NORTH, Contratar);
		sl_Contratar.putConstraint(SpringLayout.WEST, lblNome, 63, SpringLayout.WEST, Contratar);
		Contratar.add(lblNome);

		txtNome = new JTextField();
		txtNome.setText("Nome");
		sl_Contratar.putConstraint(SpringLayout.NORTH, txtNome, 0, SpringLayout.NORTH, lblNome);
		sl_Contratar.putConstraint(SpringLayout.WEST, txtNome, 35, SpringLayout.EAST, lblNome);
		Contratar.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf_2 = new JLabel("CPF");
		sl_Contratar.putConstraint(SpringLayout.NORTH, lblCpf_2, 32, SpringLayout.SOUTH, lblNome);
		sl_Contratar.putConstraint(SpringLayout.WEST, lblCpf_2, 0, SpringLayout.WEST, lblNome);
		Contratar.add(lblCpf_2);

		txtCpf_2 = new JTextField();
		txtCpf_2.setText("CPF");
		sl_Contratar.putConstraint(SpringLayout.NORTH, txtCpf_2, 0, SpringLayout.NORTH, lblCpf_2);
		sl_Contratar.putConstraint(SpringLayout.WEST, txtCpf_2, 0, SpringLayout.WEST, txtNome);
		Contratar.add(txtCpf_2);
		txtCpf_2.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		sl_Contratar.putConstraint(SpringLayout.NORTH, lblEndereo, 34, SpringLayout.SOUTH, lblCpf_2);
		sl_Contratar.putConstraint(SpringLayout.WEST, lblEndereo, 0, SpringLayout.WEST, lblNome);
		Contratar.add(lblEndereo);

		txtEndereo = new JTextField();
		sl_Contratar.putConstraint(SpringLayout.NORTH, txtEndereo, 28, SpringLayout.SOUTH, txtCpf_2);
		sl_Contratar.putConstraint(SpringLayout.WEST, txtEndereo, 18, SpringLayout.EAST, lblEndereo);
		sl_Contratar.putConstraint(SpringLayout.SOUTH, txtEndereo, 76, SpringLayout.SOUTH, txtCpf_2);
		txtEndereo.setText("Endere\u00E7o");
		Contratar.add(txtEndereo);
		txtEndereo.setColumns(10);

		JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionario");
		btnAdicionarFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fachada.addFuncionario(new Funcionario(txtNome.getText(), txtEndereo.getText(),
						Integer.parseInt(txtCpf_2.getText()), Integer.parseInt(txtSalario.getText())));
			}
		});
		sl_Contratar.putConstraint(SpringLayout.NORTH, btnAdicionarFuncionario, 0, SpringLayout.NORTH, lblCpf_2);
		sl_Contratar.putConstraint(SpringLayout.WEST, btnAdicionarFuncionario, 86, SpringLayout.EAST, txtCpf_2);
		Contratar.add(btnAdicionarFuncionario);

		JLabel lblSalario = new JLabel("Salario");
		sl_Contratar.putConstraint(SpringLayout.NORTH, lblSalario, 71, SpringLayout.SOUTH, lblEndereo);
		sl_Contratar.putConstraint(SpringLayout.WEST, lblSalario, 0, SpringLayout.WEST, lblNome);
		Contratar.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setText("Salario");
		sl_Contratar.putConstraint(SpringLayout.WEST, txtSalario, 0, SpringLayout.WEST, txtNome);
		sl_Contratar.putConstraint(SpringLayout.SOUTH, txtSalario, 0, SpringLayout.SOUTH, lblSalario);
		Contratar.add(txtSalario);
		txtSalario.setColumns(10);
		return Gerencia;
	}

}
