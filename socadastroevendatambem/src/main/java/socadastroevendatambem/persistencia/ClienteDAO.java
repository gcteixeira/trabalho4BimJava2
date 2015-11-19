package socadastroevendatambem.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import socadastroevendatambem.modelo.Cidade;
import socadastroevendatambem.modelo.Cliente;

public class ClienteDAO {
	
	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;

	// INSERE UMA PESSOA NO BANCO
	public String inserir(Cliente cliente) {
		try {
			sql = "insert into pessoa (nome, apelido, tipo, endereco, numero, bairro, cidade_idcidade, telefone, datanasc, cpfcnpj, rginscricao, complemento, contato) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getNumero());
			stmt.setString(6, cliente.getBairro());
			stmt.setInt(7, cliente.getCidade().getId());
			stmt.setString(8, cliente.getTelefone());
			stmt.executeUpdate();
			
			stmt.close();
			return "Pessoa cadastrada com sucesso";

		} catch (SQLException ex) {
			return "ERRO";
		}

		
	}

	// LISTA AS PESSOAS DO BANCO
	public List<Cliente> listar() {
		try {
			String sql = "select idpessoa, nome, apelido, tipo, endereco, numero, bairro, cidade_idcidade, telefone, contato, datanasc, cpfcnpj, rginscricao, complemento from pessoa";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(2));
				cliente.setEndereco(result.getString(5));
				cliente.setNumero(result.getString(6));
				cliente.setBairro(result.getString(7));

				CidadeDAO dao = new CidadeDAO();
				Cidade cidade = dao.buscar(result.getInt(8));
				cliente.setCidade(cidade);

				cliente.setTelefone(result.getString(9));


				clientes.add(cliente);
			}
			result.close();
			stmt.close();
			return clientes;
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} 
		return null;
	}

	public Cliente buscar(Integer id) {
		try {
			
			String sql = "select * from cliente where idcliente = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			Cliente cliente = new Cliente();
			while (result.next()) {
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(2));
				cliente.setEndereco(result.getString(5));
				cliente.setNumero(result.getString(6));
				cliente.setBairro(result.getString(7));

				CidadeDAO dao = new CidadeDAO();
				Cidade cidade = dao.buscar(result.getInt(8));
				cliente.setCidade(cidade);

				cliente.setTelefone(result.getString(9));


				
			}
			
			result.close();
			stmt.close();
			
			return cliente;
			
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return null;
	}

	public String deletar(Integer id) {
		try {
			
			String sql = "delete from cliente where idcliente=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id.intValue());
			if (stmt.execute()) {
				stmt.close();
				return "Cliente deletado com sucesso";
			} else {
				return null;
			}
		} catch (SQLException ex) {
			return "NO";
		}
	}

	public String alterar(Cliente cliente) {
		try {
			con = Conexao.conectar();
			String sql = "update cliente set nome=?, apelido=?, datanasc=?, rginscricao=?, cpfcnpj=?, endereco=?, numero=?, bairro=?, cidade_idcidade=?, telefone=?, complemento=?, tipo=?, contato=? where idpessoa=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getNumero());
			stmt.setString(8, cliente.getBairro());
			stmt.setInt(9, cliente.getCidade().getId());
			stmt.setString(10, cliente.getTelefone());
			stmt.setInt(14, cliente.getId());
			stmt.executeUpdate();
			
			stmt.close();
			return "Cliente alterado com sucesso";
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} 
		return "ok";
	}


	public Cliente buscar(Integer id, String nome, Byte tipo, String apelido,
			String rua, String numero, String bairro, String cidade,
			String telefone, String contato) {
		try {
			String sql = "select * from movimento where nome=? and uf=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setByte(3, tipo);
			stmt.setString(4, apelido);
			stmt.setString(5, rua);
			stmt.setString(6, numero);
			stmt.setString(7, bairro);
			stmt.setString(8, cidade);
			stmt.setString(9, telefone);
			stmt.setString(10, contato);
			ResultSet result = stmt.executeQuery();
			result.next();
			Cliente cliente = new Cliente();
			cliente.setId(new Integer(result.getInt(1)));
			cliente.setNome(new String(result.getString(2)));
		 // cliente.setRua(new String(result.getString(5)));
			cliente.setNumero(new String(result.getString(6)));
			cliente.setBairro(new String(result.getString(7)));

			CidadeDAO dao = new CidadeDAO();
			Cidade cid = dao.buscar(result.getInt(8));
			cliente.setCidade(cid);

			cliente.setTelefone(new String(result.getString(9)));

			
			result.close();
			stmt.close();
			return cliente;

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} 
		return null;
	}
	
	
	
	
}
