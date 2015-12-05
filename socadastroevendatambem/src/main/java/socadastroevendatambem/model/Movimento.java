package socadastroevendatambem.model;

import java.io.Serializable;
import java.util.Date;

public class Movimento implements Serializable {

	private int id;
	private Cliente pessoa;
	private Date data_venda;
	private int operacao; //se 0 compra, se 1 venda
	
	public Movimento(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getPessoa() {
		return pessoa;
	}

	public void setPessoa(Cliente pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	@Override
	public String toString() {
		return "Movimento [id=" + id + ", pessoa=" + pessoa
				+ ", formaPagamento=" +  ", condicaoPagamento="
				+ ", data_venda=" + data_venda
				+ ", operacao=" + operacao + "]";
	}
	
	

	
}
