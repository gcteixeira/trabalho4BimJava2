package socadastroevendatambem.modelosJtable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.text.Caret;

import socadastroevendatambem.modelo.Cliente;
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


	public void setPessoas(List<Cliente> pessoas) {
		this.clientes = pessoas;
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
			return clientes.get(rowIndex).getEndereco() + ", "
			+ clientes.get(rowIndex).getNumero();
		case 3:
			return clientes.get(rowIndex).getCidade();
		case 4:
			return clientes.get(rowIndex).getTelefone();
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
			return "Telefone";
		default:
			return "ERRO";
		}
	}

	public Cliente getSelectedObject(int row) {
		return clientes.get(row);
	}

	public String retornaDate(Date data) {
		try {
			SimpleDateFormat formatOut = new SimpleDateFormat("dd/MM/yyyy");
			
			String dataStr = formatOut.format(data);
			
			return dataStr;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
