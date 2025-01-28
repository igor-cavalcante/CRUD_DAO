package aula.jdbcmatutino.Controle;

import aula.jdbcmatutino.Dao.ErroDao;
import aula.jdbcmatutino.Dao.ProdutoDaoClasse;
import aula.jdbcmatutino.Dao.ProdutoDaoInterface;
import aula.jdbcmatutino.Modelo.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Produtos")
public class ListarProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProdutoDaoInterface dao = new ProdutoDaoClasse();
            List<Produto> produtos = dao.buscar();
            request.setAttribute("Produtos",produtos);
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }


        // Obtém o parâmetro "mensagem" da requisição
        String mensagem = request.getParameter("mensagem");
        // Define o atributo "Mensagem" na requisição para ser utilizado na JSP
        request.setAttribute("Mensagem", mensagem);
        // Despacha para a JSP
        request.getRequestDispatcher("/WEB-INF/Produtos.jsp").forward(request, response);

    }
}
