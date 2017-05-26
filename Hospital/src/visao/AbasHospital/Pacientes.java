package visao.AbasHospital;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import interfaces.Convenio;
import modelo.FachadaHospital;
import modelo.Funcionario;
import modelo.Internacao;
import modelo.Paciente;
import visao.AbasHospital.AbasPaciente.PacientesAdicionar;
import visao.AbasHospital.AbasPaciente.PacientesEntrada;
import visao.AbasHospital.AbasPaciente.PacientesInformacoes;
import visao.AbasHospital.AbasPaciente.PacientesSaida;

public class Pacientes {

	public static JTabbedPane Paciente(FachadaHospital fachada) {

		JTabbedPane Pacientes = new JTabbedPane(SwingConstants.TOP);

		Pacientes.addTab("Adicionar Paciente", null, PacientesAdicionar.adicionaPaciente(fachada), null);
		Pacientes.addTab("InformacoesPaciente", null, PacientesInformacoes.informacoesPacientes(fachada), null);
		Pacientes.addTab("Entrada Paciente", null, PacientesEntrada.entradaPacientes(fachada), null);
		Pacientes.addTab("Saida Paciente", null, PacientesSaida.painelDeSaida(fachada), null);

		return Pacientes;
	}

}
