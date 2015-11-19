package socadastroevendatambem.modelo;

import java.math.BigDecimal;

//Id, código de barras, categoria (LIMPEZA, PEÇAS, ALIMENTAÇÃO, ETC), 
//descrição, unidade (KG, UN, PCT, CX), custo (BigDecimal) e margem de lucro (BigDecimal).
//BigDecimal deve ser utilizado para valores monetários. Nunca deve-se utilizar float e Double
//para valores monetários por causa de erros de arredondamento por ponto flutuante em valores fracionários.

public class Produto {

	private int id;
	private String codBarras;
	private Categoria categoria;
	private String descricao;
	private boolean status;
	private int qtdEstoque;
	private BigDecimal custo;
	private BigDecimal margemLucro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + id + ", descricao=" + descricao + ", categoria=" + categoria + ", status=" + status
				+ ", qtdEstoque=" + qtdEstoque + "]";
	}

}
