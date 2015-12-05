package socadastroevendatambem.swing.paineis;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import socadastroevendatambem.dialogs.CadCliente;
import socadastroevendatambem.dialogs.CadProduto;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaAba extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private static int maxW = 0;
	private static int maxH = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAba frame = new TelaAba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTeste = new JMenu("Cadastro");
		menuBar.add(mnTeste);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionaUm();
			}
		});
		mnTeste.add(mntmCliente);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionaProduto();
			}
		});
		mnTeste.add(mntmProduto);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mnVenda.add(mntmNovaVenda);
		
		JMenuItem menuItem_1 = new JMenuItem("Produto");
		mnVenda.add(menuItem_1);
		
				final JButton btnNewButton_TesteMoroto = new JButton("Teste Botao");
				menuBar.add(btnNewButton_TesteMoroto);
				btnNewButton_TesteMoroto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tabbedPane.remove(tabbedPane.getComponent(tabbedPane.getSelectedIndex()));
					}
				});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 146, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.gridwidth = 4;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Component mCompo = tabbedPane.getSelectedComponent();
				if (mCompo != null) {
					tabbedPane.setPreferredSize(mCompo.getPreferredSize());
				}
				TelaAba.this.pack();
			}

		});

		contentPane.add(tabbedPane, gbc_tabbedPane);
	}

	protected void adicionaUm() {
		CadCliente cadCliente = new CadCliente(this);
		tabbedPane.addTab("Cliente", cadCliente);
		tabbedPane.setSize(cadCliente.getSize());
		mostraUltima();
	}

	protected void adicionaProduto() {
		CadProduto cadProduto = new CadProduto(this);
		tabbedPane.addTab("Produto", cadProduto);
		tabbedPane.setSize(cadProduto.getSize());
		mostraUltima();
	}

	private String ABA_DOIS = "Jessica";

	private String ABA_TRES = "TRES";

	private Map<Integer, JComponent> mapa = new HashMap<Integer, JComponent>();

	private void mostraUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setCloseAction(ActionListener action) {
		// TODO Auto-generated method stub

	}

}
