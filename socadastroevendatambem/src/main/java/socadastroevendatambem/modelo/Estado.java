package socadastroevendatambem.modelo;

public enum Estado {
	
	AC("Acre"), // 
	AL("Alagoas"), // 
	AP("Amapá"), // 
	AM("Amazonas"), // 
	BA("Bahia"), // 
	CE("Ceará"), // 
	DF("Distrito Federal"), // 
	ES("Espírito Santo"), // 
	GO("Goiás"), // 
	MA("Maranhão"), // 
	MT("Mato Grosso"), // 
	MS("Mato Grosso do Sul"), // 
	MG("Minas Gerais"), // 
	PA("Pará"), // 
	PB("Paraíba"), // 
	PR("Parana"), //
	PE("Pernambuco"), // 
	PI("Piauí"), // 
	RR("Roraima"), // 
	RO("Rondônia"), // 
	RJ("Rio de Janeiro"), // 
	RN("Rio Grande do Norte"), // 
	RS("Rio Grande do Sul"), // 
	SC("Santa Catarina"), // 
	SP("São Paulo"), // 
	SE("Sergipe"), // 
	TO ("Tocantins");// 
	
	private String nome;

	public String getNome() {
		return nome;
	}

	Estado(String nome) {
		this.nome = nome;
	}

	public void setNome(String string) {
		this.nome = string;
		
	}
	
	
	
}
