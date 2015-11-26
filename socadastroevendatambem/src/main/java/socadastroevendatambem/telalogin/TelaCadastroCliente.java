package socadastroevendatambem.telalogin;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import socadastroevendatambem.dialogs.CadCliente;

public class TelaCadastroCliente extends MolduraAbstrata {

	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new TelaCadastroCliente(), BorderLayout.CENTER);
	}

}
