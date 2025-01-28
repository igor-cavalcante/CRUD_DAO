package aula.jdbcmatutino;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Cadastro", value = "/Cadastro")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String name = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Integer id = Integer.parseInt(request.getParameter("valor"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e);
        }

        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loja?useSSL=false","root","")) {

            String sql = "Insert into produto (nome, descricao, valor) values (?,?,?)";

                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, name);
                smt.setString(2, descricao);
                smt.setInt(3, id);
                smt.executeUpdate();
                out.println("Dados inseridos com sucesso!");



            /*Statement stm=con.createStatement();
            stm.executeUpdate("INSERT INTO `produto` (`nome`,`descricao`,`preco`) VALUES (\""+nome+"\",\""+descricao+"\","+valor+")");
            out.println("<p>Inserido com sucesso</p>");*/

//            PreparedStatement pstm=con.prepareStatement("INSERT INTO `produto` (`nome`,`descricao`,`preco`) VALUES (?,?,?)");
//            pstm.setString(1,nome);
//            pstm.setString(2,descricao);
//            pstm.setFloat(3,preco);
//            pstm.executeUpdate();
//            out.println("<p>Inserido com sucesso</p>");
        } catch ( SQLException e) {
            out.println(e);
        }
        out.println("</body></html>");

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e);
        }

        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loja?useSSL=false","root","")) {


            out.println("<h1>Conectado com sucesso</h1>");

            /*Statement stm=con.createStatement();
            String nome="Livro de Matemática";
            String descricao="O melhor livro de matemática do mundo";
            float valor=400;


            /*String consulta="borracha\" or true  or \".";
            ResultSet rs=stm.executeQuery("select * from produto where nome=\""+consulta+"\"");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString(2);
                String descricao = rs.getString("descricao");
                float preco = rs.getFloat("preco");

                out.println("<p>Código: " + id + "<br>Nome: " + nome + "<br>Descrição: " + descricao + "<br>Preço: " + preco);
            }
            rs.close();
            stm.close();
            */

            /*String nome="Pasta";
            String descricao="Pasta de plastico de 30 cm";
            float preco=5.5f;
            PreparedStatement pstm=con.prepareStatement("INSERT INTO `produto` (`nome`,`descricao`,`preco`) VALUES (?,?,?)");
            pstm.setString(1,nome);
            pstm.setString(2,descricao);
            pstm.setFloat(3,preco);
            pstm.executeUpdate();
            out.println("<p>Inserido com sucesso</p>");*/

            String consulta="dasd";
            PreparedStatement pstm=con.prepareStatement("select * from produto where nome=?");
            pstm.setString(1,consulta);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString(2);
                String descricao = rs.getString("descricao");
                float valor = rs.getFloat("valor");

                out.println("<p>Código: " + id + "<br>Nome: " + nome + "<br>Descrição: " + descricao + "<br>Preço: " + valor);
            }
            rs.close();
            pstm.close();
        } catch ( SQLException e) {
            out.println(e);
        }

        out.println("</body></html>");
    }
}