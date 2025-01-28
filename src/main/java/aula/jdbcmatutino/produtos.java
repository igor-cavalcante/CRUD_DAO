package aula.jdbcmatutino;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Produtos")
public class produtos extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e);
        }

        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/loja?useSSL=false","root","")) {
            
            out.println("<h1>Conectado com sucesso</h1>");
            PreparedStatement pstm=con.prepareStatement("select * from produto");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                float valor = rs.getFloat(4);

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
