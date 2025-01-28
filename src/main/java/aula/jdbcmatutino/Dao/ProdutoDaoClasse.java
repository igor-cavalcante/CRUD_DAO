package aula.jdbcmatutino.Dao;

import aula.jdbcmatutino.Modelo.Produto;
import com.sun.source.tree.TryTree;

import java.util.List;
import java.sql.*;
public class ProdutoDaoClasse implements ProdutoDaoInterface{

    Connection conn;

   public ProdutoDaoClasse() throws ErroDao {
     conn=ConexaoDB.getConexao();
   }

    @Override
    public void insert(Produto produto) throws ErroDao {
       PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement("insert into produto(nome,descricao,valor) values(?,?,?)");
            psmt.setString(1, produto.getNome());
            psmt.setString(2, produto.getDescricao());
            psmt.setFloat(3,produto.getPreco());
            psmt.executeUpdate();
            ResultSet rs=psmt.getGeneratedKeys();

            if(rs.next())
                produto.setId(rs.getInt(1));

            psmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Produto buscar(int codigo) throws ErroDao {
        return null;
    }

    @Override
    public List<Produto> lista() throws ErroDao {
        return List.of();
    }

    @Override
    public void deleta(int codigo) throws ErroDao {

    }

    @Override
    public void sair() throws ErroDao {

    }
}
