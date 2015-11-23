package socadastroevendatambem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import socadastroevendatambem.modelo.Cidade;
import socadastroevendatambem.modelo.Cliente;
import socadastroevendatambem.modelo.Estado;
import socadastroevendatambem.modelo.Genero;

public class ClienteDAO {

	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;

	// INSERE UMA PESSOA NO BANCO
	public String inserir(Cliente cliente) {
		try {
			sql = "insert into pessoa (nome, endereco, cidade, cidade, estado, telefone, email, genero) values (?,?,?,?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getCidade().getId());
			stmt.setString(4, cliente.getEstado().getNome());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(6, cliente.getGerero().getNome());

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
			String sql = "select idpessoa,nome, endereco, cidade_idcidade ,estado, telefone, email, genero from pessoa";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(2));
				cliente.setEndereco(result.getString(3));
				CidadeDAO dao = new CidadeDAO();
				Cidade cidade = dao.buscar(result.getInt(4));
				cliente.setCidade(cidade);
				// cliente.getCidade().getId();
				EstadoDAO daoe = new EstadoDAO();
				Estado estado = daoe.buscar(result.getString(4));
				cliente.setEstado(estado);
				// cliente.setEstado().getNome(); //5
				cliente.setTelefone(result.getString(6));
				cliente.setEmail(result.getString(7));
				// cliente.setGerero().getNome();
				GeneroDAO daog = new GeneroDAO();
				Genero genero = daog.buscar(result.getString(8));
				cliente.setGerero(genero);

				clientes.add(cliente);
			}
			result.close();
			stmt.close();
			return clientes;
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
				cliente.setEndereco(result.getString(3));
				CidadeDAO dao = new CidadeDAO();
				Cidade cidade = dao.buscar(result.getInt(4));
				cliente.setCidade(cidade);
				// cliente.getCidade().getId();
				EstadoDAO daoe = new EstadoDAO();
				Estado estado = daoe.buscar(result.getString(4));
				cliente.setEstado(estado);
				// cliente.setEstado().getNome(); //5
				cliente.setTelefone(result.getString(6));
				cliente.setEmail(result.getString(7));
				// cliente.setGerero().getNome();
				GeneroDAO daog = new GeneroDAO();
				Genero genero = daog.buscar(result.getString(8));
				cliente.setGerero(genero);

			}

			result.close();
			stmt.close();

			return cliente;

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
			String sql = "update cliente set nome=?, endereco=?, cidade=?, estado=?, telefone=?, email=?, genero=? where idpessoa=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getCidade().getId());
			stmt.setString(4, cliente.getEstado().getNome());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(6, cliente.getGerero().getNome());
			stmt.executeUpdate();
			stmt.close();
			return "Cliente alterado com sucesso";
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "ok";
	}

	public Cliente buscar(Integer id, String nome, String endereco, Integer cidade, String estado, String telefone,
			String email, String genero) {
		try {
			String sql = "select * from movimento where nome=? and ciadade=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, endereco);
			stmt.setInt(4, cidade);
			stmt.setString(5, estado);
			stmt.setString(6, telefone);
			stmt.setString(7, email);
			stmt.setString(8, genero);
			ResultSet result = stmt.executeQuery();
			result.next();

			Cliente cliente = new Cliente();
			cliente.setId(result.getInt(1));
			cliente.setNome(result.getString(2));
			cliente.setEndereco(result.getString(3));
			CidadeDAO dao = new CidadeDAO();
			Cidade cidade1 = dao.buscar(result.getInt(4));
			cliente.setCidade(cidade1);
			// cliente.getCidade().getId();
			EstadoDAO daoe = new EstadoDAO();
			Estado estado1 = daoe.buscar(result.getString(4));
			cliente.setEstado(estado1);
			// cliente.setEstado().getNome(); //5
			cliente.setTelefone(result.getString(6));
			cliente.setEmail(result.getString(7));
			// cliente.setGerero().getNome();
			GeneroDAO daog = new GeneroDAO();
			Genero genero1 = daog.buscar(result.getString(8));
			cliente.setGerero(genero1);

			result.close();
			stmt.close();
			return cliente;

		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
