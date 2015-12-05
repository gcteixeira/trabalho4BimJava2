package socadastroevendatambem.modelosJtable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import socadastroevendatambem.model.Estado;
import socadastroevendatambem.model.Pais;

public class Modelo_Estado extends AbstractTableModel {

	private List<Estado> estado = new ArrayList<>();


	public List<Estado> getEstado() {
		return estado;
	}
	
	public void setUfs(List<Estado> estado) {
		this.estado = estado;
	}
	

	@Override
	public int getRowCount() {
		return estado.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
		case 0:
			return estado.get(rowIndex).getNome();
		default:
			return "Erro";
			
		}
	}
	
	 @Override
	    public String getColumnName(int i){
	        switch(i){
	            case 0:
	                return "Nome";
	            default:
	                return "ERRO";
	        }
	    }
	 public Estado getSelectedObject(int row) {  
	     return estado.get(row);  
	}  

}
