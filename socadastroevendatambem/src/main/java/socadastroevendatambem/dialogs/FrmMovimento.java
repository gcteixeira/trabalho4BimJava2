package socadastroevendatambem.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.SwingWorker;

import socadastroevendatambem.persistencia.MovimentoDAO;
import socadastroevendatambem.persistencia.MovimentoProdutoDAO;
import socadastroevendatambem.modelo.Movimento;
import socadastroevendatambem.modelo.MovimentoProduto;
import socadastroevendatambem.modelo.Cliente;
import socadastroevendatambem.modelo.Produto;
import socadastroevendatambem.persistencia.ProdutoDAO;
import socadastroevendatambem.utils.Singleton;

import java.awt.Window.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FrmMovimento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCliente;
	private JTable tblProdutos;
	private JTextField txtSubtotal;
	private JTable table;
	private JTextField txtDesconto;
	private JTextField txtAcrescimo;
	private JTextField txtTotal;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JFormattedTextField txtDataVenda;
	private JButton btnPesquisaProduto;
	private JButton btnPesquisaCliente;

	Singleton s = Singleton.getInstance();
	Cliente p = new Cliente();

	Object value2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmMovimento dialog = new FrmMovimento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmMovimento() {
		setTitle("Só Cadastro - Movimento");
		MaskFormatter mascaradata = null;
		try {
			mascaradata = new MaskFormatter("##/##/####");
			mascaradata.setPlaceholderCharacter('_');
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 1074, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 9;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel.add(lblCliente, gbc_lblCliente);

		btnPesquisaCliente = new JButton("");

		GridBagConstraints gbc_btnPesquisaCliente = new GridBagConstraints();
		gbc_btnPesquisaCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisaCliente.gridx = 1;
		gbc_btnPesquisaCliente.gridy = 0;
		panel.add(btnPesquisaCliente, gbc_btnPesquisaCliente);
		btnPesquisaCliente.setIcon(new ImageIcon(FrmMovimento.class
				.getResource("/socadastroevendatambem/imagens/magnifier.png")));

		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.gridwidth = 2;
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.gridx = 2;
		gbc_txtCliente.gridy = 0;
		panel.add(txtCliente, gbc_txtCliente);
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);

		JLabel lblProdutos = new JLabel("Produtos");
		GridBagConstraints gbc_lblProdutos = new GridBagConstraints();
		gbc_lblProdutos.anchor = GridBagConstraints.NORTH;
		gbc_lblProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdutos.gridx = 0;
		gbc_lblProdutos.gridy = 1;
		panel.add(lblProdutos, gbc_lblProdutos);

		btnPesquisaProduto = new JButton("");
		btnPesquisaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		btnPesquisaProduto.setIcon(new ImageIcon(FrmMovimento.class
				.getResource("/socadastroevendatambem/imagens/magnifier.png")));
		GridBagConstraints gbc_btnPesquisaProduto = new GridBagConstraints();
		gbc_btnPesquisaProduto.anchor = GridBagConstraints.NORTH;
		gbc_btnPesquisaProduto.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisaProduto.gridx = 1;
		gbc_btnPesquisaProduto.gridy = 1;
//		panel.add(btnPesquisaProduto, gbc_btnPesquisaProduto);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
//		panel.add(scrollPane, gbc_scrollPane);

		tblProdutos = new JTable();
		tblProdutos.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {

				int linha = tblProdutos.getSelectedRow();
				if (linha != -1) {
					System.out.println("Linha " + linha);

					Object value = tblProdutos.getValueAt(1, 4);

					if (value != value2) {
						System.err.println(value + " " + value2);

						atualizaValores(linha, value);
						value2 = value;

					} else {
						return;
					}
				}
			

			}
		});
		scrollPane.setViewportView(tblProdutos);
//		tblProdutos.setModel(mt);

		JLabel lblNewLabel = new JLabel("Subtotal");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
//		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		GridBagConstraints gbc_txtSubtotal = new GridBagConstraints();
		gbc_txtSubtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubtotal.gridx = 4;
		gbc_txtSubtotal.gridy = 2;
//		panel.add(txtSubtotal, gbc_txtSubtotal);
		txtSubtotal.setColumns(10);

		JLabel lblDataDaOperao = new JLabel("Data da Opera\u00E7\u00E3o");
		GridBagConstraints gbc_lblDataDaOperao = new GridBagConstraints();
		gbc_lblDataDaOperao.anchor = GridBagConstraints.EAST;
		gbc_lblDataDaOperao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDaOperao.gridx = 0;
		gbc_lblDataDaOperao.gridy = 4;
		contentPanel.add(lblDataDaOperao, gbc_lblDataDaOperao);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridwidth = 7;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 5;
		contentPanel.add(scrollPane_1, gbc_scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);





		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 6;
		gbc_lblTotal.gridy = 6;
		contentPanel.add(lblTotal, gbc_lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.anchor = GridBagConstraints.NORTH;
		gbc_txtTotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 7;
		gbc_txtTotal.gridy = 6;
		contentPanel.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					Movimento m = new Movimento();

					m.setPessoa(p);

    				MovimentoDAO mdao = new MovimentoDAO();
					mdao.inserir(m);

					
					MovimentoProduto mp = new MovimentoProduto();
					mp.setMovimento(m);
					// mp.setTabela_detalhe();
					// mp.setQuantidade(quantidade);

					String valor_btr = txtSubtotal.getText();
					String desconto = txtDesconto.getText();
					String acrescimo = txtAcrescimo.getText();
					String valor_lqd = txtTotal.getText();
					valor_btr = valor_btr.replace(",", ".");
					desconto = desconto.replace(",", ".");
					acrescimo = acrescimo.replace(",", ".");
					valor_lqd = valor_lqd.replace(",", ".");

					mp.setValorund(Double.parseDouble(valor_btr));
					mp.setDesconto(Double.parseDouble(desconto));
					mp.setAcrescimo(Double.parseDouble(acrescimo));
					mp.setValor_liquido(Double.parseDouble(valor_lqd));

					MovimentoProdutoDAO mpdao = new MovimentoProdutoDAO();
	



					JOptionPane.showMessageDialog(null,
							"Movimento efetuado com sucesso");

					limparCampos();

					
					}
		});
		buttonPane.add(btnSalvar);

		btnCancelar = new JButton("Cancelar Venda");
		buttonPane.add(btnCancelar);

	}

	private void diminuiEstoque(Produto p, String quantidade) {
		int qtd = Integer.parseInt(quantidade);
		int qtdInicial = p.getQtdEstoque();
		p.setQtdEstoque(qtdInicial - qtd);
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(p);
	}

	private void almentaEstoque(Produto p, String quantidade) {
		int qtd = Integer.parseInt(quantidade);
		int qtdInicial = p.getQtdEstoque();
		p.setQtdEstoque(qtdInicial + qtd);
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(p);
	}

	protected void limparCampos() {

		txtCliente.setText("");
		txtTotal.setText("");
		txtSubtotal.setText("");

	}




	public void atualizaValores(int rowIndex, Object value) {


		String str = txtSubtotal.getText();


	}



	private double calculaParcela(int vezes) {

		double t = 0;

		String t2 = txtTotal.getText();
		t2 = t2.replace(".", "").replace(",", ".");

		t = Double.parseDouble(t2);

		return t / vezes;
	}

		}
	}
}




