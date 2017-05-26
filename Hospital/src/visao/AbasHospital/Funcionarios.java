package visao.AbasHospital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import modelo.FachadaHospital;

public class Funcionarios {

	private static JTextField txtCodigo;

	public static JTabbedPane Funcionarioss(FachadaHospital fachada) {
		JTabbedPane Funcionarios = new JTabbedPane(SwingConstants.TOP);

		JPanel BaterPonto = new JPanel();
		Funcionarios.addTab("Bater Ponto", null, BaterPonto, null);
		SpringLayout sl_BaterPonto = new SpringLayout();
		BaterPonto.setLayout(sl_BaterPonto);

		JLabel lblCodigoDoFuncionario = new JLabel("Codigo do Funcionario");
		sl_BaterPonto.putConstraint(SpringLayout.NORTH, lblCodigoDoFuncionario, 164, SpringLayout.NORTH, BaterPonto);
		sl_BaterPonto.putConstraint(SpringLayout.WEST, lblCodigoDoFuncionario, 102, SpringLayout.WEST, BaterPonto);
		BaterPonto.add(lblCodigoDoFuncionario);

		txtCodigo = new JTextField();
		txtCodigo.setText("Codigo");
		sl_BaterPonto.putConstraint(SpringLayout.NORTH, txtCodigo, 0, SpringLayout.NORTH, lblCodigoDoFuncionario);
		sl_BaterPonto.putConstraint(SpringLayout.WEST, txtCodigo, 65, SpringLayout.EAST, lblCodigoDoFuncionario);
		BaterPonto.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnBaterPonto = new JButton("Bater Ponto");
		btnBaterPonto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fachada.getFuncionarioPorCodigo(Integer.parseInt(getTxtCodigo().getText())).baterPonto();
			}
		});
		sl_BaterPonto.putConstraint(SpringLayout.NORTH, btnBaterPonto, 67, SpringLayout.SOUTH, lblCodigoDoFuncionario);
		sl_BaterPonto.putConstraint(SpringLayout.WEST, btnBaterPonto, 184, SpringLayout.WEST, BaterPonto);
		BaterPonto.add(btnBaterPonto);

		return Funcionarios;
	}

	protected static JTextField getTxtCodigo() {
		return txtCodigo;
	}
}
