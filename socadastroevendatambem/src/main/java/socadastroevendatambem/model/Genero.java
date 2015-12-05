package socadastroevendatambem.model;

public enum Genero {

	F("Feminino"), //
	M("Masculino"); //


	private String nome;

	public String getNome() {
		return nome;
	}

	private Genero(String nome) {
		this.nome = nome;
	}
	
	public void setNome(String string) {
		this.nome = string;
		
	}
	
}
