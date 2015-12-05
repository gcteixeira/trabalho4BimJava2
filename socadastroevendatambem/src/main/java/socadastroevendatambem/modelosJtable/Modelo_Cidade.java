package socadastroevendatambem.modelosJtable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import socadastroevendatambem.model.Cidade;
import socadastroevendatambem.model.Estado;
import socadastroevendatambem.persistencia.CidadeDAO;
import socadastroevendatambem.persistencia.EstadoDAO;

public class Modelo_Cidade extends AbstractTableModel {

	private List<Cidade> cidades = new ArrayList<>();

	private Cidade cidade;

	// Getters and Setters
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	/**
	 * Metodos implementados de AbstractTableModel
	 */
	@Override
	public int getRowCount() {
		return cidades.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return cidades.get(rowIndex).getId();
		case 1:
			return cidades.get(rowIndex).getNome();
		case 2:
			return cidades.get(rowIndex).getEstado();
		default:
			return "Erro";

		}
	}

	@Override
	public String getColumnName(int i) {
		switch (i) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "UF";
		default:
			return "ERRO";
		}
	}

	public Cidade getSelectedObject(int row) {
		return cidades.get(row);
	}
}
