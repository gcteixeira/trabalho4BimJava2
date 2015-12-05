package socadastroevendatambem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import socadastroevendatambem.model.Movimento;
import socadastroevendatambem.model.MovimentoProduto;

public class MovimentoProdutoDAO {

	Connection con = ConexaoSing.con;
	PreparedStatement stmt;
	String sql;
	
	public String inserir(MovimentoProduto mp) {
	
		try {
			sql = "insert into movimentoproduto (idmovimento,quantidade, valorund) values((select max(idmovimento) from movimento),?,?,?,?,?);" ;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mp.getMovimento().getId());
			stmt.setObject(2, mp.getQuantidade());
			stmt.setDouble(3, mp.getValorund());
			stmt.executeUpdate();
			
			stmt.close();
			
			return "Sucesso";
		
		} catch (SQLException e) {
			Logger.getLogger(MovimentoProdutoDAO.class.getName()).log(Level.SEVERE,
					null, e);
		}
		return null;
	}
	
	public List<MovimentoProduto> listar() {
		
		try {
			String sql = "select id, idmovimento,quantidade, valorund from movimentoproduto;";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			List<MovimentoProduto> lista = new ArrayList<>();
			while (result.next()) {
				MovimentoProduto mp = new MovimentoProduto();
				mp.setId(result.getInt(1));
				
				MovimentoDAO mdao = new MovimentoDAO();
				Movimento m = mdao.buscar(result.getInt(2));
				mp.setMovimento(m);
				
				mp.setQuantidade(result.getInt(3));
				mp.setValorund(result.getDouble(4));
				lista.add(mp);
			}
			result.close();
			stmt.close();
			return lista;
		} catch (SQLException e) {
			Logger.getLogger(MovimentoProdutoDAO.class.getName()).log(Level.SEVERE,
					null, e);
		}	
		return null;
	}
	
}
