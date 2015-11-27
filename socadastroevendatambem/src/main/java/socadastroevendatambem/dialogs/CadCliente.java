package socadastroevendatambem.dialogs;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import socadastroevendatambem.modelo.Cidade;
import socadastroevendatambem.modelo.Cliente;
import socadastroevendatambem.modelosJtable.Modelo_Cliente;
import socadastroevendatambem.persistencia.ClienteDAO;
import socadastroevendatambem.swing.paineis.TelaAba;
import socadastroevendatambem.utils.Singleton;

public class CadCliente extends JPanel {

	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtTelefone;
	private JButton btnNewButton;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadCliente dialog = new CadCliente();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private ImageIcon imgAlert = new ImageIcon(getClass().getResource(
			"/socadastroevendatambem/imagens/error.png"));
	Modelo_Cliente mc = new Modelo_Cliente();
	Singleton s = Singleton.getInstance();
	Cliente p = new Cliente();
	Cidade c = new Cidade();
	private JButton ButtonEstado;
	private JLabel lblEstado;
	private JTextField textEstado;
	private JLabel lblGenero;
	private JButton buttonGenero;
	private JTextField textGenero;
	private TelaAba telaAba;

	public CadCliente(TelaAba telaAba) {
		this.telaAba = telaAba;

		MaskFormatter mascaracpf = null;
		MaskFormatter mascararg = null;
		MaskFormatter mascaradata = null;
		MaskFormatter mascarafone = null;

		try {
			mascaracpf = new MaskFormatter("###.###.###-##");
			mascararg = new MaskFormatter("##.###.###-#");
			mascaradata = new MaskFormatter("##/##/####");
			mascarafone = new MaskFormatter("(##)####-####");
			mascaracpf.setPlaceholderCharacter('_');
			mascararg.setPlaceholderCharacter('_');
			mascaradata.setPlaceholderCharacter('_');
			mascarafone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}


		setPreferredSize(new Dimension(1000, 400));
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[] { 45, 164, 35, 0, 120, 55,
				116, 0 };
		gbl_this.rowHeights = new int[] { 20, 29, 20, 23, 35, 14, 0, 0 };
		gbl_this.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_this.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_this);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		this.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 2;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		this.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 3;
		gbc_lblGenero.gridy = 0;
		this.add(lblGenero, gbc_lblGenero);
		
		textGenero = new JTextField();
		textGenero.setEditable(false);
		textGenero.setColumns(10);
		GridBagConstraints gbc_textGenero = new GridBagConstraints();
		gbc_textGenero.insets = new Insets(0, 0, 5, 5);
		gbc_textGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGenero.gridx = 4;
		gbc_textGenero.gridy = 0;
		this.add(textGenero, gbc_textGenero);
		
		buttonGenero = new JButton("");
		buttonGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGenero.setIcon(new ImageIcon(CadCliente.class.getResource("/socadastroevendatambem/imagens/magnifier.png")));
		GridBagConstraints gbc_buttonGenero = new GridBagConstraints();
		gbc_buttonGenero.insets = new Insets(0, 0, 5, 5);
		gbc_buttonGenero.gridx = 5;
		gbc_buttonGenero.gridy = 0;
		this.add(buttonGenero, gbc_buttonGenero);

		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 1;
		this.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 1;
		this.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 5;
		gbc_lblTelefone.gridy = 1;
		this.add(lblTelefone, gbc_lblTelefone);

		txtTelefone = new JFormattedTextField(mascarafone);
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefone.gridx = 6;
		gbc_txtTelefone.gridy = 1;
		this.add(txtTelefone, gbc_txtTelefone);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 2;
		this.add(lblEndereo, gbc_lblEndereo);

		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.gridwidth = 4;
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 2;
		this.add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.EAST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 0;
		gbc_lblBairro.gridy = 3;
		this.add(lblBairro, gbc_lblBairro);

		txtBairro = new JTextField();
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 5);
		gbc_txtBairro.gridx = 1;
		gbc_txtBairro.gridy = 3;
		this.add(txtBairro, gbc_txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 2;
		gbc_lblCidade.gridy = 3;
		this.add(lblCidade, gbc_lblCidade);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					@Override
					public void run() {
						s.statusBotao = true;
						BuscaCidade bc = new BuscaCidade();
						bc.setVisible(true);

						while (bc.isShowing()) {

						}

						txtCidade.setText(s.cidade.getNome());
						c = s.cidade;

					}
				};

				Thread t = new Thread(r);
				t.start();

			}
		});
		btnNewButton.setIcon(new ImageIcon(CadCliente.class
				.getResource("/socadastroevendatambem/imagens/magnifier.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		this.add(btnNewButton, gbc_btnNewButton);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridx = 4;
		gbc_txtCidade.gridy = 3;
		this.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);

		btnSalvar = new JButton("Salvar");

		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 2;
		gbc_lblEstado.gridy = 4;
		this.add(lblEstado, gbc_lblEstado);
		
		ButtonEstado = new JButton("");
		ButtonEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonEstado.setIcon(new ImageIcon(CadCliente.class.getResource("/socadastroevendatambem/imagens/magnifier.png")));
		GridBagConstraints gbc_ButtonEstado = new GridBagConstraints();
		gbc_ButtonEstado.insets = new Insets(0, 0, 5, 5);
		gbc_ButtonEstado.gridx = 3;
		gbc_ButtonEstado.gridy = 4;
		this.add(ButtonEstado, gbc_ButtonEstado);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setColumns(10);
		GridBagConstraints gbc_textEstado = new GridBagConstraints();
		gbc_textEstado.insets = new Insets(0, 0, 5, 5);
		gbc_textEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEstado.gridx = 4;
		gbc_textEstado.gridy = 4;
		this.add(textEstado, gbc_textEstado);
		btnSalvar.setIcon(new ImageIcon(CadCliente.class
				.getResource("/socadastroevendatambem/imagens/Salvar.png")));
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.BOTH;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.gridx = 6;
		gbc_btnSalvar.gridy = 4;
		this.add(btnSalvar, gbc_btnSalvar);

		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();

				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 6;
		this.add(btnNewButton_1, gbc_btnNewButton_1);

		JPanel buttonPane = new JPanel();
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonPane.gridwidth = 6;
		gbc_buttonPane.gridx = 1;
		gbc_buttonPane.gridy = 6;
		this.add(buttonPane, gbc_buttonPane);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[] { 135, 89, 291, 61, 63, 75, 0 };
		gbl_buttonPane.rowHeights = new int[] { 23, 0 };
		gbl_buttonPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_buttonPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPane.setLayout(gbl_buttonPane);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Runnable r = new Runnable() {

					@Override
					public void run() {

						s.statusBotao = false;

						BuscaPessoa bc = new BuscaPessoa();
						bc.setVisible(true);

						while (bc.isShowing()) {

						}
						p = s.p;
				
							txtNome.setText(p.getNome());
							txtEndereco.setText(p.getEndereco());
							txtCidade.setText(p.getCidade().getNome());
							c = s.p.getCidade();

							String nome = txtNome.getText();
							String endereco = txtEndereco.getText();
							String cidade = txtCidade.getText();
							String telefone = txtTelefone.getText();

							if (!nome.equals("") || !endereco.equals("")) {

								btnSalvar.setEnabled(false);
								btnEditar.setEnabled(true);
								btnExcluir.setEnabled(true);
							}

						}

					

				};

				Thread t = new Thread(r);
				t.start();

			}
		});
		GridBagConstraints gbc_btnListar = new GridBagConstraints();
		gbc_btnListar.anchor = GridBagConstraints.EAST;
		gbc_btnListar.insets = new Insets(0, 0, 0, 5);
		gbc_btnListar.gridx = 2;
		gbc_btnListar.gridy = 0;
		buttonPane.add(btnListar, gbc_btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					p.setNome(txtNome.getText());
					p.setEndereco(txtEndereco.getText());
					p.setCidade(c);

					if (verificaCamposNulos() == "OK") {
						ClienteDAO dao = new ClienteDAO();
						dao.alterar(p);

						JOptionPane.showMessageDialog(null,
								"Altera��o feita com sucesso");

						limparCampos();

						btnSalvar.setEnabled(true);
						btnEditar.setEnabled(false);
						btnExcluir.setEnabled(false);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao alterar");
				}

			}
		});
		btnEditar.setEnabled(false);
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 0;
		buttonPane.add(btnEditar, gbc_btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(null,
						"Deseja excluir a pessoa " + p.getNome() + "?",
						"Deseja realizar essa opera��o?", dialogButton);

				if (result == JOptionPane.YES_OPTION) {
					ClienteDAO dao = new ClienteDAO();
					if (dao.deletar(p.getId()) == "NO") {
						JOptionPane.showMessageDialog(null,
								"N�o foi possivel excluir essa Pessoa",
								"Problemas ao Excluir", 1, imgAlert);
						return;
					} else {

						JOptionPane.showMessageDialog(null,
								"Exclusao feita com sucesso");

						limparCampos();

						btnSalvar.setEnabled(true);
						btnEditar.setEnabled(false);
						btnExcluir.setEnabled(false);

					}

				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(CadCliente.class
				.getResource("/socadastroevendatambem/imagens/table_row_delete.png")));
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.BOTH;
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 0;
		buttonPane.add(btnExcluir, gbc_btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CadCliente.this.telaAba.getTabbedPane().remove(CadCliente.);
			}
		});
		btnCancelar.setIcon(new ImageIcon(CadCliente.class
				.getResource("/socadastroevendatambem/imagens/cancel.png")));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 0;
		buttonPane.add(btnCancelar, gbc_btnCancelar);

	}

	public CadCliente() {
		// TODO Auto-generated constructor stub
	}

	protected void limparCampos() {
		txtEmail.setText("");
		txtCidade.setText("");
		txtEndereco.setText("");
		txtNome.setText("");
		txtTelefone.setText("");

	}

	public String verificaCamposNulos() {

		String nome = txtNome.getText();
		String endereco = txtEndereco.getText();
		String bairro = txtBairro.getText();
		String cidade = txtCidade.getText();
		String telefone = txtTelefone.getText();


		if (nome.equals("") && endereco.equals("") && bairro.equals("")
				&& cidade.equals("") && telefone.equals("")
				) {

			JOptionPane
					.showMessageDialog(
							null,
							"Os campos nome, endere�o, bairro, cidade e telefone",
							"Campos Nulos", 1, imgAlert);
			return "NO";
		}

		if (nome.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo nome deve conter um valor",
					"Campo n�o pode ser nulo", 1, imgAlert);
			txtNome.grabFocus();
			return "NO";
		}
		if (endereco.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo endere�o deve conter um valor",
					"Campo n�o pode ser nulo", 1, imgAlert);
			txtEndereco.grabFocus();
			return "NO";
		}
		if (bairro.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo bairro deve conter um valor",
					"Campo n�o pode ser nulo", 1, imgAlert);
			txtBairro.grabFocus();
			return "NO";
		}
		if (cidade.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Selecione uma cidade clicando no bot�o com a lupa",
					"Campo n�o pode ser nulo", 1, imgAlert);
			btnNewButton.grabFocus();
			return "NO";
		}
		if (telefone.equals("")) {
			JOptionPane.showMessageDialog(null,
					"O campo telefone deve conter um valor",
					"Campo n�o pode ser nulo", 1, imgAlert);
			txtTelefone.grabFocus();
			return "NO";
		}

		return "OK";
	}
	
	
	

	
	// private void carregaDados() {
	// PessoaDAO dao = new PessoaDAO();
	// mpf.setPessoas(dao.listar());
	// }

}
