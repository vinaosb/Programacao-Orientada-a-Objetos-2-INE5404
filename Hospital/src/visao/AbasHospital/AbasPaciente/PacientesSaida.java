package visao.AbasHospital.AbasPaciente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import modelo.FachadaHospital;
import modelo.Paciente;

public class PacientesSaida {

	public static JPanel painelDeSaida(FachadaHospital fachada) {
		JPanel SaidaPaciente = new JPanel();
		SpringLayout sl_SaidaPaciente = new SpringLayout();
		SaidaPaciente.setLayout(sl_SaidaPaciente);

		JComboBox nomeDosPacientes = new JComboBox();
		nomeDosPacientes.setModel(new DefaultComboBoxModel(new String[] { "Nome dos Pacientes" }));
		nomeDosPacientes.setToolTipText("Nome dos Pacientes");
		sl_SaidaPaciente.putConstraint(SpringLayout.WEST, nomeDosPacientes, 50, SpringLayout.WEST, SaidaPaciente);
		sl_SaidaPaciente.putConstraint(SpringLayout.SOUTH, nomeDosPacientes, -200, SpringLayout.SOUTH, SaidaPaciente);
		SaidaPaciente.add(nomeDosPacientes);

		JButton btnAdicionarDataDe = new JButton("Adicionar data de Saida para o Paciente");
		btnAdicionarDataDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = nomeDosPacientes.getSelectedIndex();
				Paciente pac = fachada.getListaPacientes().get(index);
				pac.setLastInternacao(null, null, Calendar.getInstance(), null);
			}
		});
		sl_SaidaPaciente.putConstraint(SpringLayout.SOUTH, btnAdicionarDataDe, -300, SpringLayout.SOUTH, SaidaPaciente);
		sl_SaidaPaciente.putConstraint(SpringLayout.WEST, btnAdicionarDataDe, 300, SpringLayout.WEST, SaidaPaciente);
		SaidaPaciente.add(btnAdicionarDataDe);

		JButton btnCarregarPacientes_1 = new JButton("Carregar Pacientes");
		btnCarregarPacientes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeDosPacientes.removeAllItems();
				for (Paciente pac : fachada.getListaPacientes())
					nomeDosPacientes.addItem(pac.getNome());
			}
		});
		sl_SaidaPaciente.putConstraint(SpringLayout.WEST, btnCarregarPacientes_1, 50, SpringLayout.WEST, SaidaPaciente);
		sl_SaidaPaciente.putConstraint(SpringLayout.SOUTH, btnCarregarPacientes_1, -350, SpringLayout.SOUTH,
				SaidaPaciente);
		SaidaPaciente.add(btnCarregarPacientes_1);

		return SaidaPaciente;
	}

}
