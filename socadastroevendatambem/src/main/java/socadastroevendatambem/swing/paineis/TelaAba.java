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
		mnTeste.add(mntmCliente);
		
		JMenuItem mntmTeste_1 = new JMenuItem("teste2");
		menuBar.add(mntmTeste_1);
		
		JMenuItem mntmTeste = new JMenuItem("Teste");
		menuBar.add(mntmTeste);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 146, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnNewButton = new JButton("Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				adicionaUm();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaDois();
			}
		});
		
		final JButton btnNewButton_TesteMoroto = new JButton("Teste Botao");
		GridBagConstraints gbc_btnNewButton_TesteMoroto = new GridBagConstraints();
		gbc_btnNewButton_TesteMoroto.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_TesteMoroto.gridx = 1;
		gbc_btnNewButton_TesteMoroto.gridy = 0;
		contentPane.add(btnNewButton_TesteMoroto, gbc_btnNewButton_TesteMoroto);
		btnNewButton_TesteMoroto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getComponent(tabbedPane.getSelectedIndex()));
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 4;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		
		tabbedPane.addChangeListener(new ChangeListener() {

	            @Override
	            public void stateChanged(ChangeEvent e) {
	            	 Component mCompo=tabbedPane.getSelectedComponent();
	            	 if(mCompo!=null){
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

	//public void actionPerformed(ActionEvent e) {

//		CadCliente cl = new CadCliente();
//		cl.setVisible(true);
		mostraUltima();

	}
	
	
	private String ABA_DOIS = "Jessica";

	private String ABA_TRES = "TRES";

	protected void adicionaDois() {

		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA_DOIS)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		JPanel telaDois = new JPanel();

		tabbedPane.addTab(ABA_DOIS, telaDois);
		mostraUltima();
	}

	private Map<Integer, JComponent> mapa = new HashMap<Integer, JComponent>();

	private void mostraUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

}
