package socadastroevendatambem.modelo;

import java.io.Serializable;

public class Pais implements Serializable {

	private int id;
	private String nome;
	
	public Pais() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	
}