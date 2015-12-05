package socadastroevendatambem.utils;

import java.util.ArrayList;
import java.util.List;

import socadastroevendatambem.model.Categoria;
import socadastroevendatambem.model.Cidade;
import socadastroevendatambem.model.Cliente;
import socadastroevendatambem.model.Estado;
import socadastroevendatambem.model.Pais;
import socadastroevendatambem.model.Produto;

public class Singleton {

	private static Singleton instancia;
	

	public List<Cliente> clientes = new ArrayList<>();

	

	public Categoria cat = new Categoria();
	public Cidade cidade = new Cidade();
	public Cliente p = new Cliente();
	public Pais pais = new Pais();
	public Estado  estado = null;
	public Produto produto = new Produto();
	
	public boolean statusBotao = true;

	public double valor_bruto = 0;
	public int quantidade = 1;
	public int ultimo_id_pessoa = clientes.size() + 1;
	
	
	public Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized Singleton getInstance(){
		if(instancia == null){
            instancia = new Singleton();
        }
        return instancia;		
	}
	
	
}
