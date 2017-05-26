package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.table.DefaultTableModel;

import interfaces.ILetra;
import modelo.JogoDePalavrasCruzadas;
import modelo.sorteio.SorteioDificil;
import modelo.sorteio.SorteioFacil;

import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ListSelectionModel;

public class JogoPalavras extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JComboBox comboBoxLetra;
	private JButton btnComecarJogoFacil;
	private JButton btnComecarJogoDificil;
	private JButton btnAdicionarLetra;
	private JButton btnEncerrarJogo;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private static JogoDePalavrasCruzadas jogo;
	private JComboBox comboBoxLinha;
	private JComboBox comboBoxColuna;
	private JTextPane txtpnPontos;
	private int dimensao = 7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoPalavras frame = new JogoPalavras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JogoPalavras() throws IOException {
		jogo = new JogoDePalavrasCruzadas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnComecarJogoFacil = new JButton("Comecar Jogo Facil");
		btnComecarJogoFacil.setAction(action);
		btnComecarJogoFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnComecarJogoFacil.setEnabled(false);
				btnComecarJogoDificil.setEnabled(false);
				btnAdicionarLetra.setEnabled(true);
				btnEncerrarJogo.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnComecarJogoFacil = new GridBagConstraints();
		gbc_btnComecarJogoFacil.fill = GridBagConstraints.BOTH;
		gbc_btnComecarJogoFacil.insets = new Insets(0, 0, 5, 0);
		gbc_btnComecarJogoFacil.gridx = 4;
		gbc_btnComecarJogoFacil.gridy = 0;
		contentPane.add(btnComecarJogoFacil, gbc_btnComecarJogoFacil);

		JLabel lblLetra = new JLabel("Letra");
		GridBagConstraints gbc_lblLetra = new GridBagConstraints();
		gbc_lblLetra.fill = GridBagConstraints.VERTICAL;
		gbc_lblLetra.insets = new Insets(0, 0, 5, 5);
		gbc_lblLetra.gridx = 1;
		gbc_lblLetra.gridy = 1;
		contentPane.add(lblLetra, gbc_lblLetra);

		JLabel lblLinha = new JLabel("Linha");
		GridBagConstraints gbc_lblLinha = new GridBagConstraints();
		gbc_lblLinha.fill = GridBagConstraints.VERTICAL;
		gbc_lblLinha.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinha.gridx = 2;
		gbc_lblLinha.gridy = 1;
		contentPane.add(lblLinha, gbc_lblLinha);

		JLabel lblColuna = new JLabel("Coluna");
		GridBagConstraints gbc_lblColuna = new GridBagConstraints();
		gbc_lblColuna.fill = GridBagConstraints.VERTICAL;
		gbc_lblColuna.insets = new Insets(0, 0, 5, 5);
		gbc_lblColuna.gridx = 3;
		gbc_lblColuna.gridy = 1;
		contentPane.add(lblColuna, gbc_lblColuna);

		btnComecarJogoDificil = new JButton("Comecar Jogo Dificil");
		btnComecarJogoDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnComecarJogoFacil.setEnabled(false);
				btnComecarJogoDificil.setEnabled(false);
				btnAdicionarLetra.setEnabled(true);
				btnEncerrarJogo.setEnabled(true);
			}
		});
		btnComecarJogoDificil.setAction(action_1);
		GridBagConstraints gbc_btnComecarJogoDificil = new GridBagConstraints();
		gbc_btnComecarJogoDificil.fill = GridBagConstraints.BOTH;
		gbc_btnComecarJogoDificil.insets = new Insets(0, 0, 5, 0);
		gbc_btnComecarJogoDificil.gridx = 4;
		gbc_btnComecarJogoDificil.gridy = 1;
		contentPane.add(btnComecarJogoDificil, gbc_btnComecarJogoDificil);

		comboBoxLetra = new JComboBox<Character>();
		GridBagConstraints gbc_comboBoxLetra = new GridBagConstraints();
		gbc_comboBoxLetra.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLetra.fill = GridBagConstraints.VERTICAL;
		gbc_comboBoxLetra.gridx = 1;
		gbc_comboBoxLetra.gridy = 2;
		contentPane.add(comboBoxLetra, gbc_comboBoxLetra);

		comboBoxLinha = new JComboBox<Integer>();
		comboBoxLinha.setModel(new DefaultComboBoxModel(new String[0]));
		for(int inicializaDimensao = 0; inicializaDimensao < dimensao; inicializaDimensao++)
			comboBoxLinha.addItem(Integer.toString(inicializaDimensao+1));;
		GridBagConstraints gbc_comboBoxLinha = new GridBagConstraints();
		gbc_comboBoxLinha.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLinha.fill = GridBagConstraints.VERTICAL;
		gbc_comboBoxLinha.gridx = 2;
		gbc_comboBoxLinha.gridy = 2;
		contentPane.add(comboBoxLinha, gbc_comboBoxLinha);

		comboBoxColuna = new JComboBox<Integer>();
		comboBoxColuna.setModel(new DefaultComboBoxModel(new String[0]));
		for(int inicializaDimensao = 0; inicializaDimensao < dimensao; inicializaDimensao++)
			comboBoxColuna.addItem(Integer.toString(inicializaDimensao+1));;
		GridBagConstraints gbc_comboBoxColuna = new GridBagConstraints();
		gbc_comboBoxColuna.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxColuna.fill = GridBagConstraints.VERTICAL;
		gbc_comboBoxColuna.gridx = 3;
		gbc_comboBoxColuna.gridy = 2;
		contentPane.add(comboBoxColuna, gbc_comboBoxColuna);

		btnAdicionarLetra = new JButton("Adicionar Letra");
		btnAdicionarLetra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAdicionarLetra.setEnabled(false);
		btnAdicionarLetra.setAction(action_2);
		GridBagConstraints gbc_btnAdicionarLetra = new GridBagConstraints();
		gbc_btnAdicionarLetra.fill = GridBagConstraints.BOTH;
		gbc_btnAdicionarLetra.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarLetra.gridx = 4;
		gbc_btnAdicionarLetra.gridy = 2;
		contentPane.add(btnAdicionarLetra, gbc_btnAdicionarLetra);

		JLabel lblPontuao = new JLabel("Pontua\u00E7\u00E3o =");
		GridBagConstraints gbc_lblPontuao = new GridBagConstraints();
		gbc_lblPontuao.insets = new Insets(0, 0, 5, 5);
		gbc_lblPontuao.gridx = 2;
		gbc_lblPontuao.gridy = 3;
		contentPane.add(lblPontuao, gbc_lblPontuao);

		txtpnPontos = new JTextPane();
		txtpnPontos.setBackground(Color.GREEN);
		txtpnPontos.setText("Pontos");
		txtpnPontos.setEditable(false);
		GridBagConstraints gbc_txtpnPontos = new GridBagConstraints();
		gbc_txtpnPontos.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnPontos.gridx = 3;
		gbc_txtpnPontos.gridy = 3;
		contentPane.add(txtpnPontos, gbc_txtpnPontos);

		btnEncerrarJogo = new JButton("Encerrar Jogo");
		btnEncerrarJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnComecarJogoFacil.setEnabled(true);
				btnComecarJogoDificil.setEnabled(true);
				btnAdicionarLetra.setEnabled(false);
				btnEncerrarJogo.setEnabled(false);
			}
		});
		btnEncerrarJogo.setEnabled(false);
		btnEncerrarJogo.setAction(action_3);
		GridBagConstraints gbc_btnEncerrarJogo = new GridBagConstraints();
		gbc_btnEncerrarJogo.fill = GridBagConstraints.BOTH;
		gbc_btnEncerrarJogo.insets = new Insets(0, 0, 5, 0);
		gbc_btnEncerrarJogo.gridx = 4;
		gbc_btnEncerrarJogo.gridy = 3;
		contentPane.add(btnEncerrarJogo, gbc_btnEncerrarJogo);

		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setBackground(Color.CYAN);
		table.setModel(new DefaultTableModel(
			new Object[dimensao][dimensao],
			new String[] {
				"Coluna 1", "Coluna 2", "Coluna 3", "Coluna 4", "Coluna 5", "Coluna 6", "Coluna 7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		contentPane.add(table, gbc_table);
	}

	public JTable getTable() {
		return table;
	}

	public JComboBox getComboBoxLetra() {
		return comboBoxLetra;
	}

	public JButton getBtnComecarJogoFacil() {
		return btnComecarJogoFacil;
	}

	public JButton getBtnComecarJogoDificil() {
		return btnComecarJogoDificil;
	}

	public JButton getBtnAdicionarLetra() {
		return btnAdicionarLetra;
	}

	public JButton getBtnEncerrarJogo() {
		return btnEncerrarJogo;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Comecar Jogo Facil");
			putValue(SHORT_DESCRIPTION, "Clique Aqui para dar Letras Faceis e Mais Pontos");
		}

		public void actionPerformed(ActionEvent e) {
			jogo.setLetrasDisponiveis(jogo.sorteioLetrasDisponiveis(new SorteioFacil().sorteioLetras()));
			inicializaLetras();
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Comecar Jogo Dificll");
			putValue(SHORT_DESCRIPTION, "Comecar Jogo com Letras mais dificeis e menos pontos");
		}

		public void actionPerformed(ActionEvent e) {
			jogo.setLetrasDisponiveis(jogo.sorteioLetrasDisponiveis(new SorteioDificil().sorteioLetras()));
			inicializaLetras();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Adicionar Letra");
			putValue(SHORT_DESCRIPTION, "Adiciona Letra a Posicao Desejada");
		}

		public void actionPerformed(ActionEvent e) {
			jogo.adicionaLetraNaPosicao(comboBoxLinha.getSelectedIndex(), comboBoxColuna.getSelectedIndex(),
					jogo.letrasDisponiveis().get(comboBoxLetra.getSelectedIndex()));
			jogo.letrasDisponiveis().remove(comboBoxLetra.getSelectedIndex());
			inicializaLetras();
			atualizaCelulas();
			jogo.terminou();
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Encerrar Jogo");
			putValue(SHORT_DESCRIPTION, "Encerra Jogo");
		}

		public void actionPerformed(ActionEvent e) {
			txtpnPontos.setText("" + jogo.pontuacao());
		}
	}

	private void atualizaCelulas() {
		for (int i = 0; i < jogo.retornaTabuleiro().numeroLinhas(); i++) {
			for (int j = 0; j < jogo.retornaTabuleiro().numeroColunas(); j++) {
				table.setValueAt(null, i, j);
				table.setValueAt(jogo.retornaTabuleiro().retornaLetraNaPosicao(i, j).getCaracter(), i, j);
			}
		}
	}

	private static void inicializaLetras() {
		List<ILetra> dicionario = jogo.letrasDisponiveis();
		comboBoxLetra.removeAllItems();
		for (ILetra dicio : dicionario)
			comboBoxLetra.addItem(dicio.getCaracter());
	}

	public JTextPane getTxtpnPontos() {
		return txtpnPontos;
	}
}
