package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import modelo.Ala;
import modelo.FachadaHospital;
import modelo.LoadStore;
import modelo.Paciente;
import modelo.Quarto;
import visao.AbasHospital.Funcionarios;
import visao.AbasHospital.Gerencia;
import visao.AbasHospital.Pacientes;

public class Hospital {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Hospital window = new Hospital();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JTextField txtQuartoDesignado;
	private JTextField txtQuartosVagos;
	private JTextField txtQuartosEmUso;
	private FachadaHospital fachada;

	private LoadStore loadStore;
	private JComboBox<String> cmbPaciente;
	private JComboBox<String> cmbAlaAlocar;
	private JComboBox<String> cmbAlas;

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Hospital() throws Exception {
		loadStore = new LoadStore();
		fachada = new FachadaHospital();
		initialize();
	}

	protected JComboBox<String> getCmbAlaAlocar() {
		return cmbAlaAlocar;
	}

	protected JComboBox<String> getCmbAlas() {
		return cmbAlas;
	}

	protected JComboBox<String> getCmbPaciente() {
		return cmbPaciente;
	}

	protected JTextField getTxtQuartoDesignado() {
		return txtQuartoDesignado;
	}

	protected JTextField getTxtQuartosEmUso() {
		return txtQuartosEmUso;
	}

	protected JTextField getTxtQuartosVagos() {
		return txtQuartosVagos;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					loadStore.StoreFachada(fachada);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		frame.setBounds(100, 100, 814, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("Pacientes", null, Pacientes.Paciente(fachada), null);

		tabbedPane.addTab("Gerencia", null, Gerencia.Gerenciaa(fachada), null);

		tabbedPane.addTab("Funcionarios", null, Funcionarios.Funcionarioss(fachada), null);

		JTabbedPane AlasEQuartos = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.addTab("Alas e Quartos", null, AlasEQuartos, null);

		JPanel StatusDaAla = new JPanel();
		AlasEQuartos.addTab("Status da Ala", null, StatusDaAla, null);
		SpringLayout sl_StatusDaAla = new SpringLayout();
		StatusDaAla.setLayout(sl_StatusDaAla);

		cmbAlas = new JComboBox<String>();
		sl_StatusDaAla.putConstraint(SpringLayout.NORTH, cmbAlas, 137, SpringLayout.NORTH, StatusDaAla);
		sl_StatusDaAla.putConstraint(SpringLayout.WEST, cmbAlas, 107, SpringLayout.WEST, StatusDaAla);
		cmbAlas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int index = cmbAlas.getSelectedIndex();
				if (index != -1) {
					getTxtQuartosEmUso()
							.setText(Integer.toString(fachada.getAlas().get(index).getNumeroQuartosEmUso()));
					getTxtQuartosVagos()
							.setText(Integer.toString(fachada.getAlas().get(index).getNumeroQuartosVagos()));
				}
			}
		});
		cmbAlas.setModel(new DefaultComboBoxModel<String>(new String[] { "Alas" }));
		StatusDaAla.add(cmbAlas);

		JLabel lblQuartosVagos = new JLabel("Quartos Vagos");
		sl_StatusDaAla.putConstraint(SpringLayout.NORTH, lblQuartosVagos, 52, SpringLayout.SOUTH, cmbAlas);
		sl_StatusDaAla.putConstraint(SpringLayout.EAST, lblQuartosVagos, 0, SpringLayout.EAST, cmbAlas);
		StatusDaAla.add(lblQuartosVagos);

		JLabel lblQuartosEmUso = new JLabel("Quartos Em Uso");
		sl_StatusDaAla.putConstraint(SpringLayout.NORTH, lblQuartosEmUso, 56, SpringLayout.SOUTH, lblQuartosVagos);
		sl_StatusDaAla.putConstraint(SpringLayout.EAST, lblQuartosEmUso, 0, SpringLayout.EAST, cmbAlas);
		StatusDaAla.add(lblQuartosEmUso);

		txtQuartosVagos = new JTextField();
		txtQuartosVagos.setEnabled(false);
		txtQuartosVagos.setEditable(false);
		txtQuartosVagos.setText("Quartos Vagos");
		sl_StatusDaAla.putConstraint(SpringLayout.WEST, txtQuartosVagos, 60, SpringLayout.EAST, lblQuartosVagos);
		sl_StatusDaAla.putConstraint(SpringLayout.SOUTH, txtQuartosVagos, 0, SpringLayout.SOUTH, lblQuartosVagos);
		StatusDaAla.add(txtQuartosVagos);
		txtQuartosVagos.setColumns(10);

		txtQuartosEmUso = new JTextField();
		txtQuartosEmUso.setEditable(false);
		txtQuartosEmUso.setEnabled(false);
		txtQuartosEmUso.setText("Quartos em Uso");
		sl_StatusDaAla.putConstraint(SpringLayout.NORTH, txtQuartosEmUso, 0, SpringLayout.NORTH, lblQuartosEmUso);
		sl_StatusDaAla.putConstraint(SpringLayout.EAST, txtQuartosEmUso, 0, SpringLayout.EAST, txtQuartosVagos);
		StatusDaAla.add(txtQuartosEmUso);
		txtQuartosEmUso.setColumns(10);

		JButton btnCarregarAlas = new JButton("Carregar Alas");
		btnCarregarAlas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmbAlas.removeAllItems();
				for (Ala ala : fachada.getAlas())
					getCmbAlas().addItem(ala.getNomeAla());
			}
		});
		sl_StatusDaAla.putConstraint(SpringLayout.WEST, btnCarregarAlas, 0, SpringLayout.WEST, lblQuartosEmUso);
		sl_StatusDaAla.putConstraint(SpringLayout.SOUTH, btnCarregarAlas, -50, SpringLayout.NORTH, cmbAlas);
		StatusDaAla.add(btnCarregarAlas);

		JPanel AlocarPaciente = new JPanel();
		AlasEQuartos.addTab("Alocar Paciente", null, AlocarPaciente, null);
		SpringLayout sl_AlocarPaciente = new SpringLayout();
		AlocarPaciente.setLayout(sl_AlocarPaciente);

		JLabel lblPaciente = new JLabel("Paciente");
		sl_AlocarPaciente.putConstraint(SpringLayout.NORTH, lblPaciente, 149, SpringLayout.NORTH, AlocarPaciente);
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, lblPaciente, 73, SpringLayout.WEST, AlocarPaciente);
		AlocarPaciente.add(lblPaciente);

		cmbPaciente = new JComboBox<String>();
		cmbPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmbPaciente.removeAllItems();
				for (Paciente pac : fachada.getListaPacientes())
					cmbPaciente.addItem(pac.getNome());
			}
		});
		cmbPaciente.setModel(new DefaultComboBoxModel<String>(new String[] { "Paciente" }));
		sl_AlocarPaciente.putConstraint(SpringLayout.NORTH, cmbPaciente, 0, SpringLayout.NORTH, lblPaciente);
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, cmbPaciente, 61, SpringLayout.EAST, lblPaciente);
		AlocarPaciente.add(cmbPaciente);

		cmbAlaAlocar = new JComboBox<String>();
		sl_AlocarPaciente.putConstraint(SpringLayout.NORTH, cmbAlaAlocar, 54, SpringLayout.SOUTH, cmbPaciente);
		cmbAlaAlocar.setModel(new DefaultComboBoxModel<String>(new String[] { "Ala" }));
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, cmbAlaAlocar, 0, SpringLayout.WEST, cmbPaciente);
		AlocarPaciente.add(cmbAlaAlocar);

		JLabel lblAla = new JLabel("Ala");
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, lblAla, 73, SpringLayout.WEST, AlocarPaciente);
		sl_AlocarPaciente.putConstraint(SpringLayout.SOUTH, lblAla, 0, SpringLayout.SOUTH, cmbAlaAlocar);
		AlocarPaciente.add(lblAla);

		JButton btnAlocarPacienteEm = new JButton("Alocar Paciente em um Quarto");
		btnAlocarPacienteEm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = getCmbAlaAlocar().getSelectedIndex();
				int indexPaciente = getCmbPaciente().getSelectedIndex();
				if (index != -1) {
					Quarto quarto = fachada.getAlas().get(index).ocuparQuarto();
					fachada.getListaPacientes().get(indexPaciente).setLastInternacao(null, null, null, quarto);
					getTxtQuartoDesignado().setText(Integer.toString(quarto.getNumeroQuarto()));
				}
			}
		});
		sl_AlocarPaciente.putConstraint(SpringLayout.NORTH, btnAlocarPacienteEm, 44, SpringLayout.SOUTH, cmbAlaAlocar);
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, btnAlocarPacienteEm, 73, SpringLayout.WEST, AlocarPaciente);
		AlocarPaciente.add(btnAlocarPacienteEm);

		txtQuartoDesignado = new JTextField();
		txtQuartoDesignado.setEditable(false);
		txtQuartoDesignado.setEnabled(false);
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, txtQuartoDesignado, 174, SpringLayout.EAST,
				btnAlocarPacienteEm);
		sl_AlocarPaciente.putConstraint(SpringLayout.SOUTH, txtQuartoDesignado, -97, SpringLayout.SOUTH,
				AlocarPaciente);
		sl_AlocarPaciente.putConstraint(SpringLayout.EAST, txtQuartoDesignado, 282, SpringLayout.EAST,
				btnAlocarPacienteEm);
		txtQuartoDesignado.setText("Quarto Designado");
		AlocarPaciente.add(txtQuartoDesignado);
		txtQuartoDesignado.setColumns(10);

		JLabel lblQuartoDesignado = new JLabel("Quarto Designado ->");
		sl_AlocarPaciente.putConstraint(SpringLayout.SOUTH, lblQuartoDesignado, 0, SpringLayout.SOUTH,
				btnAlocarPacienteEm);
		sl_AlocarPaciente.putConstraint(SpringLayout.EAST, lblQuartoDesignado, -38, SpringLayout.WEST,
				txtQuartoDesignado);
		AlocarPaciente.add(lblQuartoDesignado);

		JButton btnCarregarPacientesE = new JButton("Carregar Pacientes e Alas");
		btnCarregarPacientesE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getCmbPaciente().removeAllItems();
				getCmbAlaAlocar().removeAllItems();
				for (Paciente pac : fachada.getListaPacientes())
					getCmbPaciente().addItem(pac.getNome());
				for (Ala ala : fachada.getAlas())
					getCmbAlaAlocar().addItem(ala.getNomeAla());
			}
		});
		sl_AlocarPaciente.putConstraint(SpringLayout.WEST, btnCarregarPacientesE, 0, SpringLayout.WEST, lblPaciente);
		sl_AlocarPaciente.putConstraint(SpringLayout.SOUTH, btnCarregarPacientesE, -62, SpringLayout.NORTH,
				lblPaciente);
		AlocarPaciente.add(btnCarregarPacientesE);
	}
}
