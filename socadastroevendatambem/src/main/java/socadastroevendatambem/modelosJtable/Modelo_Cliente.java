package socadastroevendatambem.modelosJtable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.text.Caret;

import socadastroevendatambem.model.Cidade;
import socadastroevendatambem.model.Cliente;
import socadastroevendatambem.model.Estado;
import socadastroevendatambem.model.Genero;
import socadastroevendatambem.persistencia.ClienteDAO;
import socadastroevendatambem.utils.Singleton;

public class Modelo_Cliente extends AbstractTableModel {

	private List<Cliente> clientes = new ArrayList<>();
	
	Singleton s = Singleton.getInstance();
 
	private List<Cliente> carregarLista() {

		List<Cliente> clientes = new ArrayList<>();
		
		for (int i = 0; i < s.clientes.size(); i++) {
			clientes.add(s.clientes.get(i));
		

		}
		return clientes;
	}


	public void setPessoas(List<Cliente> cliente) {
		this.clientes = cliente;
	}
	
	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		clientes = carregarLista();
		return clientes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
		case 0:
			return clientes.get(rowIndex).getId();
		case 1:
			return clientes.get(rowIndex).getNome();
		case 2:
			return clientes.get(rowIndex).getEndereco();
		case 3:
			return clientes.get(rowIndex).getCidade();
		case 4:
			return clientes.get(rowIndex).getEstado();
		case 5:
			return clientes.get(rowIndex).getTelefone();
		case 6:
			return clientes.get(rowIndex).getEmail();
		case 7:
			return clientes.get(rowIndex).getGerero();
		default:
			return "ERRO";
		}
	}

	@Override
	public String getColumnName(int i) {
		switch (i) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Endereço";
		case 3:
			return "Cidade";
		case 4:
			return "Estado";
		case 5:
			return "Telefone";
		case 6:
			return "E-mail";
		case 7:
			return "Genero";
		default:
			return "ERRO";
		}
	}

	public Cliente getSelectedObject(int row) {
		return clientes.get(row);
	}

}
