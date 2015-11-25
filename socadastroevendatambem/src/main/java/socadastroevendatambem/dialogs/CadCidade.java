package socadastroevendatambem.dialogs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import socadastroevendatambem.modelo.Cidade;
import socadastroevendatambem.modelosJtable.Modelo_Cidade;
import socadastroevendatambem.persistencia.CidadeDAO;
import socadastroevendatambem.utils.Singleton;

public class CadCidade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadCidade dialog = new CadCidade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	Modelo_Cidade mc = new Modelo_Cidade();

	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnExcluir;
	Singleton s = Singleton.getInstance();
	private JButton btnNovo;
	private JButton btnListar;
	Cidade c = new Cidade();

	private ImageIcon imgAlert = new ImageIcon(getClass().getResource(
			"/socadastroevendatambem/imagens/error.png"));

	
	public CadCidade() {

		carregaDados();

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Só Cadastro - Cadastro de Cidade");
		setModal(true);
		setBounds(100, 100, 599, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		contentPanel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 5;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		contentPanel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Cidade cidade = new Cidade();
					cidade.setNome(txtNome.getText());

					CidadeDAO dao = new CidadeDAO();
					dao.inserir(cidade);

					mc.fireTableDataChanged();

					limparCampos();
					JOptionPane.showMessageDialog(null,
							"Cidade cadastrada com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Erro ao cadastrar Cidade");
				}

			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.gridx = 6;
		gbc_btnSalvar.gridy = 1;
		contentPanel.add(btnSalvar, gbc_btnSalvar);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();

				btnSalvar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 3;
		contentPanel.add(btnNovo, gbc_btnNovo);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Runnable r = new Runnable() {

					@Override
					public void run() {

						s.statusBotao = false;

						BuscaCidade bc = new BuscaCidade();
						bc.setVisible(true);

						while (bc.isShowing()) {

						}

						
						String nome = txtNome.getText();

					

					}
				};

				Thread t = new Thread(r);
				t.start();

				
			}
		});
		GridBagConstraints gbc_btnListar = new GridBagConstraints();
		gbc_btnListar.insets = new Insets(0, 0, 0, 5);
		gbc_btnListar.gridx = 3;
		gbc_btnListar.gridy = 3;
		contentPanel.add(btnListar, gbc_btnListar);

		btnEditar = new JButton("Editar");
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 4;
		gbc_btnEditar.gridy = 3;
		contentPanel.add(btnEditar, gbc_btnEditar);
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					c.setNome(txtNome.getText());


					CidadeDAO dao = new CidadeDAO();
					dao.alterar(c);

					mc.fireTableDataChanged();

					JOptionPane.showMessageDialog(null,
							"Altera��o Feita com Sucesso");

					limparCampos();

					btnSalvar.setEnabled(true);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Erro ao alterar cidade");
				}

			}
		});

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 5;
		gbc_btnExcluir.gridy = 3;
		contentPanel.add(btnExcluir, gbc_btnExcluir);
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int dialogButton = JOptionPane.YES_NO_OPTION;
					int result = JOptionPane.showConfirmDialog(null,
							"Deseja excluir a cidade " + c.getNome() + "?",
							"Deseja realizar essa opera��o?", dialogButton);

					if (result == JOptionPane.YES_OPTION) {

						CidadeDAO dao = new CidadeDAO();
						if (dao.deletar(c.getId()) == "NO") {
							JOptionPane.showMessageDialog(null,
									"N�o foi possivel excluir essa cidade",
									"Problemas ao Excluir", 1, imgAlert);
							return;
						} else {

							limparCampos();

							JOptionPane.showMessageDialog(null,
									"Exclus�o feita com sucesso");

							btnSalvar.setEnabled(true);
							btnEditar.setEnabled(false);
							btnExcluir.setEnabled(false);
						}

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Problemas ao excluir cidade");
				}

			}
		});

		JButton cancelButton = new JButton("Cancelar");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 3;
		contentPanel.add(cancelButton, gbc_cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadCidade.this.dispose();
			}
		});

	}

	private void carregaDados() {
		CidadeDAO dao = new CidadeDAO();
		mc.setCidades(dao.listar());
	}

	private void limparCampos() {
		txtNome.setText("");

	}

}
