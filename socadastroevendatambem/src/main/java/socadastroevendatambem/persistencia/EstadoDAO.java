package socadastroevendatambem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import socadastroevendatambem.modelo.Estado;

public class EstadoDAO {
	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;

	// INSERE UM Estado NO BANCO
	public String inserir(Estado estado) {
		try {
			sql = "insert into estado (nome) values (?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, estado.getNome());
			stmt.executeUpdate();

			stmt.close();
			return "Estado cadastrado com sucesso";

		} catch (SQLException ex) {
			Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "Estado n�o cadastrado por algum problema";
	}

	// LISTA OS Estado DO BANCO
	public List<Estado> listar() {
		try {
			String sql = "select nome from estado";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Estado> estados = new ArrayList<>();
			
            	while (result.next()) {
				Estado estado = Estado.valueOf(result.getString(1));
				estados.add(estado);
			}

			result.close();
			stmt.close();
			return estados;
		} catch (SQLException ex) {
			Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public Estado buscar(Integer id) {
		try {
			String sql = "select nome  from estado where idestado = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			result.next();
			Estado estado = Estado.valueOf(result.getString(1));


			result.close();
			stmt.close();
			return estado;

		} catch (SQLException ex) {
			Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public String deletar(Integer id) {
		try {
			con = Conexao.conectar();
			String sql = "delete from estado where idestado=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			if (stmt.execute()) {
				return "Estado deletadao com sucesso";
			} else {
				return null;
			}
		} catch (SQLException ex) {
			return "NO";
		}
	}

	public String alterar(Estado estado) {
		try {
			String sql = "update estado set nome=? where idestado=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, estado.getNome());
			stmt.executeUpdate();

			stmt.close();
			return "Estado alterado com sucesso";
		} catch (SQLException ex) {
			Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "ok";
	}

	public Estado buscar(String nome) {
		try {
			String sql = "select nome from estado where nome = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, nome);
			ResultSet result = stmt.executeQuery();
			Estado estado = Estado.valueOf(result.getString(1));

				result.close();
			stmt.close();
			return estado;

		} catch (SQLException ex) {
			Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
