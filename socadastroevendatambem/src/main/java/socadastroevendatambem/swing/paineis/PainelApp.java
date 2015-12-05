package socadastroevendatambem.swing.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import socadastroevendatambem.dialogs.CadCategoria;
import socadastroevendatambem.dialogs.CadCidade;
import socadastroevendatambem.dialogs.CadEstado;
import socadastroevendatambem.dialogs.CadPais;
import socadastroevendatambem.dialogs.CadProduto;
import socadastroevendatambem.dialogs.CadCliente;
import socadastroevendatambem.utils.MinhaAplicacao;
import javax.swing.JButton;

public class PainelApp extends JPanel {

/**
	 * Create the panel.
	 */
//	private ImageIcon imgCheck = new ImageIcon(getClass().getResource("/logo.png"));
	private JTabbedPane tabbedPane;
	public PainelApp() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{21, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JMenuBar menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.anchor = GridBagConstraints.NORTH;
		gbc_menuBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(menuBar, gbc_menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		

	
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadProduto cp = new CadProduto();
				cp.setVisible(true);
			}
		});
		tabbedPane.addTab("Teste", new JPanel());
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadProduto cp = new CadProduto();
				cp.setVisible(true);
			}
		});
		
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadCategoria cc = new CadCategoria();
				cc.setVisible(true);
			}
		});
		mnCadastros.add(mntmCategoria);
		
		JMenu mnMovimento = new JMenu("Venda");
		menuBar.add(mnMovimento);
		
		JMenuItem mntmPedido = new JMenuItem("Pedido");
		mntmPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
//				FrmMovimento m = new FrmMovimento();
//				m.setVisible(true);
			}
		});

		
		
		JMenu mnRelatorios = new JMenu("Relatorios");
		menuBar.add(mnRelatorios);
		
		
		JMenuItem mntmRelatorioCategoria = new JMenuItem("Relatorio de Categoria");
		mnRelatorios.add(mntmRelatorioCategoria);
		
		
		JMenuItem mntmRelatorioDeMunicipio = new JMenuItem("Relatorio de Municipio, Estado e Pais");
		mnRelatorios.add(mntmRelatorioDeMunicipio);
		
		JMenuItem mntmRelatorioDeMovimento = new JMenuItem("Relatorio de Movimento");
		mnRelatorios.add(mntmRelatorioDeMovimento);
		
		JMenuItem mntmRelatorioDePessoa = new JMenuItem("Relatorio de Pessoa");
		mnRelatorios.add(mntmRelatorioDePessoa);
		
		JMenuItem mntmRelatorioDeProduto = new JMenuItem("Relatorio de Produto");
		mnRelatorios.add(mntmRelatorioDeProduto);
		
		JMenuItem mntmRelatorioDeEstoque = new JMenuItem("Relatorio de Estoque");
		mnRelatorios.add(mntmRelatorioDeEstoque);
		
		JMenuItem mntmRelatorioDePessoaJuridica = new JMenuItem("Relatorio de Pessoa Juridica");
		mnRelatorios.add(mntmRelatorioDePessoaJuridica);
		
		JMenuItem mntmRelatorioDePessoaFisica = new JMenuItem("Relatorio de Pessoa Fisica");
		mnRelatorios.add(mntmRelatorioDePessoaFisica);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenuItem mntmsair = new JMenuItem("Sair");
		mntmsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MinhaAplicacao.get().getTelaAba().showLogin();
			}
		});
		mnConfiguraes.add(mntmsair);

	}
	protected void adicionaUm() {
		tabbedPane.addTab("1", new JPanel());
		mostraUltima();
	}
	
	private void mostraUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}
}
