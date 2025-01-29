package aula.jdbcmatutino.Dao;

import aula.jdbcmatutino.Modelo.Produto;
import com.sun.source.tree.TryTree;

import java.util.ArrayList;
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
            psmt = conn.prepareStatement("insert into produto(nome,descricao,valor) values(?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, produto.getNome());
            psmt.setString(2, produto.getDescricao());
            psmt.setFloat(3,produto.getPreco());
            psmt.executeUpdate();
            ResultSet rs=psmt.getGeneratedKeys();

            if(rs.next())
                produto.setId(rs.getInt(1));

            System.out.println("Produto inserido com sucesso "+produto);

            psmt.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Produto buscar(int codigo) throws ErroDao {
            Produto p = new Produto();
       try {
           PreparedStatement psmt = conn.prepareStatement("Select * from produto where id = ?");
           psmt.setInt(1,codigo);
           ResultSet rs = psmt.executeQuery();

           if(rs.next()){
           p.setId(rs.getInt("id"));
           p.setNome(rs.getString("nome"));
           p.setDescricao(rs.getString("descricao"));
           p.setPreco(rs.getFloat("valor"));
           }

           rs.close();
           psmt.close();

       } catch (SQLException e) {
           throw new ErroDao(e);
       }

       return p;
    }

    @Override
    public void editar(Produto produto , int codigo) throws ErroDao {

        PreparedStatement psmt = null;

        try {
            psmt = conn.prepareStatement("update produto set nome = ?, descricao = ? , valor = ? where id = ?");
            psmt.setString(1, produto.getNome());
            psmt.setString(2, produto.getDescricao());
            psmt.setFloat(3, produto.getPreco());
            psmt.setInt(4, codigo);
            psmt.executeUpdate();
            psmt.close();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<Produto> buscar() throws ErroDao {

        List<Produto> produtos = new ArrayList<>();

        try {
            PreparedStatement psmt = conn.prepareStatement("SELECT * from produto");
            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("valor"));

                produtos.add(p);
            }
            psmt.close();

        } catch ( SQLException e) {
            throw new ErroDao(e);
        }
        return produtos;
    }

    @Override
    public void deleta(int codigo) throws ErroDao {

       try {
           PreparedStatement psmt = conn.prepareStatement("delete from produto where id = ?");
           psmt.setInt(1, codigo);
           psmt.executeUpdate();

           psmt.close();
       }catch (SQLException e ){
           throw new ErroDao(e);
       }
    }

    @Override
    public void sair() throws ErroDao {

    }
}
