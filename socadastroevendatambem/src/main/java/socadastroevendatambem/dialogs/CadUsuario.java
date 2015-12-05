package socadastroevendatambem.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import socadastroevendatambem.modelo.Produto;
import socadastroevendatambem.modelosJtable.Modelo_Produto;
import socadastroevendatambem.persistencia.ProdutoDAO;
import socadastroevendatambem.swing.paineis.TelaAba;
import socadastroevendatambem.utils.Singleton;
import javax.swing.JRadioButton;

public class CadUsuario extends JPanel {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtSenha;
	private JTextField txtCliente;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadProduto dialog = new CadProduto();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	Modelo_Produto mp = new Modelo_Produto();

	Produto p = new Produto();
	Singleton s = Singleton.getInstance();

	private ImageIcon imgAlert = new ImageIcon(getClass().getResource("/socadastroevendatambem/imagens/error.png"));
	private JTextField txtQuantidade;
	private TelaAba telaAba;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	public CadUsuario(TelaAba telaAba) {
		this.telaAba = telaAba;

		setPreferredSize(new Dimension(1000, 400));
		//this.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[] { 0, 63, 0, 0, 64, 60, 0, 0 };
		gbl_this.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_this.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_this.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_this);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		this.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 4;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.anchor = GridBagConstraints.NORTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		this.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Produto p = new Produto();

					p.setDescricao(txtNome.getText());

					p.setQtdEstoque(Integer.parseInt(txtQuantidade.getText()));

					ProdutoDAO dao = new ProdutoDAO();
					dao.inserir(p);
					mp.fireTableDataChanged();

					limparCampos();

					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");

				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});

		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 5;
		gbc_lblQuantidade.gridy = 0;
		this.add(lblQuantidade, gbc_lblQuantidade);

		txtQuantidade = new JTextField();
		GridBagConstraints gbc_txtQuantidade = new GridBagConstraints();
		gbc_txtQuantidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtQuantidade.gridx = 6;
		gbc_txtQuantidade.gridy = 0;
		this.add(txtQuantidade, gbc_txtQuantidade);
		txtQuantidade.setColumns(10);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.gridx = 6;
		gbc_btnSalvar.gridy = 1;
		this.add(btnSalvar, gbc_btnSalvar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();

				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 5;
		this.add(btnNovo, gbc_btnNovo);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Runnable r = new Runnable() {

					@Override
					public void run() {

						s.statusBotao = false;

						BuscaProduto bp = new BuscaProduto();
						bp.setVisible(true);

						while (bp.isShowing()) {

						}

						txtNome.setText(s.produto.getDescricao());

						txtQuantidade.setText(Integer.toString(s.produto.getQtdEstoque()));

						p = s.produto;
						String nome = txtNome.getText();
						int estoque = Integer.parseInt(txtQuantidade.getText());

					}
				};

				Thread t = new Thread(r);
				t.start();

			}
		});
		GridBagConstraints gbc_btnListar = new GridBagConstraints();
		gbc_btnListar.insets = new Insets(0, 0, 0, 5);
		gbc_btnListar.gridx = 3;
		gbc_btnListar.gridy = 5;
		this.add(btnListar, gbc_btnListar);

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 5;
		this.add(btnExcluir, gbc_btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(null, "Deseja excluir o produto " + p.getDescricao() + "?",
						"Deseja realizar essa opera��o?", dialogButton);

				if (result == JOptionPane.YES_OPTION) {

					ProdutoDAO dao = new ProdutoDAO();
					if (dao.deletar(p.getId()) == "NO") {
						JOptionPane.showMessageDialog(null, "N�o foi possivel excluir esse produto",
								"Problemas ao Excluir", 1, imgAlert);
					} else {
						JOptionPane.showMessageDialog(null, "Exclus�o feita com sucesso");
						limparCampos();

						btnSalvar.setEnabled(true);
						btnEditar.setEnabled(false);
						btnExcluir.setEnabled(false);
					}

				}

			}
		});
		btnExcluir.setEnabled(false);

		btnEditar = new JButton("Editar");
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 5;
		gbc_btnEditar.gridy = 5;
		this.add(btnEditar, gbc_btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					p.setDescricao(txtNome.getText());

					p.setQtdEstoque(Integer.parseInt(txtQuantidade.getText()));

					ProdutoDAO dao = new ProdutoDAO();
					dao.alterar(p);

					mp.fireTableDataChanged();

					JOptionPane.showMessageDialog(null, "Altera��o Feita com Sucesso");

					limparCampos();

					btnSalvar.setEnabled(true);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);

				} catch (Exception ex) {
					// TODO: handle exception
				}

			}
		});
		btnEditar.setEnabled(false);

		JButton cancelButton = new JButton("Cancelar");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 5;
		this.add(cancelButton, gbc_cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	CadProduto.this.dispose();
			}
		});

	}

	public CadUsuario() {

		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 63, 0, 0, 64, 60, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel label_1 = new JLabel("Usuario");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		
		JLabel label = new JLabel("Usuario");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		this.add(textField_1, gbc_textField_1);
		
		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 3;
		this.add(lblSenha, gbc_lblSenha);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		this.add(textField_2, gbc_textField_2);
		
		JButton button_1 = new JButton("Salvar");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 6;
		gbc_button_1.gridy = 3;
		this.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("Novo");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 5;
		this.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("Listar");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 5;
		this.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("Excluir");
		button_4.setEnabled(false);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 5;
		this.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("Editar");
		button_5.setEnabled(false);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 0, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 5;
		this.add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("Cancelar");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.gridx = 6;
		gbc_button_6.gridy = 5;
		this.add(button_6, gbc_button_6);
		// TODO Auto-generated constructor stub
	}

	private void limparCampos() {
		txtNome.setText("");
		txtQuantidade.setText("");
	}

}
