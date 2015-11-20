package socadastroevendatambem.swing.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		
		JMenu mnPessoa = new JMenu("Pessoa");
		mnCadastros.add(mnPessoa);
		
		JMenuItem mntmPessoaFsica = new JMenuItem("Pessoa F\u00EDsica");
		mntmPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadCliente cpf = new CadCliente();
				cpf.setVisible(true);
				
			}
		});
		mnPessoa.add(mntmPessoaFsica);
		

	
		JMenuItem mntmProduto = new JMenuItem("Produto");
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
	
		
		JMenu mnEndereo = new JMenu("Endere\u00E7o");
		mnCadastros.add(mnEndereo);
		
		JMenuItem mntmCidade = new JMenuItem("Cidade");
		mntmCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadCidade cc = new CadCidade();
				cc.setVisible(true);
				
			}
		});
		mnEndereo.add(mntmCidade);
		
		JMenuItem mntmEstado = new JMenuItem("Estado");
		mntmEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadEstado ce = new CadEstado();
				ce.setVisible(true);
				
			}
		});
		mnEndereo.add(mntmEstado);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pais");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadPais cp = new CadPais();
				cp.setVisible(true);
				
			}
		});
		mnEndereo.add(mntmNewMenuItem);
		
		JMenu mnMovimento = new JMenu("Venda");
		menuBar.add(mnMovimento);
		
		JMenuItem mntmPedido = new JMenuItem("Pedido");
		mntmPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmMovimento m = new FrmMovimento();
				m.setVisible(true);
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
				MinhaAplicacao.get().getTelaPrincipal().showLogin();
			}
		});
		mnConfiguraes.add(mntmsair);

	}
}
