package visao.AbasHospital.AbasPaciente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import modelo.FachadaHospital;
import modelo.Internacao;
import modelo.Paciente;

public class PacientesEntrada {

	public static JPanel entradaPacientes(FachadaHospital fachada) {
		JPanel entradaPaciente = new JPanel();
		SpringLayout sl_EntradaPaciente = new SpringLayout();
		entradaPaciente.setLayout(sl_EntradaPaciente);

		JComboBox nomeDosPacientess = new JComboBox();
		nomeDosPacientess.setModel(new DefaultComboBoxModel(new String[] { "Nome dos Pacientes" }));
		nomeDosPacientess.setToolTipText("Nome dos Pacientes");
		sl_EntradaPaciente.putConstraint(SpringLayout.WEST, nomeDosPacientess, 68, SpringLayout.WEST, entradaPaciente);
		sl_EntradaPaciente.putConstraint(SpringLayout.SOUTH, nomeDosPacientess, -189, SpringLayout.SOUTH,
				entradaPaciente);
		entradaPaciente.add(nomeDosPacientess);

		JButton btnAdicionarDataEn = new JButton("Adicionar data de Entrada para o Paciente");
		btnAdicionarDataEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = nomeDosPacientess.getSelectedIndex();
				Paciente pac = fachada.getListaPacientes().get(index);
				pac.getInternacoes().add(new Internacao("Nova Queixa"));
			}
		});
		sl_EntradaPaciente.putConstraint(SpringLayout.NORTH, nomeDosPacientess, -14, SpringLayout.NORTH,
				btnAdicionarDataEn);
		sl_EntradaPaciente.putConstraint(SpringLayout.EAST, nomeDosPacientess, -6, SpringLayout.WEST,
				btnAdicionarDataEn);
		sl_EntradaPaciente.putConstraint(SpringLayout.NORTH, btnAdicionarDataEn, 182, SpringLayout.NORTH,
				entradaPaciente);
		sl_EntradaPaciente.putConstraint(SpringLayout.WEST, btnAdicionarDataEn, 314, SpringLayout.WEST,
				entradaPaciente);
		entradaPaciente.add(btnAdicionarDataEn);

		JButton btnCarregarPacientes_2 = new JButton("Carregar Paciente");
		btnCarregarPacientes_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeDosPacientess.removeAllItems();
				for (Paciente pac : fachada.getListaPacientes())
					nomeDosPacientess.addItem(pac.getNome());
			}
		});
		sl_EntradaPaciente.putConstraint(SpringLayout.WEST, btnCarregarPacientes_2, 137, SpringLayout.WEST,
				entradaPaciente);
		sl_EntradaPaciente.putConstraint(SpringLayout.SOUTH, btnCarregarPacientes_2, -32, SpringLayout.NORTH,
				nomeDosPacientess);
		entradaPaciente.add(btnCarregarPacientes_2);
		return entradaPaciente;
	}

}
