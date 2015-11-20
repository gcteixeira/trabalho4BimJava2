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
import socadastroevendatambem.modelo.Movimento;
import socadastroevendatambem.modelo.Cliente;
import socadastroevendatambem.modelo.Produto;

public class MovimentoDAO {
	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;

	public String inserir(Movimento movimento) {
		try {
			sql = "insert into movimento (idforma, idpessoa) values (?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setInt(2, movimento.getPessoa().getId());
			stmt.executeUpdate();

			stmt.close();
			return "Movimento cadastrada com sucesso";

		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return "Movimento n�o cadastrada por algum problema";
	}

	public List<Movimento> listar() {
		try {
			String sql = "select idmovimento, idforma, idpessoa from movimento";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<Movimento> movimentos = new ArrayList<>();
			while (result.next()) {
				Movimento m = new Movimento();
				m.setId(result.getInt(1));
				

				
				ClienteDAO pdao = new ClienteDAO();
				Cliente p = pdao.buscar(result.getInt(3));
				m.setPessoa(p);
				

				movimentos.add(m);
			}
			result.close();
			stmt.close();
			return movimentos;
		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} 
		return null;
	}

	public Movimento buscar(Integer id) {
		try {
			String sql = "select * from movimento where idmovimento = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Movimento m = new Movimento();
				m.setId(result.getInt(1));
				
				ClienteDAO pdao = new ClienteDAO();
				Cliente p = pdao.buscar(result.getInt(2));
				m.setPessoa(p);

				
				m.setData_venda(result.getDate(3));
				m.setOperacao(result.getInt(4));
				
				return m;
				
			}
			result.close();
			stmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	public String deletar(Integer id) {
		try {
			
			String sql = "delete from movimento where id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id.intValue());
			if (stmt.execute()) {
				stmt.close();
				return "Movimento deletadao com sucesso";
			} else {
				return "problemas com a dele��o";
			}
		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} 
		return null;
	}

	public String alterar(Movimento movimento) {
		try {
			con = Conexao.conectar();
			String sql = "update movimento set nome=?,uf=? where id=?";
			stmt = con.prepareStatement(sql);
			// stmt.setString(1,movimento.getCodigo());
			// stmt.setString(2,movimento.getPessoa());
			// stmt.setString(3,movimento.getProduto());
			// stmt.setString(4,movimento.getFormaPagamento());
			// stmt.setString(5,movimento.getCondicaoPagamento());
			stmt.executeUpdate();
			return "movimento alterado com sucesso";
		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} 
		return "ok";
	}

	
	public Movimento buscar(Integer codigo, String Pessoa, String Produto,
			String Formapagamento, String CondicaoPagamento) {
		try {
			con = Conexao.conectar();
			String sql = "select * from movimento where nome=? and uf=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, codigo);
			stmt.setString(2, Pessoa);
			stmt.setString(3, Produto);
			ResultSet result = stmt.executeQuery();
			result.next();
			Movimento movimento = new Movimento();
			// movimento.setCodigo(result.getInt(1));
			// movimento.setPessoa(result.getString(2));
			// movimento.setProduto(result.getString(3));
			// movimento.setCondicaoPagamento(result.getString(4));
			// movimento.setFormaPagamento(result.getString(5));

			return movimento;

		} catch (SQLException ex) {
			Logger.getLogger(MovimentoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} 
		return null;
	}
}
