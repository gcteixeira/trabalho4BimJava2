package socadastroevendatambem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import socadastroevendatambem.modelo.Genero;

public class GeneroDAO {
	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;

	// INSERE UM Genero NO BANCO
	public String inserir(Genero genero) {
		try {
			sql = "insert into genero (nome) values (?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.executeUpdate();

			stmt.close();
			return "Genero cadastrado com sucesso";

		} catch (SQLException ex) {
			Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "Genero n�o cadastrado por algum problema";
	}

	// LISTA OS Genero DO BANCO
	public List<Genero> listar() {
		try {
			String sql = "select nome from genero";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Genero> generos = new ArrayList<>();
			
            	while (result.next()) {
				Genero genero = Genero.valueOf(result.getString(1));
				generos.add(genero);
			}

			result.close();
			stmt.close();
			return generos;
		} catch (SQLException ex) {
			Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public Genero buscar(Integer id) {
		try {
			String sql = "select nome  from genero where idgenero = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			result.next();
			Genero genero = Genero.valueOf(result.getString(1));


			result.close();
			stmt.close();
			return genero;

		} catch (SQLException ex) {
			Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public String deletar(Integer id) {
		try {
			con = Conexao.conectar();
			String sql = "delete from genero where idgenero=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			if (stmt.execute()) {
				return "Genero deletadao com sucesso";
			} else {
				return null;
			}
		} catch (SQLException ex) {
			return "NO";
		}
	}

	public String alterar(Genero genero) {
		try {
			String sql = "update genero set nome=? where idgenero=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.executeUpdate();

			stmt.close();
			return "Genero alterado com sucesso";
		} catch (SQLException ex) {
			Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "ok";
	}

	public Genero buscar(String nome) {
		try {
			String sql = "select nome from genero where nome = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, nome);
			ResultSet result = stmt.executeQuery();
			Genero genero = Genero.valueOf(result.getString(1));

				result.close();
			stmt.close();
			return genero;

		} catch (SQLException ex) {
			Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
